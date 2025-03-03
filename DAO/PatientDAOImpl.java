package DAO;

import Dbconnectivity.Dbconnect;
import model.PatientDTO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class PatientDAOImpl implements PatientDAO {

    public  boolean Patientregister(PatientDTO patient)
    {
        String query="insert into patient values (?,?,?,?,?,?,?)";
        try
        {
            PreparedStatement ps=Dbconnect.getInstance().getConnection().prepareStatement(query);
            ps.setInt(1, patient.getPat_id());
            ps.setString(2, patient.getPassword());
            ps.setString(3, patient.getEmail());
            ps.setInt(4, patient.getAge());
            ps.setString(5, patient.getGender());
            ps.setString(6, patient.getPhone_no());
            ps.setString(7, patient.getBlood_group());

            int row = ps.executeUpdate();
            return row > 0;
        }
        catch (Exception e) {

            System.out.println(e.getMessage());
        }
        return false;
    }
    public  boolean Patientlogin(PatientDTO patient)
    {
        try {
            int id=patient.getPat_id();
            String pass=patient.getPassword();
            System.out.println(id);
            System.out.println(pass);
            String query = "select * from patient where pat_id=? AND password=? ";
            PreparedStatement ps=Dbconnect.getInstance().getConnection().prepareStatement(query);
            ps.setInt(1,id);
            ps.setString(2,pass);
            ResultSet rs=ps.executeQuery();
            return rs.next();

        }
        catch (Exception e) {}
        return false;
    }
}
