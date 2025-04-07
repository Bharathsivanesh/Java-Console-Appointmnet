package model;

public class HospitalDTO {

    private int id;
    private String name;
    private int total_doctor;
    private String email;
    private String address;
    private String working_hours;
    private String phone_no;


    public HospitalDTO(int id, String name, int total_doctor, String email, String phone_no,String working_hours,String address) {
        this.id = id;
        this.name = name;
        this.total_doctor = total_doctor;
        this.email = email;
        this.address = address;
        this.working_hours = working_hours;
        this.phone_no = phone_no;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getTotal_doctor() {
        return total_doctor;
    }

    public String getEmail  () {
        return email;
    }

    public String getAddress() {
        return address;
    }

    public String getWorking_hours() {
        return working_hours;
    }

    public String getPhone_no() {
        return phone_no;
    }


    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setTotal_doctor(int total_doctor) {
        this.total_doctor = total_doctor;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setWorking_hours(String working_hours) {
        this.working_hours = working_hours;
    }

    public void setPhone_no(String phone_no) {
        this.phone_no = phone_no;
    }
}
