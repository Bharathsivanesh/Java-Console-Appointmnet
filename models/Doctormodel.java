package models;

import Dbconnectivity.Dbconnect;
import Resources.AppointmentDTO;
import Resources.DoctorDTO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;
public class Doctormodel {

    public static List<DoctorDTO> getdoctordetails()  {
        List<DoctorDTO>lst=new ArrayList<>();
        try {
            String query = "select * from doctor";
            PreparedStatement ps = Dbconnect.getInstance().getConnection().prepareStatement(query);
            ResultSet rs=ps.executeQuery();
            while(rs.next())
            {
                int id=rs.getInt("id");
                String name=rs.getString("name");
                String password=rs.getString("password");
                String dept=rs.getString("department");
                boolean available=rs.getBoolean("available");
                String email=rs.getString("email");
                String phone_no=rs.getString("phone_no");
                int room_id=rs.getInt("room_id");
                DoctorDTO obj=new DoctorDTO(
                        id,password,name,dept,available,email,phone_no,room_id);
                lst.add(obj);

            }
            return lst;
        }
        catch (Exception e){};
        return lst;
    }
    public static boolean doctorlogin(DoctorDTO obj)
    {
        try
        {
            String query="Select * from doctor where id=? AND  password=?";
            PreparedStatement ps=Dbconnect.getInstance().getConnection().prepareStatement(query);
            ps.setInt(1,obj.getId());
            ps.setString(2,obj.getPassword());
            ResultSet rs=ps.executeQuery();
            if(rs.next())
            {
                return true;
            }
        }
        catch(Exception e){};
        return false;
    }

    public static boolean updatedocavailability(int doc_id)
    {
        try{
            String query="update doctor set available=NOT available where id=?";
            PreparedStatement ps=Dbconnect.getInstance().getConnection().prepareStatement(query);
            ps.setInt(1,doc_id);
            int row=ps.executeUpdate();
            if(row>0)
            {
                return true;
            }


        }
        catch(Exception e){
            System.out.println(e.getMessage());
        };
        return false;
    }

    public static int getdoctorroom_id(int doc_id)
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
