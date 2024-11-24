import java.util.Arrays;

public class MaxPossible {
    public static int maxPossible(int num1, int num2) {
        char[] num1Arr = String.valueOf(num1).toCharArray();
        char[] num2Arr = String.valueOf(num2).toCharArray();
        Arrays.sort(num2Arr);

        for (int i = 0; i < num1Arr.length; i++) {
            if (num2Arr.length > 0 && num1Arr[i] < num2Arr[num2Arr.length - 1]) {
                num1Arr[i] = num2Arr[num2Arr.length - 1];
                num2Arr = Arrays.copyOfRange(num2Arr, 0, num2Arr.length - 1);
            }
        }

        return Integer.parseInt(new String(num1Arr));
    }

    public static void main(String[] args) {
        System.out.println(maxPossible(9328, 456)); // 9658
        System.out.println(maxPossible(523, 76)); // 763
        System.out.println(maxPossible(9132, 5564)); // 9655
        System.out.println(maxPossible(8732, 91255)); // 9755
    }
}