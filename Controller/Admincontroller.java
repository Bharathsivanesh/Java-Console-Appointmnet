package Controller;
import DAO.AdminDAO;
import model.AdminDTO;
import model.DoctorDTO;
import model.HospitalDTO;
import model.ReceptionistDTO;
import DAO.AdminDAOImpl;
public class Admincontroller {

    private static Admincontroller instance;
    private AdminDAO admindao=new AdminDAOImpl();
    public static Admincontroller getinstance()
    {
        if(instance==null)
        {
            instance=new Admincontroller();
        }
        return instance;
    }

    private Admincontroller(){}
    public  AdminDTO adminlogin(int id, String pass)
    {
        return admindao.adminlogin(id,pass);
    }

    public  boolean Adddoctor(int id,String pass,String name,String dept,boolean available,String email,String number,int roomid)
    {
        DoctorDTO doctor=new DoctorDTO(id,pass,name,dept,available,email,number,roomid);
        if(admindao.Adddoctor(doctor))
        {
            return true;
        }
        return false;
    }
    public  boolean Addreceptionist(int id,String pass,String shiftingtime,String role,String email,String name,String number)
    {
        ReceptionistDTO receptionist=new ReceptionistDTO(id,pass,shiftingtime,role,email,name,number);
        if(admindao.Addreceptionist(receptionist))
        {
            return true;
        }
        return false;
    }

    public boolean Addhospitaldetails(int id,String name,int doc_count,String email,String number,String working_hrs,String address)
    {
        HospitalDTO hospital=new HospitalDTO(id,name,doc_count,email,number,working_hrs,address);
        if(admindao.Addhospitaldetails(hospital))
        {
            return true;
        }
        return false;
    }

}
