import java.sql.SQLException;
import java.util.*;

import Dbconnectivity.Dbconnect;
import View.Adminview;
import View.DoctorView;
import View.PatientView;
import View.ReceptionistView;

public class Main
{
    public static void main(String[] args)
    {

        try{
            Dbconnect.getInstance().getConnection();
        }
        catch (Exception e)
        {
            System.out.println("Unable To connect With Db");
            return;
        }
        Scanner s=new Scanner(System.in);
        while(true)
        {
            System.out.println("----------ROYAL CARE-------------");
            System.out.println("1)ADMIN-LOGIN");
            System.out.println("2)DOCTOR-LOGIN");
            System.out.println("3)RECEPTIONIST-LOGIN");
            System.out.println("4)PATIENT-REGITSER");
            System.out.println("5)PATIENT-LOGIN");
            System.out.println("6)EXIT");
            System.out.println("----------------------------------");
            int n=s.nextInt();
            switch (n)
            {
                case 1:
                    Adminview.showlogin();
                    break;
                case 2:
                    DoctorView.Doctorlogin();
                    break;
                 case 3:
                     ReceptionistView.login();
                     break;
                case 4:
                    PatientView.Patientreigister();
                    break;
                case 5:
                    PatientView.PatientLogin();
                    break;
                case 6:
                    return;
                default:
                    System.out.println("Enter Valid Number");
            }
        }

    }
}