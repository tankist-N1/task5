import java.util.HashMap;
import java.util.Map;

public class SameLetterPattern {
    public static boolean sameLetterPattern(String str1, String str2) {
        if (str1.length() != str2.length()) return false;

        return createPattern(str1).equals(createPattern(str2));
    }

    private static String createPattern(String str) {
        Map<Character, Integer> map = new HashMap<>();
        StringBuilder pattern = new StringBuilder();
        int count = 0;

        for (char c : str.toCharArray()) {
            if (!map.containsKey(c)) {
                map.put(c, count++);
            }
            pattern.append(map.get(c));
        }

        return pattern.toString();
    }

    public static void main(String[] args) {
        System.out.println(sameLetterPattern("ABAB", "CDCD")); // true
        System.out.println(sameLetterPattern("ABCBA", "BCDCB")); // true
        System.out.println(sameLetterPattern("FFGG", "CDCD")); // false
        System.out.println(sameLetterPattern("FFFF", "ABCD")); // false
    }
}