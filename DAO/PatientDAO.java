package DAO;

import model.PatientDTO;

public interface PatientDAO {
    boolean Patientregister(PatientDTO patient);
    boolean Patientlogin(PatientDTO patient);
}
