package View;

import Controller.ModuleController;

import Model.Module;
import Model.Major;
import Model.Teacher;

import java.util.ArrayList;
import java.util.Scanner;

public class ModuleView {
    private Scanner scanner;
    private ModuleController moduleController;

    public ModuleView() {
        scanner = new Scanner(System.in);
        moduleController = new ModuleController();
    }

    public void moduleActions() {
        boolean exit = false;

        while (!exit) {
            System.out.println("\nModule Actions:");
            System.out.println("1. Add Module");
            System.out.println("2. Display Module Details");
            System.out.println("3. Delete Module");
            System.out.println("4. Update Module");
            System.out.println("5. Exit");

            int choice = scanner.nextInt();
            scanner.nextLine(); 

            switch (choice) {
                case 1:
                    addModule();
                    break;
                case 2:
                    displayModuleDetails();
                    break;
                case 3:
                    deleteModule();
                    break;
                case 4:
                    modifyModule();
                    break;
                case 5:
                    exit = true;
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
//___________________________________add module ________________________________

    private void addModule() {
        System.out.println("Enter Module Title:");
        String moduleTitle = scanner.nextLine();

        displayAllMajors();
        System.out.println("Enter Major Title for the Module:");
        String majorTitle = scanner.nextLine();

        Major major = findMajorByTitle(majorTitle);

        if (major != null) {
            // Creating a Teacher for the module
            Teacher teacher = createTeacher();

            moduleController.addModule(moduleTitle, major, teacher);
            System.out.println("Module added successfully!");
        } else {
            System.out.println("Major not found. Module addition failed.");
        }
    }
//__________________________________delete module ________________________________

    private void deleteModule() {
        System.out.println("Enter Module Title to delete:");
        String moduleTitle = scanner.nextLine();

        moduleController.deleteModule(moduleTitle);
    }
//__________________________________update module ________________________________

    private void modifyModule() {
        System.out.println("Enter Module Title to modify:");
        String moduleTitle = scanner.nextLine();

        Module module = findModuleByTitle(moduleTitle);

        if (module != null) {
            displayAllMajors();
            System.out.println("Enter new Major Title for the Module:");
            String newMajorTitle = scanner.nextLine();

            Major newMajor = findMajorByTitle(newMajorTitle);

            if (newMajor != null) {
                // Creating a new Teacher for the modified module
                Teacher newTeacher = createTeacher();

                moduleController.modifyModule(moduleTitle, newMajor, newTeacher);
            } else {
                System.out.println("Major not found. Modification failed.");
            }
        } else {
            System.out.println("Module not found. Modification failed.");
        }
    }
//_________________________________display module details________________________________

    private void displayModuleDetails() {
        displayAllModules();
        System.out.println("Enter Module Title to display details:");
        String moduleTitle = scanner.nextLine();

        Module module = findModuleByTitle(moduleTitle);

        if (module != null) {
            moduleController.displayModuleDetails(module);
        } else {
            System.out.println("Module not found. Please try again.");
        }
    }
//__________________________________display all modules ________________________________

    private void displayAllModules() {
        ArrayList<Module> modules = moduleController.getModules();
        System.out.println("\nAll Modules:");

        for (Module module : modules) {
            System.out.println("Module Title: " + module.getModuleTitle());
        }
    }
    private void displayAllMajors() {
        ArrayList<Major> majors = moduleController.getAllMajors();
        System.out.println("\nAll Majors:");
    
        for (Major major : majors) {
            System.out.println("Major Title: " + major.getMajorTitle());
        }
    }
    //create teacher of that module
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

    private Major findMajorByTitle(String majorTitle) {
        ArrayList<Major> majors = moduleController.getAllMajors();
        for (Major major : majors) {
            if (major.getMajorTitle().equals(majorTitle)) {
                return major;
            }
        }
        return null; // Major not found
    }
    private Module findModuleByTitle(String moduleTitle) {
        ArrayList<Module> modules = moduleController.getModules();
        for (Module module : modules) {
            if (module.getModuleTitle().equals(moduleTitle)) {
                return module;
            }
        }
        return null; // Module not found
    }
    
}