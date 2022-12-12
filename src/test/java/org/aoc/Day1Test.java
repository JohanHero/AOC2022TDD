package org.aoc;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Day1Test {

    @Test
    void readInputTest() throws IOException {

        String expectedString = """
                Hello
                World!""";
        Assertions.assertEquals(expectedString, Util.readInputToString("src/test/resources/input_hello.txt"));
    }

    @Test
    void getHighestConnectedNumbersTest() {

        String inputTest1 = """
                1000
                2000
                3000
                         
                4000
                         
                5000
                6000
                         
                7000
                8000
                9000
                         
                10000
                """;
        Assertions.assertEquals(24000,Day1.getMaxNumber(Day1.getSumsOfConnectedNumbers(inputTest1)));
    }

    @Test
    void getSumOfTopThreeConnectedNumbersTest() {

        List<Integer> topThree = new ArrayList<>();
        topThree.add(6000);
        topThree.add(4000);
        topThree.add(11000);
        topThree.add(24000);
        topThree.add(10000);
        Assertions.assertEquals(45000,Day1.getSumOfTopThree(topThree));
    }
}
