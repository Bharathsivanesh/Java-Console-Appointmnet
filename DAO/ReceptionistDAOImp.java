package DAO;

import Dbconnectivity.Dbconnect;
import model.ReceptionistDTO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class ReceptionistDAOImp implements ReceptionistDAO {

    public  boolean receptlogin(ReceptionistDTO obj)
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
