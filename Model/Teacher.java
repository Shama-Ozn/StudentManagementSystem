package Model;

import java.util.ArrayList;

public class Teacher {
    private int teacher_ID;
    private String T_1stName;
    private String T_lastName;
    private String email;
    private String grade ;
    public Department department;

    ArrayList <Module> module = new ArrayList<Module>();

    
//______________________Constructors___________________________
public Teacher(){}
public Teacher(int teacher_ID,String T_1stName,String T_lastName, String email,String grade, Department department)
{
    this.teacher_ID=teacher_ID;
    this.T_1stName=T_1stName;
    this.T_lastName=T_lastName;
    this.email=email;
    this.grade=grade;
    this.department=department;
}

//_______________________Getters______________________________
public Department getDepartment() {
    return department;
}
public String getEmail() {
    return email;
}
public String getGrade() {
    return grade;
}
public ArrayList<Module> getModule() {
    return module;
}
public String getT_1stName() {
    return T_1stName;
}
public int getTeacher_ID() {
    return teacher_ID;
}
public String getT_lastName() {
    return T_lastName;
}
//_____________________________Setters____________________________
public void setDepartment(Department department) {
    this.department = department;
}
public void setEmail(String email) {
    this.email = email;
}
public void setGrade(String grade) {
    this.grade = grade;
}
public void setModule(ArrayList<Module> module) {
    this.module = module;
}
public void setT_1stName(String t_1stName) {
    T_1stName = t_1stName;
}
public void setT_lastName(String t_lastName) {
    T_lastName = t_lastName;
}
public void setTeacher_ID(int teacher_ID) {
    this.teacher_ID = teacher_ID;
}

}
