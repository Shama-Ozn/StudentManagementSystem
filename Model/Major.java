package Model;
import java.util.ArrayList;

public class Major {
    private String majorTitle;
    private Teacher dpt_Head;
    private Department department;

    ArrayList <Module> module = new ArrayList<Module>();

//___________________Constructoooors___________________________

public Major()
{}
public Major (String majorTitle,Teacher dpt_Head,Department department)
{
    this.majorTitle=majorTitle;
    this.dpt_Head=dpt_Head;
    this.department=department;
}
//_____________________Getters&Setters__________________________
public Department getDepartment() {
    return department;
}
public Teacher getDpt_Head() {
    return dpt_Head;
}
public String getMajorTitle() {
    return majorTitle;
}
public ArrayList<Module> getModule() {
    return module;
}
public void setDepartment(Department department) {
    this.department = department;
}
public void setDpt_Head(Teacher dpt_Head) {
    this.dpt_Head = dpt_Head;
}
public void setMajorTitle(String majorTitle) {
    this.majorTitle = majorTitle;
}
public void setModule(ArrayList<Module> module) {
    this.module = module;
}





}
