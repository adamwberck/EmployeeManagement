import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class DepartmentList extends ArrayList<Department> {
    @Override
    public String toString(){
        StringBuilder out = new StringBuilder();
        for (Department department : this) {
            out.append(department.toString()).append("\n");
            for (Employee employee : department.getEmployeeList()) {
                out.append("\t").append(employee.toString());
            }
        }
        return out.toString();
    }

    public Department getFromName(String department_name) {
        for(Department department : this){
            if(department.getName().equals(department_name)){
                return department;
            }
        }
        return null;
    }

    public void addEmployee(Employee employee) {
        employee.getDepartment().getEmployeeList().add(employee);
    }

    public void addEmployee(String[] info) {
        addEmployee(info[0], info[1], info[2]);
    }

    public void addEmployee(String firstName, String lastname, String departmentName) {
        Department department = getFromName(departmentName);
        if(department == null){
            department = new Department(departmentName);
            add(department);
        }
        department.getEmployeeList().add(new Employee(firstName, lastname, department));
    }

    public void removeEmployee(Employee employee) {
        for(Department department: this){
            if(department.equals(employee.getDepartment())){
                department.getEmployeeList().remove(employee);
            }
        }
    }
}
