package strings.assigment_problems;

public class LibraryIsbnNormalizer {

    static String normalizeCode(String raw) {
        String trimmed = raw.trim();
        if (trimmed.length() < 3) return trimmed;
        String publisher = trimmed.substring(0, 3).toUpperCase();
        String rest = trimmed.substring(3);
        return publisher + rest;
    }

    static String validateAndFormat(String code) {
        if (code.length() != 13) {
            return "Invalid: code must be exactly 13 characters";
        }

        String publisher = code.substring(0, 3);
        String yearPart = code.substring(3, 7);
        String catalogPart = code.substring(7, 13);

        for (int i = 0; i < publisher.length(); i++) {
            if (!Character.isLetter(publisher.charAt(i))) {
                return "Invalid: publisher code must be 3 letters";
            }
        }

        String body = yearPart + catalogPart;
        for (int i = 0; i < body.length(); i++) {
            if (!Character.isDigit(body.charAt(i))) {
                return "Invalid: remaining characters must be digits";
            }
        }

        return "[" + publisher + "] YEAR: " + yearPart + " | CATALOG: " + catalogPart;
    }

    public static void main(String[] args) {
        String normalized = normalizeCode(" pen2026004251 ");
        System.out.println(validateAndFormat(normalized));

        String normalized2 = normalizeCode("12N2026004251");
        System.out.println(validateAndFormat(normalized2));
    }
}