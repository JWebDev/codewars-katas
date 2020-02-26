package katas.java;

import java.util.Arrays;
import java.util.Map;
import java.util.regex.Pattern;
import java.util.stream.IntStream;

/**
 * @author JDev
 * <p>
 * Kata: https://www.codewars.com/kata/56b012bbee8829c4ea00002c
 */
public class TrackingPawns {

    private static String[][] board = new String[8][];
    private static Map<String, Integer> indexMap = Map.of("a", 1, "b", 2, "c", 3, "d", 4, "e", 5, "f", 6, "g", 7, "h", 8);

    public static void main(String[] args) {
        generateBoard();
        System.out.println(movePawns(new String[]{"e3", "d6", "e4", "a6"}));
    }


    public static String[][] movePawns(String[] moves) {
        Pattern pattern = Pattern.compile("\b[a-h]{1}[1-8]{1}\b");
        Arrays.stream(moves).forEach(m -> {
            boolean b = pattern.matcher(m).find();
            String[] split = m.split("");
            int[][] index = new int[][]{{indexMap.get(split[0])}, {Integer.valueOf(split[1])}};

        });
        return new String[0][0];
    }

    private static void generateBoard() {
        IntStream.iterate(8, i -> i - 1).limit(8).forEach(n -> {
            board[8 - n] = Arrays.stream("abcdefgh".split("")).map(x -> x + n).toArray(String[]::new);
        });
        System.out.println(board);
    }

}
