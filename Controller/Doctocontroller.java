package Controller;
import DAO.DoctorDAO;
import Dbconnectivity.Dbconnect;
import model.DoctorDTO;
import DAO.DoctorDAOImpl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

public class Doctocontroller {
    private static Doctocontroller instance;
    private DoctorDAO doctorobj=new DoctorDAOImpl();
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

        return doctorobj.getdoctordetails();
    }

    public boolean doctorlogin(int id,String name)
    {
        DoctorDTO obj=new DoctorDTO(id,name);
        return doctorobj.doctorlogin(obj);
    }
    public boolean updatedocavilability(int doc_id)
    {
       return doctorobj.updatedocavailability(doc_id);
    }


}
