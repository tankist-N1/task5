import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class TimeDifference {
    private static final Map<String, String> cityOffsets = new HashMap<>();

    static {
        cityOffsets.put("Los Angeles", "-08:00");
        cityOffsets.put("New York", "-05:00");
        cityOffsets.put("Caracas", "-04:30");
        cityOffsets.put("Buenos Aires", "-03:00");
        cityOffsets.put("London", "00:00");
        cityOffsets.put("Rome", "+01:00");
        cityOffsets.put("Moscow", "+03:00");
        cityOffsets.put("Tehran", "+03:30");
        cityOffsets.put("New Delhi", "+05:30");
        cityOffsets.put("Beijing", "+08:00");
        cityOffsets.put("Canberra", "+10:00");
    }

    public static String timeDifference(String cityA, String timestamp, String cityB) {
        SimpleDateFormat sdf = new SimpleDateFormat("MMMM d, yyyy HH:mm");
        sdf.setLenient(false);

        try {
            Date date = sdf.parse(timestamp);
            long offsetA = getOffset(cityA);
            long offsetB = getOffset(cityB);
            long diff = offsetB - offsetA;

            date.setTime(date.getTime() + diff);

            return new SimpleDateFormat("yyyy-M-d HH:mm").format(date);
        } catch (ParseException e) {
            e.printStackTrace();
            return null;
        }
    }

    private static long getOffset(String city) {
        String offsetStr = cityOffsets.get(city);
        String[] parts = offsetStr.split(":");
        int hours = Integer.parseInt(parts[0]);
        int minutes = Integer.parseInt(parts[1]);
        return (hours * 60 + minutes) * 60 * 1000;
    }

    public static void main(String[] args) {
        System.out.println(timeDifference("Los Angeles", "April 1, 2011 23:23", "Canberra")); // "2011-4-2 17:23"
        System.out.println(timeDifference("London", "July 31, 1983 23:01", "Rome")); // "1983-8-1 00:01"
        System.out.println(timeDifference("New York", "December 31, 1970 13:40", "Beijing")); // "1971-1-1 02:40"
    }
}