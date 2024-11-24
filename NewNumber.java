import java.util.Arrays;

public class NewNumber {
    public static boolean isNew(int num) {
        char[] digits = String.valueOf(num).toCharArray();
        Arrays.sort(digits);
        String sortedNum = new String(digits);

        for (int i = 1; i < sortedNum.length(); i++) {
            if (sortedNum.charAt(i) == sortedNum.charAt(i - 1)) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        System.out.println(isNew(3)); // true
        System.out.println(isNew(30)); // true
        System.out.println(isNew(321)); // false
        System.out.println(isNew(123)); // true
    }
}