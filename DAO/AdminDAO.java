package DAO;

import model.AdminDTO;
import model.DoctorDTO;
import model.HospitalDTO;
import model.ReceptionistDTO;

public interface AdminDAO {
    AdminDTO adminlogin(int I_D, String pass);
    boolean Addreceptionist(ReceptionistDTO receptionist);
    boolean Addhospitaldetails(HospitalDTO hospital);

    boolean Adddoctor(DoctorDTO doctor);
}
