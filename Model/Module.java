package Model;

public class Module {
    private String moduleTitle ;
    public Major major ;
    public Teacher teacher;
    
    
//__________________constructors____________________________________
public Module()
{}
public Module (String moduleTitle , Major major ,Teacher teacher)
{
    this.moduleTitle=moduleTitle;
    this.major=major;
    this.teacher=teacher;
}
//__________________________Getters&Setters____________________________

public Major getMajor() {
    return major;
}
public String getModuleTitle() {
    return moduleTitle;
}
public Teacher getTeacher() {
    return teacher;
}
public void setMajor(Major major) {
    this.major = major;
}
public void setModuleTitle(String moduleTitle) {
    this.moduleTitle = moduleTitle;
}
public void setTeacher(Teacher teacher) {
    this.teacher = teacher;
}

}
