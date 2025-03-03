package View;
import java.util.*;

import Controller.Doctocontroller;
import Util.Cookie;
import Controller.Appointmentcontroller;
import Controller.Patientcontroller;
import model.AppointmentDTO;
import model.DoctorDTO;
import Util.Input;

public class PatientView extends Input {

    private static Patientcontroller instance=Patientcontroller.getInstance();
public static void Patientreigister()
{
    System.out.println("Enter Your Details");
    System.out.println("Enter Your I'D");
    int id=sc.nextInt();
    System.out.println("Enter Your Password");
    String pass=sc.next();
    System.out.println("Enter Email");
    String email=sc.next();
    System.out.println("Enter Age");
    int age=sc.nextInt();
    System.out.println("Enter Gender");
    String gender=sc.next();
    System.out.println("Enter Phone_number");
    String phonenumber=sc.next();
    System.out.println("Enter Blood_grop");
    String blood_group=sc.next();
    if(instance.Patientregister(id,pass,email,age,gender,phonenumber,blood_group))
    {
        System.out.println("Sucessfully registered");

    }
    else
    {
        System.out.println("I'D alredy Exists ");

    }
    return;
}
public static void PatientLogin()
{
    System.out.println("Enter Your I'D");
    int id=sc.nextInt();
    System.out.println("Enter Your Password");
    String pass=sc.next();

    if(instance.Patientlogin(id,pass))
    {
        Cookie.getinstance().setter_userid(id);
        System.out.println("Sucessfully Logged In Portal");
        System.out.println("-----WELCOME-----");
        while(true)
        {
            System.out.println("1)View Doctor Details");
            System.out.println("2)Make Appointement");
            System.out.println("3)View Appointments");
            System.out.println("4)Log Out");
            int n=sc.nextInt();
            switch (n)
            {
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
                    System.out.println("Enter Valid No");
                    break;
            }

        }
    }
    else {
        System.out.println("Invalid I'd Credentials");
    }
}

public static void makeappointment()
{
    System.out.println("-------------Enter Appointment Details----------");
    System.out.println("Enter Doc_id");
    int doc_id=sc.nextInt();
    int pat_id=Cookie.getinstance().getter_userid();
    String status="Not Viewed";
    System.out.println("Enter Time (HH:AM/PM)");
    String time=sc.next();
    System.out.println("Enter Date (YYYY-MM-DD)");
    String date=sc.next();
    if(Appointmentcontroller.getinstance().setappointment(doc_id,pat_id,status,time,date,0))
    {
        System.out.println("Sucessfully Registered");
    }
    else
    {
        System.out.println("Try Again");
    }


}
public static void viewapoointment()
{
    List<AppointmentDTO>lst= Appointmentcontroller.getinstance().getappointmentdetails();
    System.out.println("------------------------------------------------");
    if(lst.isEmpty())
    {
        System.out.println("No Appointment's Yet");
        System.out.println("------------------------------------------------");
    }
    else {
        System.out.println("------------------------------------------------");
        System.out.println("Appointment Details");
        for(AppointmentDTO appo:lst)
        {
            System.out.println("Appo_ID     : " +appo.getAppo_id() );
            System.out.println("doc_id      : " + appo.getDoc_id());
            System.out.println("pat_id      : " + appo.getPat_id());
            System.out.println("status      : " + appo.isAppo_status());
            System.out.println("Time        : " +appo.getTime());
            System.out.println("Date        : " + appo.getDate());
            System.out.println("Register_Time: " + appo.getRegister_time());
            System.out.println("Room_ID     : " +(appo.getRoom_id()==0?"Not Allocated":appo.getRoom_id()));
            System.out.println("------------------------------------------------");
        }
    }
}

public static void displaydoctor()
{
    List<DoctorDTO>lst= Doctocontroller.getinstance().getdoctor();
    if(lst.isEmpty())
    {
        System.out.println("No Doctor avilable");
    }
    else
    {
        System.out.println("------------------------------------------------");
        System.out.println("Doctor Details");
        for (DoctorDTO doctors : lst)
        {
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


}
