import View.*;

import java.util.Scanner;

import Controller.ModuleController;
import Controller.StudentController;

public class Main {
    public static void main(String[] args) {
        System.out.println("*************** Welcome to the Educational System!****************");

        Scanner scanner = new Scanner(System.in);
// Create instances of controllers

    StudentController studentController = new StudentController();
    ModuleController moduleController = new ModuleController();

        // Create views for each model
        DepartmentView departmentView = new DepartmentView();
        MajorView majorView = new MajorView();
        ModuleView moduleView = new ModuleView();
        StudentView studentView = new StudentView();
        TeacherView teacherView = new TeacherView();
        NoteView noteView = new NoteView(studentController, moduleController);

        // Display main menu
        boolean exit = false;

        while (!exit) {
            System.out.println("\nMain Menu: please pick a number from 1 to 6 ");
            System.out.println("\n ***************************************************************\n ");
            System.out.println("1. Department ");
            System.out.println("2. Major ");
            System.out.println("3. Module ");
            System.out.println("4. Student ");
            System.out.println("5. Teacher ");
            System.out.println("6. Update Note ");
            System.out.println("7. Exit");

            int choice = scanner.nextInt();
            scanner.nextLine(); 

            switch (choice) {
                case 1:
                    departmentView.departmentActions();
                    break;
                case 2:
                    majorView.majorActions();
                    break;
                case 3:
                    moduleView.moduleActions();
                    break;
                case 4:
                    studentView.studentActions();
                    break;
                case 5:
                    teacherView.teacherActions();
                    break;
                case 6:
                    noteView.noteActions();
                    break;
                case 7:
                    exit = true;
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }

        System.out.println("Thank you for using the Educational System!");
    }
}
