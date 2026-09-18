package oop.assigment_problems;

public class EmployeeCompanyInfo {
    String empName;
    double salary;
    static String companyName = "Bright Horizon Technologies";
    static int employeeCount = 0;

    public EmployeeCompanyInfo(String empName, double salary) {
        this.empName = empName;
        this.salary = salary;
        employeeCount++;
    }

    static void printCompanyInfo() {
        System.out.println(companyName);
        System.out.println("Employees on record: " + employeeCount);
    }

    public static void main(String[] args) {
        new EmployeeCompanyInfo("A", 40000);
        new EmployeeCompanyInfo("B", 45000);
        new EmployeeCompanyInfo("C", 50000);

        EmployeeCompanyInfo.printCompanyInfo();
    }
}