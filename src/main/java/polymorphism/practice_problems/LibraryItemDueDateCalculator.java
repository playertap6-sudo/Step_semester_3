import java.time.LocalDate;
import java.util.*;

abstract class LibraryItem {
    protected String title;
    protected LocalDate currentDate;

    LibraryItem(String title, LocalDate currentDate) {
        this.title = title;
        this.currentDate = currentDate;
    }

    abstract LocalDate getDueDate();

    String getTitle() {
        return title;
    }
}

class BookItem extends LibraryItem {

    BookItem(String title, LocalDate date) {
        super(title, date);
    }

    @Override
    LocalDate getDueDate() {
        return currentDate.plusDays(14);
    }
}

class DVDItem extends LibraryItem {

    DVDItem(String title, LocalDate date) {
        super(title, date);
    }

    @Override
    LocalDate getDueDate() {
        return currentDate.plusDays(7);
    }
}

class MagazineItem extends LibraryItem {

    MagazineItem(String title, LocalDate date) {
        super(title, date);
    }

    @Override
    LocalDate getDueDate() {
        return currentDate.plusDays(3);
    }
}

public class LibraryItemDueDateCalculator {

    static LibraryItem createItem(
            String type,
            String title,
            LocalDate date) {

        switch (type) {
            case "BOOK":
                return new BookItem(title, date);

            case "DVD":
                return new DVDItem(title, date);

            case "MAGAZINE":
                return new MagazineItem(title, date);

            default:
                throw new IllegalArgumentException(
                        "Invalid item type"
                );
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        sc.nextLine();

        LocalDate currentDate =
                LocalDate.of(2023, 10, 26);

        for (int i = 0; i < n; i++) {

            String line = sc.nextLine().trim();

            String type;
            String title;

            if (line.contains("\"")) {
                int firstQuote = line.indexOf('"');
                int lastQuote = line.lastIndexOf('"');

                type = line.substring(0, firstQuote).trim();
                title = line.substring(
                        firstQuote + 1,
                        lastQuote
                );
            } else {
                String[] parts = line.split(" ", 2);
                type = parts[0];
                title = parts[1];
            }

            LibraryItem item =
                    createItem(type, title, currentDate);

            System.out.println(
                    item.getTitle() + ": "
                    + item.getDueDate()
            );
        }

        sc.close();
    }
}