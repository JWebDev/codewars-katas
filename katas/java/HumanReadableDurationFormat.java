package katas.java;

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
    }

    public static String formatDuration(int seconds) {
        return "";
    }
}
