package DAO;

import model.DoctorDTO;

import java.util.List;

public interface DoctorDAO {
    List<DoctorDTO>getdoctordetails();
    boolean doctorlogin(DoctorDTO doctor);
    boolean updatedocavailability(int doc_id);


}
