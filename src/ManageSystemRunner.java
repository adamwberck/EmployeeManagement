import java.io.*;

public class ManageSystemRunner {
    public static void main(String[] args){
        var departmentList = new DepartmentList();
        //initial read of txt
        readFromTxt(departmentList);
        //output to csv
        outputToCSV(departmentList);
        //clear from memory
        departmentList.clear();
        //read again
        readFromCSV(departmentList);

        //add employee
        departmentList.addEmployee("John", "Smith", "Tech");
        departmentList.addEmployee(new Employee("Jane", "Smith", departmentList.get(0)));
        departmentList.removeEmployee(departmentList.get(0).getEmployeeList().get(0));
        //check memory
        System.out.println(departmentList.toString());
    }


    //use generic read but space separator
    private static void readFromTxt(DepartmentList departmentList) {
        File employeeTxt =  new File("employees.txt");
        genericReadFrom(employeeTxt, departmentList, " ");
    }

    //use generic read but comma separator
    private static void readFromCSV(DepartmentList departmentList) {
        File employeeTxt =  new File("employees.csv");
        genericReadFrom(employeeTxt, departmentList, ",");
    }

    //write to csv using toString and FileWriter
    private static void outputToCSV(DepartmentList departmentList) {
        try {
            var csvWriter = new FileWriter("employees.csv");
           csvWriter.append(Employee.outMemberVars());//write the vars
            for (Department department : departmentList ){
                for (Employee employee : department.getEmployeeList()){
                   csvWriter.append(employee.toString());
                }
            }
           csvWriter.flush();
           csvWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void genericReadFrom(File file, DepartmentList departmentList, String separator) {
        if(file.exists()){
            try {
                var txtReader = new BufferedReader(new FileReader(file));
                String row = txtReader.readLine();
                if(separator.equals(",")){//cvs first line lists the variables
                    row = txtReader.readLine();//skip
                }
                while (row != null) {
                    departmentList.addEmployee(row.split(separator));
                    row = txtReader.readLine();//get the next
                }
                txtReader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        else {
            System.out.println("No File");
        }
    }
}
