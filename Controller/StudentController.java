package Controller;

import java.util.ArrayList;
import java.util.Iterator;

import Model.Major;
import Model.Student;

public class StudentController {
    private ArrayList<Student> students;
    private MajorController majorController;

    

   /*public StudentController(MajorController majorController) {
        students = new ArrayList<>();
        this.majorController = majorController;
    }*/
    public ArrayList<Major> getMajors() {
        return majorController.getMajors();
    }
    public StudentController() {
        students = new ArrayList<>();
        
        this.majorController = new MajorController();
    }
//___________________________ADD STUDENT________________________
    public void addStudent(int std_ID, String std_1stName, String std_lastName,
                           String email, Major major) {
        Student newStudent = new Student(std_ID, std_1stName, std_lastName, email, major);
        students.add(newStudent);
    }
//________________________DELETE STUDENT________________________
    public void deleteStudent(int std_ID) {
        Iterator<Student> iterator = students.iterator();
        while (iterator.hasNext()) {
            Student student = iterator.next();
            if (student.getStd_ID() == std_ID) {
                iterator.remove();
                System.out.println("Student deleted successfully!");
                return;
            }
        }
        System.out.println("Student not found. Deletion failed.");
    }
//________________________MODIFY STUDENT______________________________
    public void modifyStudent(int std_ID, String newFirstName, String newLastName,
                              String newEmail, Major newMajor) {
        for (Student student : students) {
            if (student.getStd_ID() == std_ID) {
                student.setStd_1stName(newFirstName);
                student.setStd_lastName(newLastName);
                student.setEmail(newEmail);
                student.setMajor(newMajor);
                System.out.println("Student modified successfully!");
                return;
            }
        }
        System.out.println("Student not found. Modification failed.");
    }
//_____________________DISPLAY all STUDENTs ________________________

    public ArrayList<Student> getStudents() {
        return students;
    }
//_____________________DISPLAY STUDENT dtails_________________________
    public void displayStudentDetails(Student student) {
        System.out.println("Student ID: " + student.getStd_ID());
        System.out.println("First Name: " + student.getStd_1stName());
        System.out.println("Last Name: " + student.getStd_lastName());
        System.out.println("Email: " + student.getEmail());
        System.out.println("Major: " + student.getMajor().getMajorTitle());
    }
}
