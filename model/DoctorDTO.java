package model;

public class DoctorDTO {
    private int id;

    private String password;
    private String name;
    private boolean available;
    private String email;
    private String department;
    private String phone_no;
    private int room_id;

        public DoctorDTO(int id,String password,String name,String department, boolean available,String email,  String phone_no, int room_id) {
            this.id = id;
            this.name = name;
            this.password = password;
            this.department = department;
            this.available = available;
        this.email = email;
        this.phone_no = phone_no;
        this.room_id = room_id;
    }

    public DoctorDTO(int id,String password)
    {
        this.id=id;
        this.password=password;
    }
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getPassword() {
        return password;
    }

    public String getDepartment() {
        return department;
    }

    public boolean isAvailable() {
        return available;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone_no() {
        return phone_no;
    }

    public int getRoom_id() {
        return room_id;
    }
    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPhone_no(String phone_no) {
        this.phone_no = phone_no;
    }

    public void setRoom_id(int room_id) {
        this.room_id = room_id;
    }
}
