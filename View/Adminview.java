package View;
import Controller.Admincontroller;
import model.AdminDTO;
import Util.Input;

public class Adminview extends Input {
    public static void showlogin()
    {
        System.out.println("Enter Admin I'D");
        int user_id=sc.nextInt();
        System.out.println("Enter Admin Password");
        String password=sc.next();
        AdminDTO admin=Admincontroller.getinstance().adminlogin(user_id,password);
        if(admin!=null)
        {
            System.out.println("Sucessfully Admin logged in ");

            System.out.println("WELCOME ADMIN");
            while(true)
            {
                System.out.println("---------------------------");
                System.out.println("1)Add Doctor");
                System.out.println("2)Add Receptionist");
                System.out.println("3)Add HospitalDetails");
                System.out.println("4)Log out");
                System.out.println("---------------------------");
                int n=sc.nextInt();
                 switch (n)
                 {
                     case 1:
                         adddoctor();
                         break;
                     case 2:
                         addreceptionist();
                         break;
                     case 3:
                         addhospitaldetail();
                         break;
                     case 4:
                         return;

                     default:
                         System.out.println("Enter Valid No");

                 }
            }

        }
        else {
            System.out.println("Unable to login Retry");
        }
    }
    public static void adddoctor()
    {
        System.out.println("Enter Doctor Details");
        System.out.println("Set I'D ");
        int id=sc.nextInt();
        System.out.println("Set Password");
        String pass=sc.next();
        System.out.println("Enter Name");
        String name=sc.next();
        System.out.println("Enter Department");
        String dept=sc.next();
        boolean available =true;
        System.out.println("Enter Email");
        String email=sc.next();
        System.out.println("Enter Conatact_No ");
        String number=sc.next();
        System.out.println("Enter Room I'D");
        int roomid=sc.nextInt();
        if(Admincontroller.getinstance().Adddoctor(id,pass,name,dept,available,email,number,roomid))
        {
            System.out.println("Sucessfully Doctor Detail Inserted");
        }
        else {
            System.out.println("I'D alredy Exists");
        }

    }
    public static void addreceptionist()
    {
        System.out.println("Enter Receptionist Details");
        System.out.println("Set I'D ");
        int id=sc.nextInt();
        System.out.println("Set Password");
        String pass=sc.next();
        System.out.println("Enter Shifting Time (e.g.9AM-5PM):");
        String shiftingTime = sc.next();
        System.out.println("Enter Role");
        String role=sc.next();
        System.out.println("Enter Email");
        String email=sc.next();
        System.out.println("Enter Name");
        String name=sc.next();
        System.out.println("Enter Conatact_No");
        String number=sc.next();

        if(Admincontroller.getinstance().Addreceptionist(id,pass,shiftingTime,role,email,name,number))
        {
            System.out.println("Sucessfully Receptionist Detail Inserted");
        }
        else {
            System.out.println("I'D alredy Exists");
        }
    }

    public static void addhospitaldetail()
    {
        System.out.println("Enter Hospital Details");
        System.out.println("Set I'D ");
        int id=sc.nextInt();
        System.out.println("Enter Name");
        String name=sc.next();
        System.out.println("Enter Total_Doctor ");
        int doc_count=sc.nextInt();
        System.out.println("Enter Email");
        String email=sc.next();
        System.out.println("Enter Conatact_No");
        String number=sc.next();
        String working_hrs="24/7";
        System.out.println("Enter Address");
        String address=sc.nextLine();
        if(Admincontroller.getinstance().Addhospitaldetails(id,name,doc_count,email,number,working_hrs,address))
        {
            System.out.print("Sucessfully Hospital Detail Inserted");
        }
        else {
            System.out.print("I'D alredy Exists");
        }




    }



}
