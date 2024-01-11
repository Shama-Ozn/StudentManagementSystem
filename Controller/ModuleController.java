package Controller;

import Model.Module;
import Model.Major;
import Model.Teacher;

import java.util.ArrayList;
import java.util.Iterator;

public class ModuleController {
    private ArrayList<Module> modules;
    private ArrayList<Major> majors;

    public ModuleController() {
        modules = new ArrayList<>();
    }
//_____________________________add module_______________________________________
    public void addModule(String moduleTitle, Major major, Teacher teacher) {
        Module newModule = new Module(moduleTitle, major, teacher);
        modules.add(newModule);
    }
//________________________delete module _______________________________________
    public void deleteModule(String moduleTitle) {
        Iterator<Module> iterator = modules.iterator();
        while (iterator.hasNext()) {
            Module module = iterator.next();
            if (module.getModuleTitle().equals(moduleTitle)) {
                iterator.remove();
                System.out.println("Module deleted successfully!");
                return;
            }
        }
        System.out.println("Module not found. Deletion failed.");
    }
//_____________________________update module_______________________________________

    public void modifyModule(String moduleTitle, Major newMajor, Teacher newTeacher) {
        for (Module module : modules) {
            if (module.getModuleTitle().equals(moduleTitle)) {
                module.setMajor(newMajor);
                module.setTeacher(newTeacher);
                System.out.println("Module modified successfully!");
                return;
            }
        }
        System.out.println("Module not found. Modification failed.");
    }
//_____________________________display all modules_______________________________________

    public ArrayList<Module> getModules() {
        return modules;
    }
    public ArrayList<Major> getAllMajors() {
        return majors;
    }
    public void displayModuleDetails(Module module) {
        System.out.println("Module Title: " + module.getModuleTitle());
        System.out.println("Major: " + module.getMajor().getMajorTitle());
        System.out.println("Teacher: " + module.getTeacher().getT_1stName() + " " +
                module.getTeacher().getT_lastName());
    }
}
