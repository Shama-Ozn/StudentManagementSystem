package View;

import Controller.DepartmentController;
import Controller.MajorController;

import Model.Major;
import Model.Department;
import Model.Teacher;

import java.util.ArrayList;
import java.util.Scanner;

public class MajorView {
    private Scanner scanner;
    private MajorController majorController;
//____________________________constructors____________________________
    public MajorView() {
        scanner = new Scanner(System.in);
        majorController = new MajorController();
    }

    public void majorActions() {
        boolean exit = false;

        while (!exit) {
            System.out.println("\nMajor Actions:");
            System.out.println("1. Add Major");
            System.out.println("2. Display Major Details");
            System.out.println("3. Delete Major");
            System.out.println("4. Update Major");
            System.out.println("5. Exit");//enough 3lih.. drna assign f dep view

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    addMajor();
                    break;
                case 2:
                    displayMajorDetails();
                    break;
                case 3:
                    deleteMajor();
                    break;
                case 4:
                    modifyMajor();
                    break;
                case 5:
                    exit = true;
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
//______________________add Major________________________
    private void addMajor() {
        System.out.println("Enter Major Title:");
        String majorTitle = scanner.nextLine();

//Creating a Teacher for the major 
        Teacher dpt_Head = createTeacher();

        System.out.println("Enter Department Title for the Major:");
        String departmentTitle = scanner.nextLine();

        Department department = findDepartmentByTitle(departmentTitle);

        if (department != null) {
            majorController.addMajor(majorTitle, dpt_Head, department);
            System.out.println("Major added successfully!");
        } else {
            System.out.println("Department not found. Major addition failed.");
        }
    }
//_______________________________delete major______________________________
    private void deleteMajor() {
        System.out.println("Enter Major Title to delete:");
        String majorTitle = scanner.nextLine();

        majorController.deleteMajor(majorTitle);
    }
//_____________________________update major__________________________________
    private void modifyMajor() {
        System.out.println("Enter Major Title to modify:");
        String majorTitle = scanner.nextLine();

        Major major = findMajorByTitle(majorTitle);

        if (major != null) {
            // Creating a new Teacher for the modified major 
            Teacher newDpt_Head = createTeacher();

            majorController.modifyMajor(majorTitle, newDpt_Head);
        } else {
            System.out.println("Major not found. Modification failed.");
        }
    }
//___________________________display major details_______________________________
    private void displayMajorDetails() {
        displayAllMajors();
        System.out.println("Enter Major Title to display details:");
        String majorTitle = scanner.nextLine();

        Major major = findMajorByTitle(majorTitle);

        if (major != null) {
            majorController.displayMajorDetails(major);
        } else {
            System.out.println("Major not found. Please try again.");
        }
    }
//_____________DISPLAY MAJORS JUMLATAN WA TAFSILA _________________________
    private void displayAllMajors() {
        ArrayList<Major> majors = majorController.getMajors();
        System.out.println("\nAll Majors:");

        for (Major major : majors) {
            System.out.println("Major Title: " + major.getMajorTitle());
        }
    }
//_______________________create teacher for that major __________________________________
    private Teacher createTeacher() {
        System.out.println("Enter Teacher details:");
        System.out.println("First Name:");
        String firstName = scanner.nextLine();
        System.out.println("Last Name:");
        String lastName = scanner.nextLine();
        System.out.println("Email:");
        String email = scanner.nextLine();
        System.out.println("Grade:");
        String grade = scanner.nextLine();
    
        return new Teacher(0, firstName, lastName, email, grade, null);
    }
    
    private Department findDepartmentByTitle(String departmentTitle) {
    DepartmentController departmentController = new DepartmentController();//because getDepartments is not static darori diri instance l depcontroller
    for (Department department : departmentController.getDepartments()) {
        if (department.getTitle().equals(departmentTitle)) {
            return department;
        }
    }
    return null; // Department not found
}

    private Major findMajorByTitle(String majorTitle) {
        for (Major major : majorController.getMajors()) {
            if (major.getMajorTitle() .equals(majorTitle)) {
                return major;
            }
        }
        return null; // Major not found
    }
    
}
