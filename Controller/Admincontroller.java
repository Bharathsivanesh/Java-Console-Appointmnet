package Controller;
import Resources.AdminDTO;
import Resources.DoctorDTO;
import Resources.HospitalDTO;
import Resources.ReceptionistDTO;
import models.Adminmodel;
public class Admincontroller {

    private static Admincontroller instance;
    public static Admincontroller getinstance()
    {

        if(instance==null)
        {
            instance=new Admincontroller();
        }
        return instance;
    }

    private Admincontroller(){};
    public  AdminDTO adminlogin(int id, String pass)
    {
        return Adminmodel.adminlogin(id,pass);
    }

    public  boolean Adddoctor(int id,String pass,String name,String dept,boolean available,String email,String number,int roomid)
    {
        DoctorDTO doctor=new DoctorDTO(id,pass,name,dept,available,email,number,roomid);
        if(Adminmodel.Adddoctor(doctor))
        {
            return true;
        }
        return false;
    }
    public  boolean Addreceptionist(int id,String pass,String shiftingtime,String role,String email,String name,String number)
    {
        ReceptionistDTO receptionist=new ReceptionistDTO(id,pass,shiftingtime,role,email,name,number);
        if(Adminmodel.Addreceptionist(receptionist))
        {
            return true;
        }
        return false;
    }

    public boolean Addhospitaldetails(int id,String name,int doc_count,String email,String number,String working_hrs,String address)
    {
        HospitalDTO hospital=new HospitalDTO(id,name,doc_count,email,number,working_hrs,address);
        if(Adminmodel.Addhospitaldetails(hospital))
        {
            return true;
        }
        return false;
    }

}
