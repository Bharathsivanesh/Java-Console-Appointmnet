package model;

public class AdminDTO {
    private int id;
    private String password;
    private String name;
    private String email;
    private String phone_no;

    public AdminDTO(int id,String pass,String name,String email,String phone_no)
    {
        this.id=id;
        this.password=pass;
        this.name=name;
        this.email=email;
        this.phone_no=phone_no;
    }
    public int  getid()
    {
        return id;
    }
    public String  getpassword()
    {
        return password;
    }
    public String getName()
    {
        return name;
    }
    public String getemail()
    {
        return email;
    }
    public String getPhone_no()
    {
        return phone_no;
    }
    public void setid(int id)
    {
        this.id=id;
    }
    public void setPassword(String password)
    {
        this.password=password;
    }
       public void setname(String name)
       {
           this.name=name;
       }
       public void setmail(String email)
       {
           this.email=email;
       }
       public void setPhone_no(String phone_no)
       {
           this.phone_no=phone_no;
       }


}