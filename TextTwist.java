import java.util.HashMap;
import java.util.Map;

public class TextTwist {
    public static int totalPoints(String[] guessedWords, String baseWord) {
        int totalPoints = 0;
        Map<Character, Integer> baseWordMap = new HashMap<>();
        for (char c : baseWord.toCharArray()) {
            baseWordMap.put(c, baseWordMap.getOrDefault(c, 0) + 1);
        }

        for (String word : guessedWords) {
            if (isValidWord(word, baseWordMap)) {
                totalPoints += getPoints(word);
                if (word.length() == 6) {
                    totalPoints += 50;
                }
            }
        }

        return totalPoints;
    }

    private static boolean isValidWord(String word, Map<Character, Integer> baseWordMap) {
        Map<Character, Integer> wordMap = new HashMap<>();
        for (char c : word.toCharArray()) {
            wordMap.put(c, wordMap.getOrDefault(c, 0) + 1);
        }

        for (Map.Entry<Character, Integer> entry : wordMap.entrySet()) {
            if (entry.getValue() > baseWordMap.getOrDefault(entry.getKey(), 0)) {
                return false;
            }
        }

        return true;
    }

    private static int getPoints(String word) {
        switch (word.length()) {
            case 3: return 1;
            case 4: return 2;
            case 5: return 3;
            case 6: return 4;
            default: return 0;
        }
    }

    public static void main(String[] args) {
        System.out.println(totalPoints(new String[]{"cat", "create", "sat"}, "caster")); // 2
        System.out.println(totalPoints(new String[]{"trance", "recant"}, "recant")); // 108
        System.out.println(totalPoints(new String[]{"dote", "dotes", "toes", "set", "dot", "dots", "sted"}, "tossed")); // 13
    }
}