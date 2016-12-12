package yonatan.domain;

import java.util.Date;

/**
 * Created by Yonatan on 06/12/2016.
 */
public class SimplePerson implements IPerson {

    private int id;
    private String firstName;
    private String lastName;
    private Date birthday;
    private int height; //in centimetres

    public SimplePerson(int id, String firstName, String lastName, Date birthday, int height) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthday = birthday;
        this.height = height;
    }

    @Override
    public int getId() {
        return 0;
    }

    @Override
    public String getFirstName() {
        return this.firstName;
    }

    @Override
    public String getLastName() {
        return this.lastName;
    }

    @Override
    public Date getDateOfBirth() {
        return this.birthday;
    }

    @Override
    public int getHeight() {
        return 0;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public String getFullName(){
        return this.firstName + " " + this.lastName;
    }

    @Override
    public int compareTo(IPerson o) {
        return this.getFullName().compareTo(o.getFirstName()+ " " +o.getLastName());
    }

    @Override
    public String toString() {
        return this.firstName + " " + this.lastName;
    }
}
