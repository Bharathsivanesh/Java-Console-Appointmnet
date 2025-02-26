package Controller;

import Resources.PatientDTO;
import Resources.ReceptionistDTO;
import models.Patientmodel;
import models.Receptionistmodel;

public class Receptionistcontroller {

    private static Receptionistcontroller instance;

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
        return Receptionistmodel.receptlogin(recep);
    }

}
