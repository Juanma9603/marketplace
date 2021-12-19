package Entity;

import java.util.Date;

public class User {
    private int ID;
    private String Username;
    private String Password;
    private int Status;
    private Date timestamp_register;
    private Date timestamp_update;

    public User() {
        this.ID = 0;
        this.Username = "";
        this.Password = "";
        this.Status = 0;
        this.timestamp_register = new Date();
        this.timestamp_update=new Date();
    }

    public User(int ID, String username, String password, int status, Date timestamp_register, Date timestamp_update) {
        this.ID = ID;
        this.Username = username;
        this.Password = password;
        this.Status = status;
        this.timestamp_register = timestamp_register;
        this.timestamp_update=timestamp_update;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getUsername() {
        return Username;
    }

    public void setUsername(String username) {
        Username = username;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }

    public int getStatus() {
        return Status;
    }

    public void setStatus(int status) {
        Status = status;
    }

    public Date getTimestamp_register() {
        return timestamp_register;
    }

    public void setTimestamp_register(Date timestamp_register) {
        this.timestamp_register = timestamp_register;
    }

    @Override
    public String toString() {
        return "User{" +
                "ID=" + ID +
                ", Username='" + Username + '\'' +
                ", Password='" + Password + '\'' +
                ", Status=" + Status +
                ", timestamp_register=" + timestamp_register +
                ", timestamp_update=" + timestamp_update +
                '}';
    }
}
