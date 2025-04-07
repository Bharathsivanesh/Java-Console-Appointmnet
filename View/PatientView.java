package View;

import java.util.*;
import java.util.regex.Pattern;

import Controller.Doctocontroller;
import Controller.Appointmentcontroller;
import Controller.Patientcontroller;
import Util.Cookie;
import model.AppointmentDTO;
import model.DoctorDTO;
import Util.Input;

public class PatientView extends Input {

    private static Patientcontroller instance = Patientcontroller.getInstance();

    public static void Patientreigister() {
        System.out.println("Enter Your Details");

        int id = getValidInt("Enter Your ID: ");
        System.out.print("Enter Your Password: ");
        String pass = sc.next();

        String email = getValidEmail("Enter Email: ");

        int age = getValidAge("Enter Your Age: ");
        String gender = getValidGender("Enter Your Gender: ");
        String phonenumber =getValidPhone("Enter Phone Number: ");
        String blood_group = getValidBloodGroup("Enter Blood Group: ");

        if (instance.Patientregister(id, pass, email, age, gender, phonenumber, blood_group)) {
            System.out.println("Successfully registered");
        } else {
            System.out.println("ID already exists");
        }
    }

    public static void PatientLogin() {
        int id = getValidInt("Enter Your ID: ");
        System.out.print("Enter Your Password: ");
        String pass = sc.next();

        if (instance.Patientlogin(id, pass)) {
            Cookie.getinstance().setter_userid(id);
            System.out.println("Successfully Logged In");
            while (true) {
                System.out.println("1) View Doctor Details");
                System.out.println("2) Make Appointment");
                System.out.println("3) View Appointments");
                System.out.println("4) Log Out");
                int n = getValidInt("Choose an option (1-4): ");
                switch (n) {
                    case 1:
                        displaydoctor();
                        break;
                    case 2:
                        makeappointment();
                        break;
                    case 3:
                        viewapoointment();
                        break;
                    case 4:
                        Cookie.getinstance().clear_session();
                        return;
                    default:
                        System.out.println("Enter a valid number between 1 and 4");
                        break;
                }
            }
        } else {
            System.out.println("Invalid credentials");
        }
    }

    public static void makeappointment() {
        System.out.println("-------------Enter Appointment Details----------");
        int doc_id = getValidInt("Enter Doctor ID: ");
        int pat_id = Cookie.getinstance().getter_userid();
        String status = "Not Viewed";
        String time = getValidTime("Enter Time (e.g. 9AM-11AM): ");
        String date = getValidDate("Enter Date (YYYY-MM-DD): ");

        if (Appointmentcontroller.getinstance().setappointment(doc_id, pat_id, status, time, date, 0)) {
            System.out.println("Successfully Registered");
        } else {
            System.out.println("Try Again");
        }
    }

    public static void viewapoointment() {
        List<AppointmentDTO> lst = Appointmentcontroller.getinstance().getappointmentdetails();
        System.out.println("------------------------------------------------");
        if (lst.isEmpty()) {
            System.out.println("No Appointments Yet");
        } else {
            System.out.println("Appointment Details:");
            for (AppointmentDTO appo : lst) {
                System.out.println("------------------------------------------------");
                System.out.println("Appointment ID     : " + appo.getAppo_id());
                System.out.println("Doctor ID          : " + appo.getDoc_id());
                System.out.println("Patient ID         : " + appo.getPat_id());
                System.out.println("Status             : " + appo.isAppo_status());
                System.out.println("Time               : " + appo.getTime());
                System.out.println("Date               : " + appo.getDate());
                System.out.println("Register Time      : " + appo.getRegister_time());
                System.out.println("Room ID            : " + (appo.getRoom_id() == 0 ? "Not Allocated" : appo.getRoom_id()));
            }
        }
    }

    public static void displaydoctor() {
        List<DoctorDTO> lst = Doctocontroller.getinstance().getdoctor();
        if (lst.isEmpty()) {
            System.out.println("No Doctor Available");
        } else {
            System.out.println("------------------------------------------------");
            System.out.println("Doctor Details:");
            for (DoctorDTO doctors : lst) {
                System.out.println("Doctor ID      : " + doctors.getId());
                System.out.println("Name           : " + doctors.getName());
                System.out.println("Department     : " + doctors.getDepartment());
                System.out.println("Available      : " + (doctors.isAvailable() ? "Yes" : "No"));
                System.out.println("Email          : " + doctors.getEmail());
                System.out.println("Phone Number   : " + doctors.getPhone_no());
                System.out.println("Room ID        : " + doctors.getRoom_id());
                System.out.println("------------------------------------------------");
            }
        }
    }

    public static int getValidInt(String message) {
        System.out.println(message);
        while (!sc.hasNextInt()) {
            System.out.println("Invalid number. " + message);
            sc.next(); // discard invalid input
        }
        return sc.nextInt();
    }

    public static String getValidString(String message) {
        System.out.println(message);
        String input = sc.next();
        while (input.trim().isEmpty() || input.matches("\\d+")) {
            System.out.println("Invalid input. Only letters allowed. " + message);
            input = sc.next();
        }
        return input;
    }



    public static String getValidTime(String message) {
        System.out.println(message);
        String time = sc.next();
        while (!Pattern.matches("^(0?[1-9]|1[0-2])[APap][Mm]-(0?[1-9]|1[0-2])[APap][Mm]$", time)) {
            System.out.println("Invalid time format. Format should be like 9AM-5PM. " + message);
            time = sc.next();
        }
        return time.toUpperCase();
    }

    public static String getValidDate(String message) {
        System.out.println(message);
        String date = sc.next();
        while (!Pattern.matches("^\\d{4}-\\d{2}-\\d{2}$", date)) {
            System.out.println("Invalid date format. Format should be YYYY-MM-DD. " + message);
            date = sc.next();
        }
        return date;
    }

    public static String getValidEmail(String message) {
        System.out.println(message);
        String email = sc.next();
        while (!Pattern.matches("^[\\w.-]+@[\\w.-]+\\.\\w{2,}$", email)) {
            System.out.println("Invalid email format. " + message);
            email = sc.next();
        }
        return email;
    }

    public static String getValidPhone(String message) {
        System.out.println(message);
        String phone = sc.next();
        while (!phone.matches("\\d{10}")) {
            System.out.println("Invalid phone number. Must be 10 digits. " + message);
            phone = sc.next();
        }
        return phone;
    }


    public static int getValidAge(String prompt) {
        while (true) {
            int age = getValidInt(prompt);
            if (age >= 1 && age <= 100) return age;
            System.out.println("Age must be between 1 and 100.");
        }
    }

    public static String getValidGender(String prompt) {
        while (true) {
            System.out.println(prompt);
            String gender = sc.nextLine().trim().toUpperCase();
            if (gender.equals("M") || gender.equals("F")) return gender;
            System.out.println("Enter M for Male or F for Female.");
        }
    }

    public static String getValidBloodGroup(String prompt) {
        while (true) {
            System.out.println(prompt);
            String blood = sc.nextLine().trim().toUpperCase();
            if (blood.matches("A\\+|A-|B\\+|B-|AB\\+|AB-|O\\+|O-")) return blood;
            System.out.println("Enter a valid blood group (A+, A-, B+, B-, AB+, AB-, O+, O-).");
        }
    }

}
