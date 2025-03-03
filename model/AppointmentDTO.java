package model;

public class AppointmentDTO {
    private int appo_id;
    private int doc_id;
    private int pat_id;
    private String appo_status;
    private String time;
    private String date;
    private int room_id;
    private String register_time;


    public AppointmentDTO(int appo_id, int doc_id, int pat_id, String appo_status, String time, String date,int room_id,String register_time) {
        this.appo_id = appo_id;
        this.doc_id = doc_id;
        this.pat_id = pat_id;
        this.appo_status = appo_status;
        this.time = time;
        this.date = date;
        this.room_id=room_id;
        this.register_time=register_time;
    }

    public AppointmentDTO(int doc_id, int pat_id, String appo_status, String time, String date,int room_id,String register_time) {

        this.doc_id = doc_id;
        this.pat_id = pat_id;
        this.appo_status = appo_status;
        this.time = time;
        this.date = date;
        this.room_id=room_id;
        this.register_time=register_time;
    }

    public AppointmentDTO(int doc_id, int pat_id, String appo_status, String time, String date,int room_id)
    {

        this.doc_id = doc_id;
        this.pat_id = pat_id;
        this.appo_status = appo_status;
        this.time = time;
        this.date = date;
        this.room_id=room_id;

    }

    public String getRegister_time()
    {
        return register_time;
    }
    public void setRegister_time(String time)
    {
        this.register_time=time;
    }
    public int getRoom_id()
    {
        return room_id;
    }
    public int getAppo_id() {
        return appo_id;
    }

    public int getDoc_id() {
        return doc_id;
    }

    public int getPat_id() {
        return pat_id;
    }

    public String isAppo_status() {
        return appo_status;
    }

    public String getTime() {
        return time;
    }

    public String getDate() {
        return date;
    }

    public void setRoom_id(int room_id)
    {
        this.room_id=room_id;
    }
    public void setAppo_id(int appo_id) {
        this.appo_id = appo_id;
    }

    public void setDoc_id(int doc_id) {
        this.doc_id = doc_id;
    }

    public void setPat_id(int pat_id) {
        this.pat_id = pat_id;
    }

    public void setAppo_status(String appo_status) {
        this.appo_status = appo_status;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
