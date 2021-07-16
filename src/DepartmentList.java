import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class DepartmentList extends ArrayList<Department> {
    @Override
    public String toString(){
        StringBuilder out = new StringBuilder();
        for (Department department : this) {
            out.append(department.toString()).append("\n\t");
            for (Employee employee : department.getEmployeeList()) {
                out.append(employee.toString());
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

}
