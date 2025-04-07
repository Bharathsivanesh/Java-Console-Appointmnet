package View;

import Controller.Appointmentcontroller;
import Controller.Doctocontroller;
import Controller.Receptionistcontroller;
import model.AppointmentDTO;
import model.DoctorDTO;
import Util.Input;
import java.util.regex.Pattern;
import java.util.ArrayList;
import java.util.List;

public class ReceptionistView extends Input {

    public static void login() {
        int id = getValidInt("Enter Your ID: ");
        System.out.print("Enter Your Password: ");
        String pass = sc.next();

        if (Receptionistcontroller.getInstance().receptlogin(id, pass)) {
            System.out.println("Successfully Logged-In");
            while (true) {
                System.out.println("1) View Doctors Availability");
                System.out.println("2) View All Appointments");
                System.out.println("3) Make Schedule");
                System.out.println("4) Reject Schedule");
                System.out.println("5) Log-out");
                int n = getValidInt("Choose an option (1-5): ");

                switch (n) {
                    case 1:
                        checkdocavail();
                        break;
                    case 2:
                        viewappointment();
                        break;
                    case 3:
                        scheduleappo();
                        break;
                    case 4:
                        rejectappointment();
                        break;
                    case 5:
                        return;
                    default:
                        System.out.println("Enter Valid Number Between 1 and 5");
                        break;
                }
            }
        } else {
            System.out.println("Invalid ID or Password");
        }
    }

    public static void scheduleappo() {
        int doc_id = getValidInt("Enter Doctor ID: ");
        int pat_id = getValidInt("Enter Patient ID: ");
        String time = getValidTime("Enter Time (e.g. 9AM-5PM): ");
        String date = getValidDate("Enter Date (YYYY-MM-DD): ");

        if (Appointmentcontroller.getinstance().makeschedule(doc_id, pat_id, time, date)) {
            System.out.println("Successfully Scheduled");
        } else {
            System.out.println("Something went wrong");
        }
    }

    public static void rejectappointment() {
        int id = getValidInt("Enter Appointment ID to Reject: ");
        System.out.println("------------------------------------------------");
        if (Appointmentcontroller.getinstance().rejectappo(id)) {
            System.out.println("Appointment: " + id + " rejected");
        } else {
            System.out.println("Something went wrong");
        }
        System.out.println("------------------------------------------------");
    }

    public static void checkdocavail() {
        List<DoctorDTO> lst = Doctocontroller.getinstance().getdoctor();
        if (lst.isEmpty()) {
            System.out.println("No Doctor available");
        } else {
            System.out.println("------------------------------------------------");
            System.out.println("Checking Doctor Availability");
            for (DoctorDTO doctors : lst) {
                System.out.println("Doctor ID      : " + doctors.getId());
                System.out.println("Available      : " + (doctors.isAvailable() ? "Yes" : "No"));
                System.out.println("------------------------------------------------");
            }
        }
    }

    public static void viewappointment() {
        ArrayList<AppointmentDTO> lst = Appointmentcontroller.getinstance().getdocappointment();
        System.out.println("--------------------------------------");
        if (lst.isEmpty()) {
            System.out.println("No Appointments Yet");
        } else {
            for (AppointmentDTO obj : lst) {
                System.out.println("--------------------------------------");
                System.out.println("Appointment ID         : " + obj.getAppo_id());
                System.out.println("Doctor ID              : " + obj.getDoc_id());
                System.out.println("Patient ID             : " + obj.getPat_id());
                System.out.println("Appointment Status     : " + obj.isAppo_status());
                System.out.println("Appointment Time       : " + obj.getTime());
                System.out.println("Appointment Date       : " + obj.getDate());
                System.out.println("Appointment Room       : " + (obj.getRoom_id() == 0 ? "Not Allocated" : obj.getRoom_id()));
                System.out.println("Appointment Register Time: " + obj.getRegister_time());
                System.out.println("--------------------------------------");
            }
        }
    }

//    helper validation methods

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
}
