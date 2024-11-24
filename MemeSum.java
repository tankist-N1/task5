public class MemeSum {
    public static int memeSum(int a, int b) {
        StringBuilder result = new StringBuilder();
        while (a > 0 || b > 0) {
            int digitA = a % 10;
            int digitB = b % 10;
            result.insert(0, digitA + digitB);
            a /= 10;
            b /= 10;
        }
        return Integer.parseInt(result.toString());
    }

    public static void main(String[] args) {
        System.out.println(memeSum(26, 39)); // 515
        System.out.println(memeSum(122, 81)); // 1103
        System.out.println(memeSum(1222, 30277)); // 31499
    }
}