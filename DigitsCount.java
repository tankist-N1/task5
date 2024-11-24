public class DigitsCount {
    public static int digitsCount(long number) {
        if (number == 0) return 1;
        return countDigits(number);
    }

    private static int countDigits(long number) {
        if (number == 0) return 0;
        return 1 + countDigits(number / 10);
    }

    public static void main(String[] args) {
        System.out.println(digitsCount(4666)); // 4
        System.out.println(digitsCount(544)); // 3
        System.out.println(digitsCount(121317)); // 6
        System.out.println(digitsCount(0)); // 1
        System.out.println(digitsCount(12345)); // 5
        System.out.println(digitsCount(1289396387328L)); // 13
    }
}