package oop.practice_problems;

public class StudentPlacementRecordManagement {
    String studentName;
    String company;
    double packageLpa;

    public StudentPlacementRecordManagement(String studentName, String company, double packageLpa) {
        this.studentName = studentName;
        this.company = company;
        this.packageLpa = packageLpa;
    }

    void printRecord() {
        System.out.println(studentName + " -> " + company + " @ " + packageLpa + " LPA");
    }

    public static void main(String[] args) {
        StudentPlacementRecordManagement[] records = new StudentPlacementRecordManagement[3];
        records[0] = new StudentPlacementRecordManagement("Ravi", "TCS", 4.5);
        records[1] = new StudentPlacementRecordManagement("Anitha", "Zoho", 6.2);
        records[2] = new StudentPlacementRecordManagement("Karthik", "Infosys", 4.0);

        for (StudentPlacementRecordManagement record : records) {
            record.printRecord();
        }
    }
}