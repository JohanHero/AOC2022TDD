package org.aoc;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Day3Test {

    @Test
    void findDuplicate() {
        String line = "vJrwpWtwJgWrhcsFMMfFFhFp";
        Assertions.assertEquals("p", Day3.findDuplicateChar(line));
    }

    @Test
    void createMapValue() {
        Map<String, Integer> valueMap = Util.createValueMap();
        Assertions.assertEquals(52, valueMap.get("Z"));
        Assertions.assertEquals(1, valueMap.get("a"));
        Assertions.assertEquals(2, valueMap.get("b"));
    }

    @Test
    void calculateSumFromMapValue() {
        Map<String, Integer> valueMap = Util.createValueMap();
        System.out.println(valueMap);
        Day3 d1 = new Day3();
        d1.addToSum("a");
        d1.addToSum("a");
        d1.addToSum("a");
        Assertions.assertEquals(3, d1.getSum());
    }

    @Test
    void integrationTestDay3() throws IOException {
        Day3 d1 = new Day3();
        d1.run("src/test/resources/3_test.txt");
        Assertions.assertEquals(157, d1.getSum());
    }

    @Test
    void integrationTestDay3Part2() throws IOException {
        Day3 d1 = new Day3();
        d1.runPart2("src/test/resources/3_test.txt");
        Assertions.assertEquals(70, d1.getSum());
    }

    @Test
    void findDuplicateFromThreeLines() throws IOException {

        List<String> threeLines = new ArrayList<>();
        threeLines.add("vJrwpWtwJgWrhcsFMMfFFhFp");
        threeLines.add("jqHRNqRjqzjGDLGLrsFMfFZSrLrFZsSL");
        threeLines.add("PmmdzqPrVvPwwTWBwg");
        Assertions.assertEquals("r", Day3.findDuplicateFromThreeLines(threeLines));
    }

}
