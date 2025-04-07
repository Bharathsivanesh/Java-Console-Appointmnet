//package View;
//
//import Controller.Appointmentcontroller;
//import Controller.Doctocontroller;
//import model.AppointmentDTO;
//import Util.Cookie;
//import Util.Input;
//
//import java.util.ArrayList;
//
//public class DoctorView extends Input {
//
//    public static void Doctorlogin()
//    {
//        System.out.println("Enter Your I'D");
//        int id=sc.nextInt();
//        System.out.println("Enter Your Password");
//        String pass=sc.next();
//        if(Doctocontroller.getinstance().doctorlogin(id,pass))
//        {
//            System.out.println("Sucessfully Logged-In");
//            Cookie.getinstance().setter_docid(id);
//
//            while(true)
//            {
//                System.out.println("1)View My Appointment");
//                System.out.println("2)Update My Availability");
//                System.out.println("3)Log-Out");
//                int k=sc.nextInt();
//                switch (k)
//                {
//                    case 1:
//                        viewmyappointment();
//                        break;
//                    case 2:
//                        updatedocavilability();
//                        break;
//                    case 3:
//                        Cookie.getinstance().clear_docsession();
//                        return;
//
//                    default:
//                        System.out.println("Enter Valid No");
//                        break;
//                }
//
//
//            }
//        }
//        else
//        {
//            System.out.println("Invalid I'D");
//        }
//    }
//    public static void updatedocavilability()
//    {
//        if(Doctocontroller.getinstance().updatedocavilability(Cookie.getinstance().getter_docid()))
//        {
//            System.out.println("------------------------------------------------");
//            System.out.println("Availability Updated sucessfully");
//            System.out.println("------------------------------------------------");
//        }
//        else
//        {
//            System.out.println("Something went wrong");
//        }
//
//    }
//    public static void viewmyappointment()
//    {
//        ArrayList<AppointmentDTO>lst= Appointmentcontroller.getinstance().getdocappointment(Cookie.getinstance().getter_docid());
//        System.out.println("--------------------------------------");
//        if(lst.size()==0)
//        {
//            System.out.println("No Appointment Yet");
//            System.out.println("--------------------------------------");
//        }
//        else {
//            for(AppointmentDTO obj:lst)
//            {
//                System.out.println("--------------------------------------");
//                System.out.println("Appointment I'D :"+obj.getAppo_id());
//                System.out.println("Doctor_Id       :"+obj.getDoc_id());
//                System.out.println("Patient_Id      :"+obj.getPat_id());
//                System.out.println("Appointment_status:"+obj.isAppo_status());
//                System.out.println("Appointment_Time:"+obj.getTime());
//                System.out.println("Appointment_Date:"+obj.getDate());
//                System.out.println("Appointment_room:"+(obj.getRoom_id()==0?"Not Allocated":obj.getRoom_id()));
//                System.out.println("Appo_registerTime:"+obj.getRegister_time());
//                System.out.println("--------------------------------------");
//            }
//        }
//    }
//}
package View;

import Controller.Appointmentcontroller;
import Controller.Doctocontroller;
import model.AppointmentDTO;
import Util.Cookie;
import java.util.ArrayList;
import java.util.Scanner;

public class DoctorView {

    static Scanner sc = new Scanner(System.in);

    public static void Doctorlogin() {
        int id;
        while (true) {
            System.out.println("Enter Your I'D:");
            if (sc.hasNextInt()) {
                id = sc.nextInt();
                break;
            } else {
                System.out.println("Invalid input! Please enter a valid number.");
                sc.next(); // Clear invalid input
            }
        }

        System.out.println("Enter Your Password:");
        String pass = sc.next();

        if (Doctocontroller.getinstance().doctorlogin(id, pass)) {
            System.out.println("Successfully Logged-In");
            Cookie.getinstance().setter_docid(id);

            while (true) {
                System.out.println("1) View My Appointment");
                System.out.println("2) Update My Availability");
                System.out.println("3) Log-Out");


                if (sc.hasNextInt()) {
                    int k = sc.nextInt();
                    switch (k) {
                        case 1:
                            viewmyappointment();
                            break;
                        case 2:
                            updatedocavilability();
                            break;
                        case 3:
                            Cookie.getinstance().clear_docsession();
                            return;
                        default:
                            System.out.println("Enter a valid number between 1 and 3.");
                            break;
                    }
                }
                else {
                    System.out.println("Please enter a valid number 1-3");
                    sc.next();
                }
            }
        }
        else {
            System.out.println("Invalid ID or Password");
        }
    }

    public static void updatedocavilability() {
        if (Doctocontroller.getinstance().updatedocavilability(Cookie.getinstance().getter_docid())) {
            System.out.println("------------------------------------------------");
            System.out.println("Availability Updated Successfully");
            System.out.println("------------------------------------------------");
        } else {
            System.out.println("Something went wrong");
        }
    }

    public static void viewmyappointment() {
        ArrayList<AppointmentDTO> lst = Appointmentcontroller.getinstance().getdocappointment(Cookie.getinstance().getter_docid());
        System.out.println("--------------------------------------");

        if (lst.size() == 0) {
            System.out.println("No Appointment Yet");
            System.out.println("--------------------------------------");
        } else {
            for (AppointmentDTO obj : lst) {
                System.out.println("--------------------------------------");
                System.out.println("Appointment I'D      : " + obj.getAppo_id());
                System.out.println("Doctor_Id            : " + obj.getDoc_id());
                System.out.println("Patient_Id           : " + obj.getPat_id());
                System.out.println("Appointment_status   : " + obj.isAppo_status());
                System.out.println("Appointment_Time     : " + obj.getTime());
                System.out.println("Appointment_Date     : " + obj.getDate());
                System.out.println("Appointment_room     : " + (obj.getRoom_id() == 0 ? "Not Allocated" : obj.getRoom_id()));
                System.out.println("Appo_registerTime    : " + obj.getRegister_time());
                System.out.println("--------------------------------------");
            }
        }
    }
}
