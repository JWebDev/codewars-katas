package katas.java;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;
import java.util.stream.IntStream;

/**
 * @author JDev
 * <p>
 * Kata: https://www.codewars.com/kata/56b012bbee8829c4ea00002c
 */
public class TrackingPawns {

    private static String[][] board = new String[8][8];
    private static Map<String, Integer> xAxis = Map.of("a", 0, "b", 1, "c", 2, "d", 3, "e", 4, "f", 5, "g", 6, "h", 7);
    private static String whiteP = "W", blackP = "b", dot = ".";

    public static void main(String[] args) {
        generatePawnsBoard();
//        System.out.println(Arrays.deepToString(movePawns(new String[]{"d4", "d5", "f3", "c6", "f4", "c5", "dxc5"})).replace("],", "],\n").replace("\", \"", "\",\""));
//        System.out.println(Arrays.deepToString(movePawns(new String[]{"d4", "d5", "f3", "c6", "f4"})).replace("],", "],\n").replace("\", \"", "\",\""));
//        System.out.println(Arrays.deepToString(movePawns(new String[]{"e4", "d5", "d3", "dxe4"})).replace("],", "],\n").replace("\", \"", "\",\""));
//        System.out.println(Arrays.deepToString(movePawns(new String[]{"h3", "h5", "h4", "g5", "hxg5", "h4"})).replace("],", "],\n").replace("\", \"", "\",\""));
        System.out.println(Arrays.deepToString(movePawns(new String[]{"b3", "h6", "b4", "h5", "b5", "h4", "b6", "h3", "bxc7", "hxg2"})).replace("],", "],\n").replace("\", \"", "\",\""));
//        System.out.println(Arrays.deepToString(movePawns(new String[]{"e5"})).replace("],", "],\n").replace("\", \"", "\",\""));
    }


    public static String[][] movePawns(String[] moves) {
        Pattern pattern = Pattern.compile("(\\b[a-h][1-8]\\b)|(\\b[a-h]x[a-h][1-8]\\b)");
        for (int i = 0; i < moves.length; i++) {
            List<String> m = Arrays.asList(moves[i].split(""));
            String pawn = i % 2 == 0 ? whiteP : blackP;

            if (pattern.matcher(moves[i]).find() && isMoveValid(pawn, m)) {
                movePawn(pawn, m);
                System.out.println(Arrays.deepToString(board).replace("],", "],\n").replace("\", \"", "\",\"")); //Print every Step
            } else {
                return new String[][]{new String[]{moves[i] + " is invalid"}};
            }
        }
        return board;
    }

    private static void capturePawn(String pawn, List<String> m, int d) {
        int mpX = xAxis.get(m.get(0)), cpX = xAxis.get(m.get(2)), cpY = Integer.valueOf(m.get(3))-1;
        if (pawn.equals(whiteP)) {
            board[8-cpY-1][cpX] = board[8 - cpY][mpX];
            board[8 - cpY][mpX] = dot;
        } else {
            board[8-cpY-1][cpX] = board[8-cpY-2][mpX];
            board[8-cpY-2][mpX] = dot;
        }
    }

    private static void movePawn(String pawn, List<String> m) {

        if (m.size() == 4) {
            capturePawn(pawn, m, pawn.equals(whiteP) ? 1 : -1);
            return;
        }
        int direction = pawn == whiteP ? -1 : 1;
        int pX = xAxis.get(m.get(0)), pY = Integer.valueOf(m.get(1));

        if (pawn.equals(whiteP) && board[6][pX] == whiteP && pY - 2 <= 2) {
            modify(8 - pY, 6, pX, pawn);
        } else if (pawn.equals(whiteP) && board[8 - pY - direction][pX] == whiteP) {
            modify(8 - pY, 9 - pY, pX, pawn);
        }

        if (board[1][pX] == blackP && pawn.equals(blackP) && 7 - pY <= 2) {
            modify(8 - pY, 1, pX, pawn);
        } else if (pawn.equals(blackP) && board[8 - pY - direction][pX] == blackP) {
            modify(8 - pY, 8 - pY - direction, pX, pawn);
        }

    }

    private static boolean isMoveValid(String pawn, List<String> m) {
        if (m.size() == 4) {
            int mpY = xAxis.get(m.get(0)), cpX = xAxis.get(m.get(2)), cpY = Integer.valueOf(m.get(3));
            return pawn.equals(whiteP) ? (board[8 - cpY + 1][mpY] != dot && board[8 - cpY][cpX] != dot) : (board[8-cpY-1][mpY] != dot && board[8-cpY][cpX] != dot);
        }
        int pX = xAxis.get(m.get(0)), pY = Integer.valueOf(m.get(1));
        int d = pawn == whiteP ? -1 : 1;

        if (pawn.equals(whiteP) && board[8 - pY][pX] == dot && ((board[6][pX] == whiteP && pY - 2 <= 2) || (board[8 - pY - d][pX] == whiteP)))
            return true;

        if (pawn.equals(blackP) && board[8 - pY][pX] == dot && ((board[1][pX] == blackP && 7 - pY <= 2) || (board[8 - pY - d][pX] == blackP)))
            return true;

        return false;
    }

    private static void modify(int yP, int yD, int x, String pawn) {
        board[yD][x] = dot;
        board[yP][x] = pawn;
    }

    private static void generatePawnsBoard() {
        IntStream.range(0, 8).forEach(n -> {
            Arrays.fill(board[n], (n == 1 || n == 6) ? (n == 6 ? whiteP : blackP) : dot);
        });
    }
}