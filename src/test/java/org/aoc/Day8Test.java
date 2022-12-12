package org.aoc;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.Collections;
import java.util.List;

public class Day8Test {

    @Test
    void test() throws IOException {

        int[][] grid = Util.create2DGrid(Util.readInputToString("src/test/resources/8_test.txt"));

        int[][] expectedGrid = {
                {3, 0, 3, 7, 3},
                {2, 5, 5, 1, 2},
                {6, 5, 3, 3, 2},
                {3, 3, 5, 4, 9},
                {3, 5, 3, 9, 0}
        };

        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++)
                Assertions.assertEquals(expectedGrid[j][i], grid[j][i]);
        }
    }

    @Test
    void checkNeighbor() throws IOException {
        int[][] grid = Util.create2DGrid(Util.readInputToString("src/test/resources/8_test.txt"));

        int valueToCheck = grid[3][2];
        boolean isNeighborHigherLeft = Day8.visibleFromLeft(grid, valueToCheck, 3, 2);
        Assertions.assertTrue(isNeighborHigherLeft);

        valueToCheck = grid[0][1];
        isNeighborHigherLeft = Day8.visibleFromLeft(grid, valueToCheck, 0, 1);
        Assertions.assertFalse(isNeighborHigherLeft);

        valueToCheck = grid[4][3];
        isNeighborHigherLeft = Day8.visibleFromLeft(grid, valueToCheck, 4, 3);
        Assertions.assertTrue(isNeighborHigherLeft);

        valueToCheck = grid[1][1];
        boolean isNeighborHigherRight = Day8.visibleFromRight(grid, valueToCheck, 1, 1);
        Assertions.assertFalse(isNeighborHigherRight);

        valueToCheck = grid[2][2];
         isNeighborHigherRight = Day8.visibleFromRight(grid, valueToCheck, 2, 2);
        Assertions.assertFalse(isNeighborHigherRight);

        valueToCheck = grid[1][1];
        boolean isLowerNeighborHigher = Day8.visibleFromBelow(grid, valueToCheck, 1, 1);
        Assertions.assertFalse(isLowerNeighborHigher);

        valueToCheck = grid[2][2];
        isLowerNeighborHigher = Day8.visibleFromBelow(grid, valueToCheck, 2, 2);
        Assertions.assertFalse(isLowerNeighborHigher);
    }

    @Test
    void calculateValidPoints() throws IOException {

        int[][] grid = Util.create2DGrid(Util.readInputToString("src/test/resources/8_test.txt"));

        int sum = Day8.calculateResult(grid);

        Assertions.assertEquals(21,sum);

    }

    @Test
    void countVisibleTree() throws IOException {

        int[][] grid = Util.create2DGrid(Util.readInputToString("src/test/resources/8_test.txt"));

        int visibleTreesFromLeft = Day8.visibleTreesFromLeft(grid, 5,3,2);
        int visibleTreesFromRight = Day8.visibleTressFromRight(grid, 5,3,2);
        int visibleTreesFromAbove = Day8.visibleTreesFromAbove(grid, 5,3,2);
        int visibleTreesFromBelow = Day8.visibleTreesFromBelow(grid, 5,3,2);

        Assertions.assertEquals(2, visibleTreesFromLeft);
        Assertions.assertEquals(2, visibleTreesFromRight);
        Assertions.assertEquals(2, visibleTreesFromAbove);
        Assertions.assertEquals(1, visibleTreesFromBelow);

    }

    @Test
    void countVisibleTrees() throws IOException {

        int[][] grid = Util.create2DGrid(Util.readInputToString("src/test/resources/8_test.txt"));

        int calculateVisibleTrees = Day8.calculateVisibleTrees(grid);

        Assertions.assertEquals(8, calculateVisibleTrees);


    }
}
