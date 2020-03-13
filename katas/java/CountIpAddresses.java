package katas.java;

/**
 * @author JDev
 * <p>
 * Kata: https://www.codewars.com/kata/526989a41034285187000de4
 */
public class CountIpAddresses {

    public static void main(String[] args) {
        System.out.println(ipsBetween("10.0.0.0", "10.0.0.50")); //50
        System.out.println(ipsBetween("20.0.0.10", "20.0.1.0")); //246
        System.out.println(ipsBetween("170.0.0.0", "170.1.0.0")); //65536
        System.out.println(ipsBetween("10.11.12.13", "10.11.13.0")); //243
        System.out.println(ipsBetween("160.0.0.0", "160.0.1.0")); //256
        System.out.println(ipsBetween("50.0.0.0", "50.1.1.1")); //65793
        System.out.println(ipsBetween("1.2.3.4", "5.6.7.8")); //67372036
    }

    public static long ipsBetween(String start, String end) {
        String[] sp = start.split("\\."), ep = end.split("\\.");
        return getIps(sp[0], ep[0], 3) + getIps(sp[1], ep[1], 2) + getIps(sp[2], ep[2], 1) + Integer.valueOf(ep[3]) - Integer.valueOf(sp[3]);
    }

    private static int getIps(String start, String end, int pow) {
        int diff = Integer.valueOf(end) - Integer.valueOf(start);
        return diff == 0 ? 0 : (int) Math.pow(256, pow) * diff;
    }
}
