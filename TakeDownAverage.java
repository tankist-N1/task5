public class TakeDownAverage {
    public static String takeDownAverage(String[] scores) {
        int total = 0;
        for (String score : scores) {
            total += Integer.parseInt(score.replace("%", ""));
        }

        int n = scores.length;
        int currentAverage = total / n;
        int newAverage = currentAverage - 5;
        int newTotal = newAverage * (n + 1);
        int myScore = newTotal - total;

        return myScore + "%";
    }

    public static void main(String[] args) {
        System.out.println(takeDownAverage(new String[]{"95%", "83%", "90%", "87%", "88%", "93%"})); // "54%"
        System.out.println(takeDownAverage(new String[]{"10%"})); // "0%"
        System.out.println(takeDownAverage(new String[]{"53%", "79%"})); // "51%"
    }
}