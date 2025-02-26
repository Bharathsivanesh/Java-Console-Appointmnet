package View;

import Controller.Appointmentcontroller;
import Controller.Doctocontroller;
import Controller.Receptionistcontroller;
import Resources.AppointmentDTO;
import Resources.DoctorDTO;
import Util.Cookie;
import Util.Input;

import java.util.ArrayList;
import java.util.List;

public class ReceptionistView extends Input {

    public static void login()
    {
        System.out.println("Enter Your I'D");
        int id=sc.nextInt();
        System.out.println("Enter Your Password");
        String pass=sc.next();
        if(Receptionistcontroller.getInstance().receptlogin(id,pass))
        {
            System.out.println("Sucessfully Logged-In");
            while(true)
            {
                System.out.println("1)View Doctors Availability");
                System.out.println("2)View All Appointments");
                System.out.println("3)Make Schedule");
                System.out.println("4)Reject Schedule");
                System.out.println("5)Log-out");
                int n=sc.nextInt();
                switch (n)
                {
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
                        System.out.println("Enter Valid No");
                       break;

                }
            }

        }
        else
        {
            System.out.println("Invalid I'D");
        }
    }

    public static void scheduleappo()
    {
        System.out.println("Enter Doc_Id");
        int doc_id=sc.nextInt();
        System.out.println("Enter Pat_id");
        int pat_id=sc.nextInt();
        System.out.println("Enter Time");
        String time=sc.next();
        System.out.println("Enter Date");
        String  date=sc.next();
        if(Appointmentcontroller.getinstance().makeschedule(doc_id,pat_id,time,date))
        {
            System.out.println("Sucessfully Scheduled");
        }
        else {
            System.out.println("Something went wrong");
        }
    }
    public static void  rejectappointment()
    {
        System.out.println("Enter Reject Appoint_I'D");
        int id=sc.nextInt();
        if(Appointmentcontroller.getinstance().rejectappo(id))
        {
            System.out.println("Appointment:"+id+" rejected");
        }
        else {
            System.out.println("something went wrong");
        }
    }
    public static void  checkdocavail()
    {
        List<DoctorDTO> lst= Doctocontroller.getinstance().getdoctor();
        if(lst.isEmpty())
        {
            System.out.println("No Doctor available");
        }
        else
        {
            System.out.println("------------------------------------------------");
            System.out.println("Checking Doctor Avilability");
            for (DoctorDTO doctors : lst)
            {
                System.out.println("Doctor ID      : " + doctors.getId());
                System.out.println("Available      : " + (doctors.isAvailable() ? "Yes" : "No"));
                System.out.println("------------------------------------------------");
            }
        }

    }
    public static void  viewappointment()
    {
        ArrayList<AppointmentDTO> lst= Appointmentcontroller.getinstance().getdocappointment();
        System.out.println("--------------------------------------");
        if(lst.size()==0)
        {
            System.out.println("No Appointment Yet");
            System.out.println("--------------------------------------");
        }
        else {
            for(AppointmentDTO obj:lst)
            {
                System.out.println("--------------------------------------");
                System.out.println("Appointment I'D :"+obj.getAppo_id());
                System.out.println("Doctor_Id       :"+obj.getDoc_id());
                System.out.println("Patient_Id      :"+obj.getPat_id());
                System.out.println("Appointment_status:"+obj.isAppo_status());
                System.out.println("Appointment_Time:"+obj.getTime());
                System.out.println("Appointment_Date:"+obj.getDate());
                System.out.println("Appointment_room:"+(obj.getRoom_id()==0?"Not Allocated":obj.getRoom_id()));
                System.out.println("Appotment_registertime"+obj.getRegister_time());
                System.out.println("--------------------------------------");
            }
        }
    }

}
