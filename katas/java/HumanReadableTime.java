package katas.java;

import java.time.Duration;

/**
 * @author JDev
 * <p>
 * Kata: https://www.codewars.com/kata/52685f7382004e774f0001f7
 */
public class HumanReadableTime {

    public static void main(String[] args) {
        System.out.println(makeReadable(0));  // => 00:00:00
        System.out.println(makeReadable(5));  // => 00:00:05
        System.out.println(makeReadable(60));  // => 00:01:00
        System.out.println(makeReadable(86399));  // => 23:59:59
        System.out.println(makeReadable(359999));  // => 00:00:05
    }

    public static String makeReadable(int seconds) {
        Duration dur = Duration.ofSeconds(seconds);
        return String.format("%02d:%02d:%02d", dur.toHours(), dur.toMinutesPart(), dur.toSecondsPart());
    }
}
