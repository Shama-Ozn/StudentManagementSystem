package View;

import Controller.ModuleController;
import Controller.NoteController;
import Controller.StudentController;
import Model.Note;
import Model.Student;
import Model.Module;

import java.util.ArrayList;
import java.util.Scanner;

public class NoteView {
    private Scanner scanner;
    private NoteController noteController;
    private StudentController studentController;
    private ModuleController moduleController;

    public NoteView(StudentController studentController, ModuleController moduleController)
    {
        scanner = new Scanner(System.in);
        noteController = new NoteController();
        this.studentController = studentController;
        this.moduleController = moduleController;
    }
    public void noteActions() {
        boolean exit = false;

        while (!exit) {
            System.out.println("\nNote Actions:");
            System.out.println("1. Add Note");
            System.out.println("2. Display Note Details");
            System.out.println("3. Delete Note");
            System.out.println("4. Update Note");
            System.out.println("5. Exit");

            int choice = scanner.nextInt();
            scanner.nextLine(); 

            switch (choice) {
                case 1:
                    addNote();
                    break;
                case 2:
                    displayNoteDetails();
                    break;
                case 3:
                    deleteNote();
                    break;
                case 4:
                    modifyNote();
                    break;
                case 5:
                    exit = true;
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
//___________________________________add note ________________________________

    private void addNote() {
        System.out.println("Enter Student ID:");
        int studentID = scanner.nextInt();
        scanner.nextLine();
    
        System.out.println("Enter Module Title:");
        String moduleTitle = scanner.nextLine();
    
        displayAllStudents();
        displayAllModules();
        
        
        System.out.println("Enter Student ID for the Note:");
        int studentIDForNote = scanner.nextInt();
        scanner.nextLine(); 

        System.out.println("Enter Module Title for the Note:");
        String moduleTitleForNote = scanner.nextLine();
    
        Module module = findModuleByTitle(moduleTitleForNote);
        Student student = findStudentById(studentIDForNote);
    
        if (module != null && student != null && studentIDForNote == studentID && moduleTitleForNote.equals(moduleTitle)) {
            System.out.println("Enter Note Value:");
            float noteValue = scanner.nextFloat();
    
            noteController.addNote(noteValue, student, module);
            System.out.println("Note added successfully!");
        } else {
            System.out.println("Student or Module not found. Note addition failed.");
        }
    }
    
//___________________________________add note ________________________________

    private void deleteNote() {
        System.out.println("Enter Student ID to delete Note:");
        int studentID = scanner.nextInt();
        scanner.nextLine(); 

        System.out.println("Enter Module Title to delete Note:");
        String moduleTitle = scanner.nextLine();

        noteController.deleteNote(studentID, moduleTitle);
    }
//___________________________________modify note ________________________________

    private void modifyNote() {
        System.out.println("Enter Student ID to modify Note:");
        int studentID = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Enter Module Title to modify Note:");
        String moduleTitle = scanner.nextLine();

        Note note = findNoteByStudentAndModule(studentID, moduleTitle);

        if (note != null) {
            System.out.println("Enter new Note Value:");
            float newNoteValue = scanner.nextFloat();

            noteController.modifyNote(studentID, moduleTitle, newNoteValue);
        } else {
            System.out.println("Note not found. Modification failed.");
        }
    }
//___________________________________display note details ________________________________

    private void displayNoteDetails() {
        displayAllNotes();
        System.out.println("Enter Student ID for the Note:");
        int studentID = scanner.nextInt();
        scanner.nextLine();

        System.out.println("Enter Module Title for the Note:");
        String moduleTitle = scanner.nextLine();

        Note note = findNoteByStudentAndModule(studentID, moduleTitle);

        if (note != null) {
            noteController.displayNoteDetails(note);
        } else {
            System.out.println("Note not found. Please try again.");
        }
    }
//__________________________________display notes ________________________________

    private void displayAllNotes() {
        ArrayList<Note> notes = noteController.getNotes();
        System.out.println("\nAll Notes:");

        for (Note note : notes) {
            System.out.println("Student ID: " + note.getStudent().getStd_ID() +
                    ", Module Title: " + note.getModule().getModuleTitle());
        }
    }

    

private void displayAllStudents() {
    ArrayList<Student> students = studentController.getStudents();
    System.out.println("\nAll Students:");

    for (Student student : students) {
        System.out.println("Student ID: " + student.getStd_ID() +
                ", Name: " + student.getStd_1stName() + " " + student.getStd_lastName());
    }
}

private void displayAllModules() {
    ArrayList<Module> modules = moduleController.getModules();
    System.out.println("\nAll Modules:");

    for (Module module : modules) {
        System.out.println("Module Title: " + module.getModuleTitle());
    }
}

private Student findStudentById(int studentID) {
    ArrayList<Student> students = studentController.getStudents();

    for (Student student : students) {
        if (student.getStd_ID() == studentID) {
            return student;
        }
    }
    return null; // Student not found
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
//__________________________________find note ________________________________

private Note findNoteByStudentAndModule(int studentID, String moduleTitle) {
    ArrayList<Note> notes = noteController.getNotes();

    for (Note note : notes) {
        Student student = note.getStudent();
        Module module = note.getModule();

        if (student.getStd_ID() == studentID && module.getModuleTitle().equals(moduleTitle)) {
            return note;
        }
    }
    return null; // Note not found
}

}
