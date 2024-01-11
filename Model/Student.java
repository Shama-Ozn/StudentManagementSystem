package Model;

import java.util.ArrayList;

public class Student {
    private int std_ID;
    private String std_1stName;
    private String std_lastName;
    private String email;
    public Major major;

    ArrayList<Note> note = new ArrayList<Note>();

//______________________constructos________________________________
public Student()
{}
public Student(int std_ID , String std_1stName, String std_lastName , String email, Major major)
{
    this.std_ID=std_ID;
    this.std_1stName=std_1stName;
    this.std_lastName=std_lastName;
    this.email=email;
    this.major=major;
}
//_______________________Getters&Setters_____________________________
public String getEmail() {
    return email;
}
public Major getMajor() {
    return major;
}
public ArrayList<Note> getNote() {
    return note;
}
public String getStd_1stName() {
    return std_1stName;
}
public int getStd_ID() {
    return std_ID;
}
public String getStd_lastName() {
    return std_lastName;
}
//_____________________________________________________
public void setEmail(String email) {
    this.email = email;
}
public void setMajor(Major major) {
    this.major = major;
}
public void setNote(ArrayList<Note> note) {
    this.note = note;
}
public void setStd_1stName(String std_1stName) {
    this.std_1stName = std_1stName;
}
public void setStd_ID(int std_ID) {
    this.std_ID = std_ID;
}
public void setStd_lastName(String std_lastName) {
    this.std_lastName = std_lastName;
}
}
