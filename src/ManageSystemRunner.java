import java.io.*;

public class ManageSystemRunner {
    public static void main(String[] args){
        var departmentList = new DepartmentList();
        //initial read of txt
        readFromTxt(departmentList);
        //output to CVS
        outputToCVS(departmentList);
        //clear from memory
        departmentList.clear();
        //read again
        readFromCVS(departmentList);

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
    private static void readFromCVS(DepartmentList departmentList) {
        File employeeTxt =  new File("employees.cvs");
        genericReadFrom(employeeTxt, departmentList, ",");
    }

    //write to cvs using toString and FileWriter
    private static void outputToCVS(DepartmentList departmentList) {
        try {
            var cvsWriter = new FileWriter("employees.cvs");
            cvsWriter.append(Employee.outMemberVars());//write the vars
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
