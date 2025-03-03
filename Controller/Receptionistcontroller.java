package Controller;

import DAO.ReceptionistDAO;
import model.ReceptionistDTO;
import DAO.ReceptionistDAOImp;

public class Receptionistcontroller {

    private static Receptionistcontroller instance;
   private ReceptionistDAO recepobj=new ReceptionistDAOImp();
    private Receptionistcontroller(){};

    public static Receptionistcontroller getInstance()
    {
        if(instance==null)
        {
            instance=new Receptionistcontroller();
        }
        return instance;
    }

    public  boolean receptlogin(int id,String pass)
    {
        ReceptionistDTO recep=new ReceptionistDTO(id,pass);
        return recepobj.receptlogin(recep);
    }

}
