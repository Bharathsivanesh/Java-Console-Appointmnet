package Controller;
import java.util.*;
import Resources.AppointmentDTO;
import Resources.DoctorDTO;
import models.Doctormodel;

import java.util.List;

public class Doctocontroller {
    private static Doctocontroller instance;
    private Doctocontroller (){};
    public static Doctocontroller getinstance()
    {
        if(instance==null)
        {
            instance=new Doctocontroller();
        }
        return instance;
    }

    public List<DoctorDTO> getdoctor()
    {

        return Doctormodel.getdoctordetails();
    }

    public boolean doctorlogin(int id,String name)
    {
        DoctorDTO obj=new DoctorDTO(id,name);
        return Doctormodel.doctorlogin(obj);
    }
    public boolean updatedocavilability(int doc_id)
    {
       return Doctormodel.updatedocavailability(doc_id);
    }


}
