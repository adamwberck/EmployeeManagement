public class Employee {
    private String firstName;
    private String lastName;
    private Department department;

    public Employee(String firstName, String lastName, Department department) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.department = department;
    }

    @Override
    public String toString(){
        return firstName + "," + lastName + "," + department.getName() + "\n";
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public Department getDepartment() {
        return department;
    }
}
