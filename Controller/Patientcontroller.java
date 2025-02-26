package Controller;

import Resources.DoctorDTO;
import Resources.PatientDTO;
import models.Doctormodel;
import models.Patientmodel;
import java.util.*;

public class Patientcontroller {

    private static Patientcontroller instance;

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
        return Patientmodel.Patientregister(patient);
    }
    public  boolean Patientlogin(int id,String pass)
    {
        PatientDTO patient=new PatientDTO(id,pass);
        return Patientmodel.Patientlogin(patient);
    }


}

