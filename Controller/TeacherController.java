package Controller;

import Model.Teacher;
import Model.Department;


import java.util.ArrayList;
import java.util.Iterator;

public class TeacherController {
    private ArrayList<Teacher> teachers;
    private DepartmentController departmentController;
//_____________GET ALL DEPARTMENTS_________________________
    public ArrayList<Department> getAllDepartments() {
        return departmentController.getDepartments();
    }
    public TeacherController() {
        teachers = new ArrayList<>();
    }
//________________________ADD TEACHER_____________________
    public void addTeacher(int teacher_ID, String T_1stName, String T_lastName,
                        String email, String grade, Department department) {
        Teacher newTeacher = new Teacher(teacher_ID, T_1stName, T_lastName, email, grade, department);
        teachers.add(newTeacher);
    }
//_____________________DELETE TEACHER____________________________
    public void deleteTeacher(int teacher_ID) {
        Iterator<Teacher> iterator = teachers.iterator();
        while (iterator.hasNext()) {
            Teacher teacher = iterator.next();
            if (teacher.getTeacher_ID() == teacher_ID) {
                iterator.remove();
                System.out.println("Teacher deleted successfully!");
                return;
            }
        }
        System.out.println("Teacher not found. Deletion failed.");
    }
//____________________update TEACHER________________________________
    public void modifyTeacher(int teacher_ID, String newFirstName, String newLastName,
                                String newEmail, String newGrade, Department newDepartment) {
        for (Teacher teacher : teachers) {
            if (teacher.getTeacher_ID() == teacher_ID) {
                teacher.setT_1stName(newFirstName);
                teacher.setT_lastName(newLastName);
                teacher.setEmail(newEmail);
                teacher.setGrade(newGrade);
                teacher.setDepartment(newDepartment);
                System.out.println("Teacher modified successfully!");
                return;
            }
        }
        System.out.println("Teacher not found. Modification failed.");
    }
//________________________DISPLAY all Teachers _______________

    public ArrayList<Teacher> getTeachers() {
        return teachers;
    }
//________________________DISPLAY T-DETAILS_______________
    public void displayTeacherDetails(Teacher teacher) {
        System.out.println("Teacher ID: " + teacher.getTeacher_ID());
        System.out.println("First Name: " + teacher.getT_1stName());
        System.out.println("Last Name: " + teacher.getT_lastName());
        System.out.println("Email: " + teacher.getEmail());
        System.out.println("Grade: " + teacher.getGrade());
        System.out.println("Department: " + teacher.getDepartment().getTitle());
    }
}
