package oop.practice_problems;

public class CourseCreditManagement {
    String code;
    String title;
    int credits;
    int labCredits;

    public CourseCreditManagement(String code, String title, int credits, int labCredits) {
        this.code = code;
        this.title = title;
        this.credits = credits;
        this.labCredits = labCredits;
    }

    public CourseCreditManagement(String code, String title, int credits) {
        this(code, title, credits, 0);
    }

    int totalCredits() {
        return credits + labCredits;
    }

    public static void main(String[] args) {
        CourseCreditManagement theoryOnly = new CourseCreditManagement("21CSC201J", "Data Structures", 4);
        CourseCreditManagement withLab = new CourseCreditManagement("21CSC205L", "DSA Lab", 3, 1);

        System.out.println(theoryOnly.code + " total credits: " + theoryOnly.totalCredits());
        System.out.println(withLab.code + " total credits: " + withLab.totalCredits());
    }
}