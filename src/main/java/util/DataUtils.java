package util;

import java.util.ArrayList;

public class DataUtils {
    public static String convertQueryToString(String[] url) {
        String newQuery = url[1].replaceAll("\\+", " ");
        return newQuery.replaceAll("%2B", "+");
    }

    public static ArrayList<Double> convertListOfStringToDoubleTimeUnit(ArrayList<String> list) {

        ArrayList<Double> timeInDays = new ArrayList<>();
        for (String s : list) {
            if (s.contains("hour")) {
                String[] comment = s.split(" ");
                timeInDays.add(Double.parseDouble(comment[0]) / 24.0);
            }
            if (s.contains("day")) {
                String[] comment = s.split(" ");
                timeInDays.add(Double.parseDouble(comment[0]));
            }
            if (s.contains("week")) {
                String[] comment = s.split(" ");
                timeInDays.add(Double.parseDouble(comment[0]) * 7);
            }
            if (s.contains("month")) {
                String[] comment = s.split(" ");
                timeInDays.add(Double.parseDouble(comment[0]) * 30);
            }
            if (s.contains("year")) {
                String[] comment = s.split(" ");
                timeInDays.add(Double.parseDouble(comment[0]) * 365);
            }
        }
        return timeInDays;
    }

   public static boolean isSorted(ArrayList<Double> list) {
        boolean isSorted = false;
        for (int i = 0; i < list.size() - 1; i++) {
            if (list.get(i) < list.get(i + 1)) {
                isSorted = true;
            } else {
                isSorted = false;
                break;
            }
        }
        return isSorted;
    }
}
