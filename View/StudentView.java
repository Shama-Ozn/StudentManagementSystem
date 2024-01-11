package View;

import Controller.StudentController;
import Model.Student;
import Model.Major;

import java.util.ArrayList;
import java.util.Scanner;

public class StudentView {
    private Scanner scanner;
    private StudentController studentController;
    

    public StudentView() {
        scanner = new Scanner(System.in);
        studentController = new StudentController();
    }

    public void studentActions() {
        boolean exit = false;

        while (!exit) {
            System.out.println("\nStudent Actions:");
            System.out.println("1. Add Student");
            System.out.println("2. Display Student Details");
            System.out.println("3. Delete Student");
            System.out.println("4. Modify Student");
            System.out.println("5. Exit");

            int choice = scanner.nextInt();
            scanner.nextLine(); 

            switch (choice) {
                case 1:
                    addStudent();
                    break;
                case 2:
                    displayStudentDetails();
                    break;
                case 3:
                    deleteStudent();
                    break;
                case 4:
                    modifyStudent();
                    break;
                case 5:
                    exit = true;
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
//___________________________________add student ________________________________

    private void addStudent() {
        System.out.println("Enter Student ID:");
        int std_ID = scanner.nextInt();
        scanner.nextLine(); 

        System.out.println("Enter Student First Name:");
        String std_1stName = scanner.nextLine();

        System.out.println("Enter Student Last Name:");
        String std_lastName = scanner.nextLine();

        System.out.println("Enter Student Email:");
        String email = scanner.nextLine();

        displayAllMajors();
        System.out.println("Enter Major Title for the Student:");
        String majorTitle = scanner.nextLine();

        Major major = findMajorByTitle(majorTitle);

        if (major != null) {
            studentController.addStudent(std_ID, std_1stName, std_lastName, email, major);
            System.out.println("Student added successfully!");
        } else {
            System.out.println("Major not found. Student addition failed.");
        }
    }
//_________________________________delete student ________________________________

    private void deleteStudent() {
        System.out.println("Enter Student ID to delete:");
        int std_ID = scanner.nextInt();
        scanner.nextLine(); 

        studentController.deleteStudent(std_ID);
    }
//_________________________________update student ________________________________

    private void modifyStudent() {
        System.out.println("Enter Student ID to modify:");
        int std_ID = scanner.nextInt();
        scanner.nextLine(); 

        Student student = findStudentById(std_ID);

        if (student != null) {
            System.out.println("Enter new Student First Name:");
            String newFirstName = scanner.nextLine();

            System.out.println("Enter new Student Last Name:");
            String newLastName = scanner.nextLine();

            System.out.println("Enter new Student Email:");
            String newEmail = scanner.nextLine();

            displayAllMajors();
            System.out.println("Enter new Major Title for the Student:");
            String newMajorTitle = scanner.nextLine();

            Major newMajor = findMajorByTitle(newMajorTitle);

            if (newMajor != null) {
                studentController.modifyStudent(std_ID, newFirstName, newLastName, newEmail, newMajor);
            } else {
                System.out.println("Major not found. Modification failed.");
            }
        } else {
            System.out.println("Student not found. Modification failed.");
        }
    }
//_________________________________display student details___________________________

    private void displayStudentDetails() {
        displayAllStudents();
        System.out.println("Enter Student ID to display details:");
        int std_ID = scanner.nextInt();
        scanner.nextLine(); 

        Student student = findStudentById(std_ID);

        if (student != null) {
            studentController.displayStudentDetails(student);
        } else {
            System.out.println("Student not found. Please try again.");
        }
    }

    private void displayAllStudents() {
        ArrayList<Student> students = studentController.getStudents();
        System.out.println("\nAll Students:");

        for (Student student : students) {
            System.out.println("Student ID: " + student.getStd_ID());
        }
    }

    private void displayAllMajors() {
        ArrayList<Major> majors = studentController.getMajors();
        System.out.println("\nAll Majors:");
    
        for (Major major : majors) {
            System.out.println("Major Title: " + major.getMajorTitle());
        }
    }
    

    private Major findMajorByTitle(String majorTitle) {
        ArrayList<Major> majors = studentController.getMajors();
        
        for (Major major : majors) {
            if (major.getMajorTitle().equals(majorTitle)) {
                return major;
            }
        }
        
        return null; // Major not found
    }
    

    private Student findStudentById(int std_ID) {
    ArrayList<Student> students = studentController.getStudents();

    for (Student student : students) {
        if (student.getStd_ID() == std_ID) {
            return student;
        }
    }

    return null; // Student not found
}
}

