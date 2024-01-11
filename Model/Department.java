package Model;

import java.util.ArrayList;

public class Department {
    private int dept_id;
    private String title ;
    private Teacher dpt_Head;

    ArrayList<Major> major = new ArrayList<Major>();
//__________________constructors________________________
public Department()
{}

public Department(int dept_id, String title, Teacher dpt_Head)//hna mli derna manager blast dpt_head fash kant katl3 dik l3iba dyal "ra ma feha nf3 ghi 7ydiha" 39li yalmosiba tsd9i dayraha 3ib tgoli 9riti java ga3 shewehtina
{
    this.dept_id = dept_id;
    this.title = title;
    this.dpt_Head = dpt_Head;
}

//_________________Getters&Setters_____________________________
public void setDpt_id(int dept_id) {
    this.dept_id = dept_id;
}
public void setDpt_Head(Teacher dpt_Head) {
    this.dpt_Head = dpt_Head;
}
public void setTitle(String title) {
    this.title = title;
}
public int getDpt_id() {
    return dept_id;
}
public Teacher getDpt_Head() {
    return dpt_Head;
}
public String getTitle() {
    return title;
}
public ArrayList<Major> getMajor() {
    return major;
}
public void setMajor(ArrayList<Major> major) {
    this.major = major;
}
}
