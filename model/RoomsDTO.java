package model;

public class RoomsDTO {
    private int room_no;
    private String room_type;
    private boolean isAvailable;

    public RoomsDTO(int room_no, String room_type, boolean isAvailable) {
        this.room_no = room_no;
        this.room_type = room_type;
        this.isAvailable = isAvailable;
    }

    public int getRoom_no() {
        return room_no;
    }

    public String getRoom_type() {
        return room_type;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setRoom_no(int room_no) {
        this.room_no = room_no;
    }

    public void setRoom_type(String room_type) {
        this.room_type = room_type;
    }

    public void setAvailable(boolean isAvailable) {
        this.isAvailable = isAvailable;
    }
}
