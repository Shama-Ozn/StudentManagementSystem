package Controller;

import Model.Note;
import Model.Student;
import Model.Module;

import java.util.ArrayList;
import java.util.Iterator;

public class NoteController {
    private ArrayList<Note> notes;

    public NoteController() {
        notes = new ArrayList<>();
    }

//_____________________________add note_________________________________________
    
    public void addNote(float note, Student student, Module module) {
        Note newNote = new Note(note, student, module);
        notes.add(newNote);
    }
    public void deleteNote(int studentID, String moduleTitle) {
        Iterator<Note> iterator = notes.iterator();
        while (iterator.hasNext()) {
            Note note = iterator.next();
            if (note.getStudent().getStd_ID() == studentID && note.getModule().getModuleTitle().equals(moduleTitle)) {
                iterator.remove();
                System.out.println("Note deleted successfully!");
                return;
            }
        }
        System.out.println("Note not found. Deletion failed.");
    }
//____________________________modify note_________________________________________

    public void modifyNote(int studentID, String moduleTitle, float newNoteValue) {
        for (Note note : notes) {
            if (note.getStudent().getStd_ID() == studentID && note.getModule().getModuleTitle().equals(moduleTitle)) {
                note.setNote(newNoteValue);
                System.out.println("Note modified successfully!");
                return;
            }
        }
        System.out.println("Note not found. Modification failed.");
    }
//____________________________display notes_________________________________________

    public ArrayList<Note> getNotes() {
        return notes;
    }
//____________________________display note details_________________________________________

    public void displayNoteDetails(Note note) {
        System.out.println("Student ID: " + note.getStudent().getStd_ID());
        System.out.println("Module Title: " + note.getModule().getModuleTitle());
        System.out.println("Note Value: " + note.getNote());
    }
}
