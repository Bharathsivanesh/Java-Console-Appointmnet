package Resources;

public class PatientDTO {
    private int pat_id;
    private String password;
    private String email;
    private int age;
    private String gender;
    private String phone_no;
    private String blood_group;

    public PatientDTO(int pat_id, String password, String email, int age, String gender, String phone_no, String blood_group) {
        this.pat_id = pat_id;
        this.password = password;
        this.email = email;
        this.age = age;
        this.gender = gender;
        this.phone_no = phone_no;
        this.blood_group = blood_group;
    }
    public PatientDTO(int id,String pass)
    {
        this.pat_id=id;
        this.password=pass;
    }

    public int getPat_id()
    {
       return pat_id;
    }
    public String getPassword()
    {
        return password;
    }
    public String getEmail()
    {
        return email;
    }
    public int getAge()
    {
        return age;

    }
    public String getGender()
    {
        return gender;
    }
    public String getPhone_no()
    {
        return phone_no;
    }
    public String getBlood_group()
    {
        return blood_group;
    }

    public void setPat_id(int pat_id) {
        this.pat_id = pat_id;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setPhone_no(String phone_no) {
        this.phone_no = phone_no;
    }

    public void setBlood_group(String blood_group) {
        this.blood_group = blood_group;
    }


}
