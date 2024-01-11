package Model;

public class Note {
    private float note;
    public Student student;
    public Module module;

//_____________________Constructors________________________
public Note()
{}
public Note(float note, Student student, Module module)
{
    this.note=note;
    this.student=student;
    this.module=module;
}

//___________________________Setters_________________________

public void setModule(Module module) {
    this.module = module;
}
public void setNote(float note) {
    this.note = note;
}
public void setStudent(Student student) {
    this.student = student;
}
//___________________________Getters_________________________
public Module getModule() {
    return module;
}
public float getNote() {
    return note;
}
public Student getStudent() {
    return student;
}
}
