package katas.java;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author JDev
 * <p>
 * Kata: https://www.codewars.com/kata/52742f58faf5485cae000b9a
 */
public class HumanReadableDurationFormat {

    public static void main(String[] args) {
        System.out.println(formatDuration(1)); //1 second
        System.out.println(formatDuration(62)); //1 minute and 2 seconds
        System.out.println(formatDuration(120)); //2 minutes
        System.out.println(formatDuration(3600)); //1 hour
        System.out.println(formatDuration(3662)); //1 hour, 1 minute and 2 seconds
        System.out.println(formatDuration(15731080)); //182 days, 1 hour, 44 minutes and 40 seconds
        System.out.println(formatDuration(132030240)); //4 years, 68 days, 3 hours and 4 minutes
    }

    public static String formatDuration(int seconds) {
        List<String> ds = new ArrayList<>();

        ds.add(formatUnit(seconds / 86400 / 365, "year"));
        ds.add(formatUnit(seconds / 86400 > 365 ? seconds / 86400 - (365 * (seconds / 86400 / 365)) : seconds / 86400, "day"));
        ds.add(formatUnit(seconds / 60 / 60 % 24, "hour"));
        ds.add(formatUnit(seconds / 60 % 60, "minute"));
        ds.add(formatUnit(seconds % 60, "second"));
        ds = ds.stream().filter(s -> !s.startsWith("0 ")).collect(Collectors.toList());
        return seconds == 0 ? "now" : ds.size() == 1 ? ds.get(0) : String.join(", ", ds.subList(0, ds.size() - 1)) + " and " + ds.get(ds.size() - 1);
    }

    private static String formatUnit(long unit, String suffix) {
        return unit <= 1 ? unit + " " + suffix : unit + " " + suffix + "s";
    }
}
