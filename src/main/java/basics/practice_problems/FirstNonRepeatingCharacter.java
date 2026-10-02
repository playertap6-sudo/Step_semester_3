package basics.practice_problems;

import java.util.HashMap;
import java.util.Map;

public class FirstNonRepeatingCharacter {

    static Character findFirstNonRepeatingChar(String text) {
        Map<Character, Integer> freq = new HashMap<>();

        for (char c : text.toCharArray()) {
            freq.put(c, freq.getOrDefault(c, 0) + 1);
        }

        for (char c : text.toCharArray()) {
            if (freq.get(c) == 1) return c;
        }

        return null;
    }

    public static void main(String[] args) {
        check("swiss");
        check("aabbcc");
    }

    static void check(String text) {
        Character result = findFirstNonRepeatingChar(text);
        if (result == null) {
            System.out.println("No Non-Repeating Character Found");
        } else {
            System.out.println("First Non-Repeating Character: '" + result + "'");
        }
    }
}