package Controller;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

import DAO.AppointmentDAO;
import model.AppointmentDTO;
import DAO.ApointmentDAOImpl;
import DAO.DoctorDAOImpl;

public class Appointmentcontroller {
    private static Appointmentcontroller instance;
    private AppointmentDAO appoobj=new ApointmentDAOImpl();
    private Appointmentcontroller(){};
    public static Appointmentcontroller getinstance()
    {
        if(instance==null)
        {
            instance=new Appointmentcontroller();
        }
        return instance;
    }


    public boolean setappointment(int doc_id,int pat_id,String status,String time,String date,int room_id)
    {
        String currentTime = LocalTime.now().format(DateTimeFormatter.ofPattern("HH:mm:ss"));
         AppointmentDTO obj=new AppointmentDTO(doc_id,pat_id,status,time,date,room_id,currentTime);
         return appoobj.setappointment(obj);
    }
    public List<AppointmentDTO> getappointmentdetails()
    {
        return appoobj.getappointment();
    }
    public ArrayList<AppointmentDTO> getdocappointment(int doc_id)
    {
        return appoobj.getappointment(doc_id);
    }
    public ArrayList<AppointmentDTO> getdocappointment()
    {
        return appoobj.getallappointment();
    }

    public boolean rejectappo(int appo_id)
    {
        return appoobj.rejectappo(appo_id);
    }
    public boolean makeschedule(int doc_id,int pat_id,String time,String date)
    {
        int room_id= appoobj.getdoctorroom_id(doc_id);
        AppointmentDTO obj=new AppointmentDTO(doc_id,pat_id,"ACCEPTED",time,date,room_id);
        return appoobj.makeschedule(obj);
    }
}
