package Controller;

import DAO.PatientDAO;
import model.PatientDTO;
import DAO.PatientDAOImpl;

public class Patientcontroller {

    private static Patientcontroller instance;
    private PatientDAO patientobj=new PatientDAOImpl();

    private Patientcontroller(){};

    public static Patientcontroller getInstance()
    {
        if(instance==null)
        {
            instance=new Patientcontroller();
        }
        return instance;
    }
    public boolean Patientregister(int id,String pass,String email,int age,String gender,String phone,String blood_group)
    {
        PatientDTO patient=new PatientDTO(id,pass,email,age,gender,phone,blood_group);
        return patientobj.Patientregister(patient);
    }
    public  boolean Patientlogin(int id,String pass)
    {
        PatientDTO patient=new PatientDTO(id,pass);
        return patientobj.Patientlogin(patient);
    }


}

