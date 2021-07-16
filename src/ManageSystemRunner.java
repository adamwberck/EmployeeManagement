import java.io.*;

public class ManageSystemRunner {
    public static void main(String[] args){
        var departmentList = new DepartmentList();
        //initial read of txt
        readFromTxt(departmentList);
        outputToCVS(departmentList);
        departmentList.clear();
        readFromCVS(departmentList);
        System.out.println(departmentList.toString());
    }

    private static void readFromTxt(DepartmentList departmentList) {
        File employeeTxt =  new File("employees.txt");
        genericReadFrom(employeeTxt, departmentList, " ");
    }

    private static void readFromCVS(DepartmentList departmentList) {
        File employeeTxt =  new File("employees.cvs");
        genericReadFrom(employeeTxt, departmentList, ",");
    }

    private static void outputToCVS(DepartmentList departmentList) {
        try {
            var cvsWriter = new FileWriter("employees.cvs");
            for (Department department : departmentList ){
                for (Employee employee : department.getEmployeeList()){
                    cvsWriter.append(employee.toString());
                }
            }
            cvsWriter.flush();
            cvsWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void genericReadFrom(File file, DepartmentList departmentList, String separator) {
        if(file.exists()){
            try {
                var txtReader = new BufferedReader(new FileReader(file));
                String row = txtReader.readLine();
                while (row != null) {
                    String[] info = row.split(separator);
                    var department_name = info[2];
                    Department department = departmentList.getFromName(department_name);
                    if (department == null) {//create Department
                        department = new Department(department_name);
                        departmentList.add(department);
                    }
                    //add employee
                    department.getEmployeeList().add(new Employee(info[0], info[1], department));
                    row = txtReader.readLine();
                }
                txtReader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        else {
            System.out.println("No File");
            try {
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
