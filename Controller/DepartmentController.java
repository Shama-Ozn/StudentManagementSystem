package Controller;

import Model.Department;
import Model.Teacher;
import Model.Major;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;

import DB.DatabaseConnection;

public class DepartmentController {
    private ArrayList<Department> departments;

    public DepartmentController() {
        departments = new ArrayList<>();
    }

//______________________________ADD A DEPARTMENT A NAS_______________________________________
    public void addDepartment(int dept_id, String title, Teacher dpt_Head) {
        Department newDepartment = new Department(dept_id, title, dpt_Head);
        departments.add(newDepartment);
    }
//__________________________ASSIGN MAJOR TO DAK DEPARTMENT_____________________________________
    public void assignMajorToDepartment(Department department, Major major) {
        department.getMajor().add(major);
    }
//_________________________DELETE DAK DEP_________________________________________
    public void deleteDepartment(int dept_id) {
        Iterator<Department> iterator = departments.iterator();
        while (iterator.hasNext()) {
            Department department = iterator.next();
            if (department.getDpt_id() == dept_id) {
                iterator.remove();
                System.out.println("Department deleted successfully!");
                return;
            }
        }
        System.out.println("Department not found. Deletion failed.");
    }
//_________________________MODIFY DEP ______________________________
    public void modifyDepartment(int dept_id, String newTitle, Teacher newDpt_Head) {
        for (Department department : departments) {
            if (department.getDpt_id() == dept_id) {
                department.setTitle(newTitle);
                department.setDpt_Head(newDpt_Head);
                System.out.println("Department modified successfully!");
                return;
            }
        }
        System.out.println("Department not found. Modification failed.");
    }
//______________get departments_________________________
    public ArrayList<Department> getDepartments() {
        return departments;
    }

//___________________FIND DEP BY ID______________________________________

    public Department findDepartmentById(int deptId) {
        for (Department department : departments) {
            if (department.getDpt_id() == deptId) {
                return department;
            }
        }
        return null; // Department not found
    }
//___________________________DISPLAY DEP DETAILS___________________________
public void displayDepartmentDetails(Department department) {
    if (department != null) {
        System.out.println("\nDepartment Details:");
        System.out.println("Department ID: " + department.getDpt_id());
        System.out.println("Title: " + department.getTitle());
        
        Teacher departmentHead = department.getDpt_Head();
        System.out.println("Department Head: " + departmentHead.getT_1stName() + " " + departmentHead.getT_lastName());
        
        ArrayList<Major> majors = department.getMajor();
        System.out.println("Majors:");
        for (Major major : majors) {
            System.out.println("- " + major.getMajorTitle());
        }
    } else {
        System.out.println("Department not found.");
    }
}
//_________________________connect to db________________________________________
public void loadDepartmentsFromDatabase() {
        departments.clear();
        try (Connection connection = DatabaseConnection.getConnection()) {
            String sql = "SELECT * FROM departments";
            try (PreparedStatement statement = connection.prepareStatement(sql)) {
                try (ResultSet resultSet = statement.executeQuery()) {
                    while (resultSet.next()) {
                        int dept_id = resultSet.getInt("dept_id");
                        String title = resultSet.getString("title");
                        
                        Teacher dpt_Head = new Teacher(); 
                        Department department = new Department(dept_id, title, dpt_Head);
                        departments.add(department);
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
