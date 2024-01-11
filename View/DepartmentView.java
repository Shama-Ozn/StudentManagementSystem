package View;

import Controller.DepartmentController;
import Model.Department;
import Model.Teacher;
import Model.Major;

import java.util.ArrayList;
import java.util.Scanner;

public class DepartmentView {
    private Scanner scanner;
    private DepartmentController departmentController;

    public DepartmentView() {
        scanner = new Scanner(System.in);
        departmentController = new DepartmentController();
    }

    public void departmentActions() {
        boolean exit = false;

        while (!exit) {
            System.out.println("\nDepartment Actions:");
            System.out.println("1. Add Department");
            System.out.println("2. Assign Major to Department");
            System.out.println("3. Display Department Details");
            System.out.println("4. Delete Department");
            System.out.println("5. Update Department");
            System.out.println("6. Exit");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    addDepartment();
                    break;
                case 2:
                    assignMajorToDepartment();
                    break;
                case 3:
                    displayDepartmentDetails();
                    break;
                case 4:
                    deleteDepartment();
                    break;
                case 5:
                    modifyDepartment();
                    break;
                case 6:
                    exit = true;
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
//________________add department________________________
    private void addDepartment() {
        System.out.println("Enter Department ID:");
        int deptId = scanner.nextInt();
        scanner.nextLine();

        System.out.println("Enter Department Title:");
        String title = scanner.nextLine();

// ______________Creating a new Teacher for the department head
        Teacher dpt_Head = createTeacher();

        departmentController.addDepartment(deptId, title, dpt_Head);
        System.out.println("Department added successfully!");
    }
//_______________assign Major to department__________________________________________
    private void assignMajorToDepartment() {
        System.out.println("Enter Department ID:");
        int deptId = scanner.nextInt();
        scanner.nextLine();

        Department department = departmentController.findDepartmentById(deptId);

        if (department != null) {
            System.out.println("Enter Major Title to assign:");
            String majorTitle = scanner.nextLine();
            Major major = new Major(majorTitle, null, department);  //here i need to modify this later

            departmentController.assignMajorToDepartment(department, major);
            System.out.println("Major assigned to Department successfully!");
        } else {
            System.out.println("Department not found. Assignment failed.");
        }
    }
//__________________delete department______________________________________
    private void deleteDepartment() {
        System.out.println("Enter Department ID to delete:");
        int deptId = scanner.nextInt();
        scanner.nextLine();

        departmentController.deleteDepartment(deptId);
    }
//__________________ update department_______________________________
    private void modifyDepartment() {
        System.out.println("Enter Department ID to modify:");
        int deptId = scanner.nextInt();
        scanner.nextLine();

        Department department = departmentController.findDepartmentById(deptId);

        if (department != null) {
            System.out.println("Enter new Department Title:");
            String newTitle = scanner.nextLine();

//Creating a new Teacher for the modified department head
            Teacher newDpt_Head = createTeacher();

            departmentController.modifyDepartment(deptId, newTitle, newDpt_Head);
        } else {
            System.out.println("Department not found. Please try again.");
        }
    }
//________________ display department details_______________________
    private void displayDepartmentDetails() {
        displayAllDepartments();
        System.out.println("Enter Department Title to display details:");
        String departmentTitle = scanner.nextLine();
    
        Department department = findDepartmentByTitle(departmentTitle);
    
        if (department != null) {
            departmentController.displayDepartmentDetails(department);
        } else {
            System.out.println("Department not found. Please try again.");
        }
    }
    private Department findDepartmentByTitle(String departmentTitle) {
        ArrayList<Department> departments = departmentController.getDepartments();
        for (Department department : departments) {
            if (department.getTitle().equals(departmentTitle)) {
                return department;
            }
        }
        return null; // Department not found
    }
//__________________________display All Departments__________________________________
private void displayAllDepartments() {
        ArrayList<Department> departments = departmentController.getDepartments();
        System.out.println("\nAll Departments:");

        for (Department department : departments) {
            System.out.println("Department Title: " + department.getTitle());
        }
    }
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

        return new Teacher(0, firstName, lastName, email, grade, null);//here I still don't know how to make a link it's a lil disturbing 
    }
}
