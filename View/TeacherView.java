package View;

import Controller.TeacherController;
import Model.Teacher;
import Model.Department;

import java.util.ArrayList;
import java.util.Scanner;

public class TeacherView {
    private Scanner scanner;
    private TeacherController teacherController;

    public TeacherView() {
        scanner = new Scanner(System.in);
        teacherController = new TeacherController();
    }

    public void teacherActions() {
        boolean exit = false;

        while (!exit) {
            System.out.println("\nTeacher Actions:");
            System.out.println("1. Add Teacher");
            System.out.println("2. Display Teacher Details");
            System.out.println("3. Delete Teacher");
            System.out.println("4. Update Teacher");
            System.out.println("5. Exit");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    addTeacher();
                    break;
                case 2:
                    displayTeacherDetails();
                    break;
                case 3:
                    deleteTeacher();
                    break;
                case 4:
                    modifyTeacher();
                    break;
                case 5:
                    exit = true;
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
//___________________________________add teacher ________________________________

    private void addTeacher() {
        System.out.println("Enter Teacher ID:");
        int teacher_ID = scanner.nextInt();
        scanner.nextLine(); 

        System.out.println("Enter Teacher First Name:");
        String T_1stName = scanner.nextLine();

        System.out.println("Enter Teacher Last Name:");
        String T_lastName = scanner.nextLine();

        System.out.println("Enter Teacher Email:");
        String email = scanner.nextLine();

        System.out.println("Enter Teacher Grade:");
        String grade = scanner.nextLine();

        displayAllDepartments();
        System.out.println("Enter Department Title for the Teacher:");
        String departmentTitle = scanner.nextLine();

        Department department = findDepartmentByTitle(departmentTitle);

        if (department != null) {
            teacherController.addTeacher(teacher_ID, T_1stName, T_lastName, email, grade, department);
            System.out.println("Teacher added successfully!");
        } else {
            System.out.println("Department not found. Teacher addition failed.");
        }
    }
//________________________________delete teacher ________________________________

    private void deleteTeacher() {
        System.out.println("Enter Teacher ID to delete:");
        int teacher_ID = scanner.nextInt();
        scanner.nextLine(); 

        teacherController.deleteTeacher(teacher_ID);
    }
//________________________________Update teacher ________________________________

    private void modifyTeacher() {
        System.out.println("Enter Teacher ID to modify:");
        int teacher_ID = scanner.nextInt();
        scanner.nextLine(); 

        Teacher teacher = findTeacherById(teacher_ID);

        if (teacher != null) {
            System.out.println("Enter new Teacher First Name:");
            String newFirstName = scanner.nextLine();

            System.out.println("Enter new Teacher Last Name:");
            String newLastName = scanner.nextLine();

            System.out.println("Enter new Teacher Email:");
            String newEmail = scanner.nextLine();

            System.out.println("Enter new Teacher Grade:");
            String newGrade = scanner.nextLine();

            displayAllDepartments();
            System.out.println("Enter new Department Title for the Teacher:");
            String newDepartmentTitle = scanner.nextLine();

            Department newDepartment = findDepartmentByTitle(newDepartmentTitle);

            if (newDepartment != null) {
                teacherController.modifyTeacher(teacher_ID, newFirstName, newLastName, newEmail, newGrade, newDepartment);
            } else {
                System.out.println("Department not found. Modification failed.");
            }
        } else {
            System.out.println("Teacher not found. Modification failed.");
        }
    }
//_________________________________display teacher details________________________________

    private void displayTeacherDetails() {
        displayAllTeachers();
        System.out.println("Enter Teacher ID to display details:");
        int teacher_ID = scanner.nextInt();
        scanner.nextLine(); 

        Teacher teacher = findTeacherById(teacher_ID);

        if (teacher != null) {
            teacherController.displayTeacherDetails(teacher);
        } else {
            System.out.println("Teacher not found. Please try again.");
        }
    }

    private void displayAllTeachers() {
        ArrayList<Teacher> teachers = teacherController.getTeachers();
        System.out.println("\nAll Teachers:");

        for (Teacher teacher : teachers) {
            System.out.println("Teacher ID: " + teacher.getTeacher_ID());
        }
    }

    private void displayAllDepartments() {
        ArrayList<Department> departments = teacherController.getAllDepartments();
        System.out.println("\nAll Departments:");
    
        for (Department department : departments) {
            System.out.println("Department Title: " + department.getTitle());
        }
    }
    
    private Department findDepartmentByTitle(String departmentTitle) {
        ArrayList<Department> departments = teacherController.getAllDepartments();
        for (Department department : departments) {
            if (department.getTitle().equals(departmentTitle)) {
                return department;
            }
        }
        return null; // Department not found
    }
    
    private Teacher findTeacherById(int teacher_ID) {
        ArrayList<Teacher> teachers = teacherController.getTeachers();
        for (Teacher teacher : teachers) {
            if (teacher.getTeacher_ID() == teacher_ID) {
                return teacher;
            }
        }
        return null; // Teacher not found
    }
    
}
