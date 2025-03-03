package model;

public class ReceptionistDTO {
    private int id;
    private String password;
    private String shiftingtime;
    private String role;
    private String email;
    private String name;
    private String phone_no;

    public ReceptionistDTO(int id, String password, String shiftingtime, String role, String email, String name, String phone_no) {
        this.id = id;
        this.password = password;
        this.shiftingtime = shiftingtime;
        this.role = role;
        this.email = email;
        this.name = name;
        this.phone_no = phone_no;
    }
    public ReceptionistDTO(int id, String password) {
        this.id = id;
        this.password = password;

    }
    public int getId() {
        return id;
    }

    public String getPassword() {
        return password;
    }

    public String getShiftingtime() {
        return shiftingtime;
    }

    public String getRole() {
        return role;
    }

    public String getEmail() {
        return email;
    }

    public String getName() {
        return name;
    }

    public String getPhone_no() {
        return phone_no;
    }


    public void setId(int id) {
        this.id = id;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setShiftingtime(String shiftingtime) {
        this.shiftingtime = shiftingtime;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPhone_no(String phone_no) {
        this.phone_no = phone_no;
    }
}
