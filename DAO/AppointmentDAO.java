package DAO;

import model.AppointmentDTO;

import java.util.ArrayList;
import java.util.List;

public interface AppointmentDAO {
   int getdoctorroom_id(int doc_id);
   boolean setappointment(AppointmentDTO appointmnet);
    List<AppointmentDTO> getappointment();
    ArrayList<AppointmentDTO>getappointment(int doc_id);
    ArrayList<AppointmentDTO>getallappointment();
    boolean rejectappo(int appo_id);
    boolean makeschedule(AppointmentDTO appo);
}
