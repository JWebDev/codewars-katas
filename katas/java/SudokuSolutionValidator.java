package katas.java;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.stream.IntStream;

/**
 * @author JDev
 * <p>
 * Kata: https://www.codewars.com/kata/529bf0e9bdf7657179000008
 */
public class SudokuSolutionValidator {

    private static int[][] validSudoku = {
            {5, 3, 4, 6, 7, 8, 9, 1, 2},
            {6, 7, 2, 1, 9, 5, 3, 4, 8},
            {1, 9, 8, 3, 4, 2, 5, 6, 7},
            {8, 5, 9, 7, 6, 1, 4, 2, 3},
            {4, 2, 6, 8, 5, 3, 7, 9, 1},
            {7, 1, 3, 9, 2, 4, 8, 5, 6},
            {9, 6, 1, 5, 3, 7, 2, 8, 4},
            {2, 8, 7, 4, 1, 9, 6, 3, 5},
            {3, 4, 5, 2, 8, 6, 1, 7, 9}
    };

    private static int[][] invalidSudoku = {
            {5, 3, 8, 6, 7, 8, 9, 1, 2},
            {6, 7, 2, 1, 9, 5, 3, 4, 8},
            {1, 9, 8, 3, 4, 2, 5, 6, 7},
            {8, 5, 1, 7, 6, 1, 4, 2, 3},
            {4, 2, 6, 8, 5, 3, 7, 9, 1},
            {7, 1, 3, 9, 2, 4, 8, 5, 6},
            {9, 6, 1, 5, 3, 7, 2, 8, 4},
            {2, 8, 7, 4, 1, 9, 6, 3, 5},
            {3, 4, 5, 2, 8, 6, 1, 7, 9}
    };

    private static int[][] quadrantsIndexes = {{0, 0}, {0, 3}, {0, 6}, {3, 0}, {3, 3}, {3, 6}, {6, 0}, {6, 3}, {6, 6}};

    public static void main(String[] args) {
        System.out.println(check(validSudoku));
        System.out.println(check(invalidSudoku));
    }


    public static boolean check(int[][] sudoku) {
        boolean isValid = true;
        try {
            for (int i = 0; i < quadrantsIndexes.length; i++) {
                isRoWColumnQuadrantValid(sudoku, 3, 3, quadrantsIndexes[i][0], quadrantsIndexes[i][1]);
                isRoWColumnQuadrantValid(sudoku, 9, 1, 0, i);
                isRoWColumnQuadrantValid(sudoku, 1, 9, i, 0);
            }
        } catch (Exception e) {
            isValid = false;
        }
        return isValid;
    }

    public static void isRoWColumnQuadrantValid(int[][] sudoku, int fromX, int toY, int xOff, int yOff) throws Exception {
        List<Integer> arr = new ArrayList<>();
        IntStream.range(0, fromX).forEach(i -> {
            IntStream.range(0, toY).forEach(j -> {
                arr.add(sudoku[i + xOff][j + yOff]);
            });
        });
        if (new HashSet<>(arr).size() != 9 || arr.contains(0)) {
            throw new Exception();
        }
    }
}
