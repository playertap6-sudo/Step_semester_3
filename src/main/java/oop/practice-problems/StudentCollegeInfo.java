package oop.practice_problems;

public class StudentCollegeInfo {
    String name;
    int attendance;
    static String collegeName = "SRM Institute of Science and Technology";
    static int studentCount = 0;

    public StudentCollegeInfo(String name, int attendance) {
        this.name = name;
        this.attendance = attendance;
        studentCount++;
    }

    static void printCollegeInfo() {
        System.out.println(collegeName);
        System.out.println("Students created: " + studentCount);
    }

    public static void main(String[] args) {
        new StudentCollegeInfo("Ravi", 90);
        new StudentCollegeInfo("Anitha", 85);

        StudentCollegeInfo.printCollegeInfo();
    }
}