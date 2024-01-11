package Controller;

import Model.Major;
import Model.Department;
import Model.Teacher;

import java.util.ArrayList;
import java.util.Iterator;

public class MajorController {
    private ArrayList<Major> majors;
//__________________default constructor___________________
    public MajorController() {
        majors = new ArrayList<>();
    }
//__________________ADD MAJOR ___________________________
    public void addMajor(String majorTitle, Teacher dpt_Head, Department department) {
        Major newMajor = new Major(majorTitle, dpt_Head, department);
        majors.add(newMajor);
    }
//________________DELETE MAJOR________________________________
    public void deleteMajor(String majorTitle) {
        Iterator<Major> iterator = majors.iterator();
        while (iterator.hasNext()) {
            Major major = iterator.next();
            if (major.getMajorTitle().equals(majorTitle)) {
                iterator.remove();
                System.out.println("Major deleted successfully!");
                return;
            }
        }
        System.out.println("Major not found. Deletion failed.");
    }
//_______________________MODIFY MAJOR_____________________________
    public void modifyMajor(String majorTitle, Teacher newDpt_Head) {
        for (Major major : majors) {
            if (major.getMajorTitle().equals(majorTitle)) {
                major.setDpt_Head(newDpt_Head);
                System.out.println("Major modified successfully!");
                return;
            }
        }
        System.out.println("Major not found. Modification failed.");
    }

    public ArrayList<Major> getMajors() {
        return majors;
    }
//__________________________DISPLAY MAJOR_______________________________________
    public void displayMajorDetails(Major major) {
        System.out.println("Major Title: " + major.getMajorTitle());
        System.out.println("Major Head: " + major.getDpt_Head().getT_1stName() + " " +
                major.getDpt_Head().getT_lastName());
        System.out.println("Department: " + major.getDepartment().getTitle());
    }
}
