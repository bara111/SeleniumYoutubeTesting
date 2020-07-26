package util;

import java.util.ArrayList;

public class Converters {
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
}
