package DAO;
import Dbconnectivity.Dbconnect;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

import model.AdminDTO;
import model.DoctorDTO;
import model.HospitalDTO;
import model.ReceptionistDTO;

public class AdminDAOImpl implements AdminDAO{
    public AdminDTO adminlogin(int I_D, String pass)
  {
      String query="select * from admin where I_D=? AND pass=? ";
      try{
          PreparedStatement ps=Dbconnect.getInstance().getConnection().prepareStatement(query);
          ps.setInt(1,I_D);
          ps.setString(2,pass);
          ResultSet set=ps.executeQuery();
          if(set.next())
          {
              return new AdminDTO(
                      set.getInt("I_D"),
                     set.getString("pass"),
                      set.getString("name"),
                      set.getString("email"),
                      set.getString("phone_no")
              );
          }

       }
      catch (Exception e)
      {
          System.out.println(e.getMessage());

      }
      return null;

  }

  public  boolean Adddoctor(DoctorDTO doctor)

  {

      String query="insert into doctor values (?,?,?,?,?,?,?,?)";
       try
       {
      PreparedStatement ps=Dbconnect.getInstance().getConnection().prepareStatement(query);
      ps.setInt(1,doctor.getId());
      ps.setString(2,doctor.getName());
      ps.setString(3, doctor.getPassword());
      ps.setString(4,doctor.getDepartment());
      ps.setBoolean(5,doctor.isAvailable());
      ps.setString(6,doctor.getEmail());
      ps.setString(7,doctor.getPhone_no());
      ps.setInt(8,doctor.getRoom_id());
      int row=ps.executeUpdate();
      if(row>0)
      {
          return true;
      }
       }
       catch (Exception e)
       {
       }
      return false;
  }
  public  boolean Addreceptionist(ReceptionistDTO receptionist)
  {
      String query = "INSERT INTO receptionist VALUES (?, ?, ?, ?, ?, ?, ?)";
      try
      {
          PreparedStatement ps = Dbconnect.getInstance().getConnection().prepareStatement(query);
              ps.setInt(1, receptionist.getId());
              ps.setString(2, receptionist.getName());
              ps.setString(3, receptionist.getPassword());
              ps.setString(4, receptionist.getRole());
              ps.setString(5, receptionist.getShiftingtime());
              ps.setString(6, receptionist.getEmail());
              ps.setString(7, receptionist.getPhone_no());

              int row = ps.executeUpdate();
              return row > 0;
          } catch (Exception e) {}

      return false;
  }
  public  boolean Addhospitaldetails(HospitalDTO hospital)
  {
      String query = "INSERT INTO hospital VALUES (?, ?, ?, ?, ?, ?, ?)";
      try
      {
          PreparedStatement ps = Dbconnect.getInstance().getConnection().prepareStatement(query);
          ps.setInt(1, hospital.getId());
          ps.setString(2, hospital.getName());
          ps.setInt(3, hospital.getTotal_doctor());
          ps.setString(4, hospital.getEmail());
          ps.setString(5, hospital.getAddress());
          ps.setString(6, hospital.getWorking_hours());
          ps.setString(7, hospital.getPhone_no());

          int row = ps.executeUpdate();
          return row > 0;
      }
      catch (Exception e)
      {
      }
      return false;
  }

}
