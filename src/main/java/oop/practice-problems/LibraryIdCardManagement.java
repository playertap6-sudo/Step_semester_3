package oop.practice_problems;

public class LibraryIdCardManagement {
    String name;
    int booksIssued;

    public LibraryIdCardManagement(String name, int booksIssued) {
        this.name = name;
        this.booksIssued = booksIssued;
    }

    public static void main(String[] args) {
        LibraryIdCardManagement ravi = new LibraryIdCardManagement("Ravi", 0);
        LibraryIdCardManagement duplicate = ravi;
        duplicate.booksIssued = 3;

        System.out.println("Ravi's booksIssued (via first variable): " + ravi.booksIssued);
        System.out.println("duplicate == ravi: " + (duplicate == ravi));

        LibraryIdCardManagement separate = new LibraryIdCardManagement("Ravi", 3);
        System.out.println("separate == ravi: " + (separate == ravi));
    }
}