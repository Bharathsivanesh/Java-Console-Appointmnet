package DAO;
import Dbconnectivity.Dbconnect;
import model.AppointmentDTO;
import Util.Cookie;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.*;
public class ApointmentDAOImpl implements AppointmentDAO{

    public  List<AppointmentDTO>getappointment()
    {
        List<AppointmentDTO>lst=new ArrayList<>();
        try
        {
            String query="select * from appointments where pat_id=?";
            PreparedStatement ps= Dbconnect.getInstance().getConnection().prepareStatement(query);
            ps.setInt(1, Cookie.getinstance().getter_userid());
            ResultSet st=ps.executeQuery();
            while(st.next())
            {
                int id=st.getInt("appo_id");
                int doc_id=st.getInt("doc_id");
                int pat_id=st.getInt("pat_id");
                String status=st.getString("appo_status");
                String time=st.getString("time");
                String date=st.getString("date");
                int room_id=st.getInt("room_id");
                String register_time=st.getString("regitser_time");
                AppointmentDTO obj=new AppointmentDTO(
                        id,doc_id,pat_id,status,time,date,room_id,register_time
                );
                lst.add(obj);
            }
        }
        catch (Exception e){
            System.out.println(e.getMessage());
            System.out.println("error in db");
        };
        return lst;
    }
    public  boolean setappointment(AppointmentDTO obj)
    {
        try
        {

            String query = "INSERT INTO appointments (doc_id, pat_id, appo_status, time, date, room_id,regitser_time) VALUES (?, ?, ?, ?, ?, ?,?)";
            PreparedStatement ps=Dbconnect.getInstance().getConnection().prepareStatement(query);
            ps.setInt(1,obj.getDoc_id());
            ps.setInt(2,obj.getPat_id());
            ps.setString(3,obj.isAppo_status());
            ps.setString(4,obj.getTime());
            ps.setString(5,obj.getDate());
            ps.setInt(6,obj.getRoom_id());
            ps.setString(7,obj.getRegister_time());
            int row=ps.executeUpdate();

            return row>0;
        }
        catch (Exception e){
            System.out.println(e.getMessage());
            System.out.println("Errro in db");
        };
        return false;   
    }

    public ArrayList<AppointmentDTO> getappointment(int id)
    {
        ArrayList<AppointmentDTO>obj=new ArrayList<>();
        try{
            String query="select * from appointments where doc_id=?";
            PreparedStatement ps=Dbconnect.getInstance().getConnection().prepareStatement(query);
            ps.setInt(1,id);
            ResultSet st=ps.executeQuery();

            while(st.next())
            {
                AppointmentDTO appo= new AppointmentDTO(st.getInt("appo_id"),st.getInt("doc_id"),
                        st.getInt("pat_id"),st.getString("appo_status"),st.getString("time"),
                        st.getString("date"),st.getInt("room_id"),st.getString("regitser_time"));
                obj.add(appo);
            }
            return obj;
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        };
        return obj;
    }


    public  ArrayList<AppointmentDTO>getallappointment()
    {
        ArrayList<AppointmentDTO>lst=new ArrayList<>();
        try
        {
            String query="select * from appointments ";
            PreparedStatement ps= Dbconnect.getInstance().getConnection().prepareStatement(query);
            ResultSet st=ps.executeQuery();
            while(st.next())
            {
                int id=st.getInt("appo_id");
                int doc_id=st.getInt("doc_id");
                int pat_id=st.getInt("pat_id");
                String status=st.getString("appo_status");
                String time=st.getString("time");
                String date=st.getString("date");
                int room_id=st.getInt("room_id");
                String register_time=st.getString("regitser_time");
                AppointmentDTO obj=new AppointmentDTO(
                        id,doc_id,pat_id,status,time,date,room_id,register_time
                );
                lst.add(obj);
            }
        }
        catch (Exception e){
            System.out.println(e.getMessage());
            System.out.println("error in db");
        };
        return lst;
    }

    public  boolean rejectappo(int appo_id)
    {
        try{
            String query="update appointments set appo_status= 'Rejected' where appo_id=?";
            PreparedStatement ps=Dbconnect.getInstance().getConnection().prepareStatement(query);
            ps.setInt(1, appo_id);
            int row=ps.executeUpdate();
            return row>0;
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
        }
        return false;
    }
    public  boolean makeschedule(AppointmentDTO obj)
    {
      try{
          String query = "UPDATE appointments SET appo_status=?, room_id=? WHERE appo_status='Not Viewed' AND time=? AND date=? AND doc_id=? AND pat_id=?";
          PreparedStatement ps=Dbconnect.getInstance().getConnection().prepareStatement(query);
          ps.setString(1,obj.isAppo_status());
          ps.setInt(2,obj.getRoom_id());
          ps.setString(3, obj.getTime());

         ps.setString(4,obj.getDate());
         ps.setInt(5,obj.getDoc_id());
         ps.setInt(6,obj.getPat_id());
          int row=ps.executeUpdate();
          return row>0;
      }
      catch (Exception e)
      {
          System.out.println(e.getMessage());
      }
      return false;
    }

        public int getdoctorroom_id(int doc_id)
    {
        try
        {
            String query="select room_id from doctor where id=?";
            PreparedStatement ps=Dbconnect.getInstance().getConnection().prepareStatement(query);
            ps.setInt(1,doc_id);
            ResultSet st=ps.executeQuery();
            if(st.next())
            {
                return st.getInt("room_id");
            }

        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
        }
        return 0;
    }

}
