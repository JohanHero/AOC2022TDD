package org.aoc;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class Day4Test {

    @Test
    void checkOverlap() {
        Assertions.assertFalse(Day4.checkOverLap("2-4,6-8"));
        Assertions.assertFalse(Day4.checkOverLap("2-3,4-5"));
        Assertions.assertFalse(Day4.checkOverLap("5-7,7-9"));
        Assertions.assertTrue(Day4.checkOverLap("2-8,3-7"));
        Assertions.assertTrue(Day4.checkOverLap("6-6,4-6"));
        Assertions.assertFalse(Day4.checkOverLap("2-6,4-8"));
    }
    @Test
    void checkOverlapPart2() {
        Assertions.assertFalse(Day4.checkOverLapPart2("2-4,6-8"));
        Assertions.assertFalse(Day4.checkOverLapPart2("2-3,4-5"));
        Assertions.assertTrue(Day4.checkOverLapPart2("5-7,7-9"));
        Assertions.assertTrue(Day4.checkOverLapPart2("2-8,3-7"));
        Assertions.assertTrue(Day4.checkOverLapPart2("6-6,4-6"));
        Assertions.assertTrue(Day4.checkOverLapPart2("2-6,4-8"));
    }

    @Test
    void integrationTest() throws IOException {
        Assertions.assertEquals(2, Day4.runPart1(Util.readInputToString("src/test/resources/4_test.txt")));
        Assertions.assertEquals(4, Day4.runPart2(Util.readInputToString("src/test/resources/4_test.txt")));
    }


}
