package models;

import Dbconnectivity.Dbconnect;
import Resources.DoctorDTO;
import Resources.ReceptionistDTO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Receptionistmodel {

    public static boolean receptlogin(ReceptionistDTO obj)
    {
        try
        {
            String query="Select * from receptionist where id=? AND  password=?";
            PreparedStatement ps= Dbconnect.getInstance().getConnection().prepareStatement(query);
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

}
