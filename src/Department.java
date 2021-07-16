import java.util.ArrayList;
import java.util.List;

public class Department {
    private String name;
    private String description;
    private List<Employee> employeeList = new ArrayList<>();

    public Department(String name) {
        this.name = name;
    }

    public Department(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString(){
        return name;
    }

    public List<Employee> getEmployeeList() {
        return employeeList;
    }
}
