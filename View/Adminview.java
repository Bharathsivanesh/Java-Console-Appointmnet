//package View;
//import Controller.Admincontroller;
//import model.AdminDTO;
//import Util.Input;
//
//public class Adminview extends Input {
//    public static void showlogin()
//    {
//        System.out.println("Enter Admin I'D");
//        int user_id=sc.nextInt();
//        System.out.println("Enter Admin Password");
//        String password=sc.next();
//        AdminDTO admin=Admincontroller.getinstance().adminlogin(user_id,password);
//        if(admin!=null)
//        {
//            System.out.println("Sucessfully Admin logged in ");
//
//            System.out.println("WELCOME ADMIN");
//            while(true)
//            {
//                System.out.println("---------------------------");
//                System.out.println("1)Add Doctor");
//                System.out.println("2)Add Receptionist");
//                System.out.println("3)Add HospitalDetails");
//                System.out.println("4)Log out");
//                System.out.println("---------------------------");
//                int n=sc.nextInt();
//                 switch (n)
//                 {
//                     case 1:
//                         adddoctor();
//                         break;
//                     case 2:
//                         addreceptionist();
//                         break;
//                     case 3:
//                         addhospitaldetail();
//                         break;
//                     case 4:
//                         return;
//
//                     default:
//                         System.out.println("Enter Valid No");
//
//                 }
//            }
//
//        }
//        else {
//            System.out.println("Unable to login Retry");
//        }
//    }
//    public static void adddoctor()
//    {
//        System.out.println("Enter Doctor Details");
//        System.out.println("Set I'D ");
//        int id=sc.nextInt();
//        System.out.println("Set Password");
//        String pass=sc.next();
//        System.out.println("Enter Name");
//        String name=sc.next();
//        System.out.println("Enter Department");
//        String dept=sc.next();
//        boolean available =true;
//        System.out.println("Enter Email");
//        String email=sc.next();
//        System.out.println("Enter Conatact_No ");
//        String number=sc.next();
//        System.out.println("Enter Room I'D");
//        int roomid=sc.nextInt();
//        if(Admincontroller.getinstance().Adddoctor(id,pass,name,dept,available,email,number,roomid))
//        {
//            System.out.println("Sucessfully Doctor Detail Inserted");
//        }
//        else {
//            System.out.println("I'D alredy Exists");
//        }
//
//    }
//    public static void addreceptionist()
//    {
//        System.out.println("Enter Receptionist Details");
//        System.out.println("Set I'D ");
//        int id=sc.nextInt();
//        System.out.println("Set Password");
//        String pass=sc.next();
//        System.out.println("Enter Shifting Time (e.g.9AM-5PM):");
//        String shiftingTime = sc.next();
//        System.out.println("Enter Role");
//        String role=sc.next();
//        System.out.println("Enter Email");
//        String email=sc.next();
//        System.out.println("Enter Name");
//        String name=sc.next();
//        System.out.println("Enter Conatact_No");
//        String number=sc.next();
//
//        if(Admincontroller.getinstance().Addreceptionist(id,pass,shiftingTime,role,email,name,number))
//        {
//            System.out.println("Sucessfully Receptionist Detail Inserted");
//        }
//        else {
//            System.out.println("I'D alredy Exists");
//        }
//    }
//
//    public static void addhospitaldetail()
//    {
//        System.out.println("Enter Hospital Details");
//        System.out.println("Set I'D ");
//        int id=sc.nextInt();
//        System.out.println("Enter Name");
//        String name=sc.next();
//        System.out.println("Enter Total_Doctor ");
//        int doc_count=sc.nextInt();
//        System.out.println("Enter Email");
//        String email=sc.next();
//        System.out.println("Enter Conatact_No");
//        String number=sc.next();
//        String working_hrs="24/7";
//        System.out.println("Enter Address");
//        String address=sc.nextLine();
//        if(Admincontroller.getinstance().Addhospitaldetails(id,name,doc_count,email,number,working_hrs,address))
//        {
//            System.out.print("Sucessfully Hospital Detail Inserted");
//        }
//        else {
//            System.out.print("I'D alredy Exists");
//        }
//
//
//
//
//    }
//
//
//
//}

package View;

import Controller.Admincontroller;
import model.AdminDTO;
import Util.Input;

import java.util.regex.Pattern;

public class Adminview extends Input {

    public static void showlogin() {

        int user_id =  getValidatedNumber("Enter Admin ID:");
        System.out.println("Enter Admin Password: ");
        String password = sc.next();

        AdminDTO admin = Admincontroller.getinstance().adminlogin(user_id, password);
        if (admin != null) {
            System.out.println("Successfully Admin logged in");
            System.out.println("WELCOME ADMIN");

            while (true) {
                System.out.println("---------------------------");
                System.out.println("1) Add Doctor");
                System.out.println("2) Add Receptionist");
                System.out.println("3) Add Hospital Details");
                System.out.println("4) Log out");
                System.out.println("---------------------------");
                int n = getValidatedNumber("Enter Option:" );

                switch (n) {
                    case 1 -> adddoctor();
                    case 2 -> addreceptionist();
                    case 3 -> addhospitaldetail();
                    case 4 -> { return; }
                    default -> System.out.println("Enter Valid Option");
                }
            }
        } else {
            System.out.println("Invalid I'D credentials");
        }
    }

    public static void adddoctor() {
        System.out.println("Enter Doctor Details");

        int id =  getValidatedNumber("Set ID: ");
        System.out.print("Set Password: ");
        String pass = sc.next();

        String name = getValidString("Enter Name: ");
        String dept = getValidString("Enter Department: ");
        boolean available = true;

        String email = getValidEmail("Enter Email: ");
        String number = getValidPhone("Enter Contact No: ");
        int roomid =  getValidatedNumber("Enter Room ID: ");

        if (Admincontroller.getinstance().Adddoctor(id, pass, name, dept, available, email, number, roomid)) {
            System.out.println("Successfully Doctor Detail Inserted");
        } else {
            System.out.println("ID already exists");
        }
    }

    public static void addreceptionist() {
        System.out.println("Enter Receptionist Details");

        int id = getValidatedNumber("Set ID: ");
        System.out.print("Set Password: ");
        String pass = sc.next();

        String shiftingTime =getValidTimeRange("Enter Shifting Time (e.g. 9AM-5PM): ");
        String role = getValidString("Enter Role: ");
        String email = getValidEmail("Enter Email: ");
        String name = getValidString("Enter Name: ");
        String number = getValidPhone("Enter Contact No: ");

        if (Admincontroller.getinstance().Addreceptionist(id, pass, shiftingTime, role, email, name, number)) {
            System.out.println("Successfully Receptionist Detail Inserted");
        } else {
            System.out.println("ID already exists");
        }
    }

    public static void addhospitaldetail() {
        System.out.println("Enter Hospital Details");

        int id =  getValidatedNumber("Set ID: ");
        String name = getValidString("Enter Hospital Name: ");
        int doc_count = getValidatedNumber("Enter Total Doctors: ");
        String email = getValidEmail("Enter Email: ");
        String number = getValidPhone("Enter Contact No: ");
        String working_hrs = "24/7";
        sc.nextLine(); // clear scanner buffer
        System.out.print("Enter Address: ");
        String address = sc.nextLine();

        if (Admincontroller.getinstance().Addhospitaldetails(id, name, doc_count, email, number, working_hrs, address)) {
            System.out.println("Successfully Hospital Detail Inserted");
        } else {
            System.out.println("ID already exists");
        }
    }

    // ================== Validation Helper Methods ==================

    public static int getValidatedNumber(String message) {
        int num;
        while (true) {
            System.out.println(message);
            if (sc.hasNextInt()) {
                num = sc.nextInt();
                break;
            } else {
                System.out.println("Enter valid number");
                sc.next(); // clear wrong input
            }
        }
        return num;
    }


    public static String getValidString(String message) {
        System.out.println(message);
        String input = sc.next();
        while (input.trim().isEmpty() || !Pattern.matches("^[A-Za-z]+$", input)) {
            System.out.println("Invalid input. Please enter only letters. " + message);
            input = sc.next();
        }
        return input;
    }

    public static String getValidTimeRange(String message) {

        System.out.println(message);
        String input = sc.next();

        // Regex: Matches patterns like 9AM-5PM, 08AM-06PM, etc.
        while (!Pattern.matches("^(0?[1-9]|1[0-2])([AP]M)-(0?[1-9]|1[0-2])([AP]M)$", input)) {
            System.out.println("Invalid time format. Please enter in format like 9AM-5PM.");
            System.out.print(message);
            input = sc.next();
        }

        return input;
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
}
