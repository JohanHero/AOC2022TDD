package org.aoc;


import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Day8 {


    public static void main(String[] args) throws IOException {
        System.out.println(calculateResult(Util.create2DGrid(Util.readInputToString("src/main/resources/8.txt"))));
        System.out.println(calculateVisibleTrees(Util.create2DGrid(Util.readInputToString("src/main/resources/8.txt"))));

    }

    public static boolean visibleFromLeft(int[][] grid, int valueToCheck, int row, int col) {
        int i = 0;
        while (col - i > 0) {
            i++;
            if (grid[row][col - i] >= valueToCheck)
                return false;
        }
        return true;
    }

    public static boolean visibleFromRight(int[][] grid, int valueToCheck, int row, int col) {
        //kolla höger
        int i = 0;
        while (col + i < grid.length - 1) {
            i++;
            if (grid[row][col + i] >= valueToCheck)
                return false;
        }
        return true;
    }

    public static boolean visibleFromAbove(int[][] grid, int valueToCheck, int row, int col) {
        int i = 0;
        while (row - i > 0) {
            i++;
            if (grid[row - i][col] >= valueToCheck)
                return false;
        }
        return true;
    }

    public static boolean visibleFromBelow(int[][] grid, int valueToCheck, int row, int col) {
        int i = 0;
        while (row + i < grid.length - 1) {
            i++;
            if (grid[row + i][col] >= valueToCheck)
                return false;
        }
        return true;
    }


    public static int calculateResult(int[][] grid) {

        int sum = 0;
        for (int row = 0; row < grid.length; row++) {
            for (int col = 0; col < grid.length; col++) {
                if (visibleFromLeft(grid, grid[row][col], row, col) || visibleFromRight(grid, grid[row][col], row, col) || visibleFromBelow(grid, grid[row][col], row, col) || visibleFromAbove(grid, grid[row][col], row, col))
                    sum++;
            }
        }
        return sum;
    }

    public static Integer calculateVisibleTrees(int[][] grid) {
        List<Integer> values = new ArrayList<>();
        for (int row = 0; row < grid.length; row++) {
            for (int col = 0; col < grid.length; col++) {

                int pointValue = visibleTreesFromLeft(grid, grid[row][col], row, col) * visibleTressFromRight(grid, grid[row][col], row, col) * visibleTreesFromBelow(grid, grid[row][col], row, col) * visibleTreesFromAbove(grid, grid[row][col], row, col);
                values.add(pointValue);
            }
        }
        return Collections.max(values);
    }


    public static int visibleTreesFromLeft(int[][] grid, int valueToCheck, int row, int col) {
        int i = 0;
        while (col - i > 0) {
            i++;
            if (grid[row][col - i] >= valueToCheck)
                return i;
        }
        return i;
    }

    public static int visibleTressFromRight(int[][] grid, int valueToCheck, int row, int col) {
        int i = 0;
        while (col + i < grid.length - 1) {
            i++;
            if (grid[row][col + i] >= valueToCheck)
                return i;
        }
        return i;
    }

    public static int visibleTreesFromAbove(int[][] grid, int valueToCheck, int row, int col) {
        int i = 0;
        while (row - i > 0) {
            i++;
            if (grid[row - i][col] >= valueToCheck)
                return i;
        }
        return i;
    }

    public static int visibleTreesFromBelow(int[][] grid, int valueToCheck, int row, int col) {
        int i = 0;
        while (row + i < grid.length - 1) {
            i++;
            if (grid[row + i][col] >= valueToCheck)
                return i;
        }
        return i;
    }


}
