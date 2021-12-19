package Entity;

import java.util.Date;

public class Persona {
    private int ID;
    private String firstname;
    private String lastname;
    private String birthday;
    private String email;
    private Date timestamp_register;
    private Date timestamp_update;
    private User objUser;

    public Persona() {
        this.ID = 0;
        this.firstname = "";
        this.lastname = "";
        this.birthday = "";
        this.email = "";
        this.timestamp_register = new Date();
        this.timestamp_update = new Date();
        this.objUser=new User();

    }

    public Persona(int ID, String firstname, String lastname, String birthday, String email, Date timestamp_register, Date timestamp_update, User objUser) {
        this.ID = ID;
        this.firstname = firstname;
        this.lastname = lastname;
        this.birthday = birthday;
        this.email = email;
        this.timestamp_register = timestamp_register;
        this.timestamp_update = timestamp_update;
        this.objUser=objUser;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getTimestamp_register() {
        return timestamp_register;
    }

    public void setTimestamp_register(Date timestamp_register) {
        this.timestamp_register = timestamp_register;
    }

    public Date getTimestamp_update() {
        return timestamp_update;
    }

    public void setTimestamp_update(Date timestamp_update) {
        this.timestamp_update = timestamp_update;
    }

    public User getObjUser(){
        return objUser;
    }

    public void setObjUser(User objUser){
        this.objUser=objUser;
    }

    @Override
    public String toString() {
        return "Persona{" +
                "ID=" + ID +
                ", firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                ", birthday='" + birthday + '\'' +
                ", email='" + email + '\'' +
                ", timestamp_register=" + timestamp_register +
                ", timestamp_update=" + timestamp_update +
                ", objUser=" + objUser +
                '}';
    }
}
