package Controller;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

import Resources.AppointmentDTO;
import Resources.DoctorDTO;
import models.Apoointmentmodel;
import models.Doctormodel;

public class Appointmentcontroller {
    private static Appointmentcontroller instance;
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
         return Apoointmentmodel.setappointment(obj);
    }

    public List<AppointmentDTO> getappointmentdetails()
    {
        return Apoointmentmodel.getappointment();
    }
    public ArrayList<AppointmentDTO> getdocappointment(int doc_id)
    {
        return Apoointmentmodel.getdocappointment(doc_id);
    }
    public ArrayList<AppointmentDTO> getdocappointment()
    {
        return Apoointmentmodel.getallappointment();
    }

    public boolean rejectappo(int appo_id)
    {
        return Apoointmentmodel.rejectappo(appo_id);
    }
    public boolean makeschedule(int doc_id,int pat_id,String time,String date)
    {
        int room_id=Doctormodel.getdoctorroom_id(doc_id);
        AppointmentDTO obj=new AppointmentDTO(doc_id,pat_id,"ACCEPTED",time,date,room_id);
        return Apoointmentmodel.makeschedule(obj);
    }
}
