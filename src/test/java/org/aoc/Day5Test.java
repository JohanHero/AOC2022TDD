package org.aoc;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Day5Test {


    @Test
    void findAmountOfStacksNeeded() throws IOException {
        Assertions.assertEquals(3, Day5.findAmountOfStacksNeeded(Util.readInputToString("src/test/resources/5_test.txt")));
    }

    @Test
    void populateStacks() throws IOException {
        Util.createArrayOfStacks(Util.readInputToString("src/test/resources/5_test.txt"));
        List<Stack<String>> actuallStacks = Day5.populateStacks(Util.readInputToString("src/test/resources/5_test.txt"));

        List<Stack<String>> expectedStacks = new ArrayList<>();
        for (int i = 0; i < 4; i++)
            expectedStacks.add(new Stack<>());

        expectedStacks.get(1).push("Z");
        expectedStacks.get(1).push("N");
        expectedStacks.get(2).push("M");
        expectedStacks.get(2).push("C");
        expectedStacks.get(2).push("D");
        expectedStacks.get(3).push("P");

        Assertions.assertEquals(expectedStacks, actuallStacks);
    }

    @Test
    void getInstructions() throws IOException {
        List<String> instructions = Day5.getInstructions(Util.readInputToString("src/test/resources/5_test.txt"));
        Assertions.assertEquals(instructions.get(0), "1 from 2 to 1");
    }

    @Test
    void runInstructions() throws IOException {
        var a = Day5.populateStacks(Util.readInputToString("src/test/resources/5_test.txt"));
        List<String> instructions = Day5.getInstructions(Util.readInputToString("src/test/resources/5_test.txt"));
        List<Stack<String>> actualStack = Day5.runInstructions(a, instructions);
        Assertions.assertEquals("C", actualStack.get(1).peek());
        Assertions.assertEquals("M", actualStack.get(2).peek());
        Assertions.assertEquals("Z", actualStack.get(3).peek());
    }

    @Test
    void integrationTest() throws IOException {
        Day5.runPart1(Util.readInputToString("src/test/resources/5_test.txt"));
        Day5.runPart2(Util.readInputToString("src/test/resources/5_test.txt"));
    }

    @Test
    void runInstructionsPart2() throws IOException {
        var stacks = Day5.populateStacks(Util.readInputToString("src/test/resources/5_test.txt"));
        List<String> instructions = Day5.getInstructions(Util.readInputToString("src/test/resources/5_test.txt"));

        List<Stack<String>> actualStack = Day5.runInstructionsPart2(stacks, instructions);
        Assertions.assertEquals("M", actualStack.get(1).peek());
        Assertions.assertEquals("C", actualStack.get(2).peek());
        Assertions.assertEquals("D", actualStack.get(3).peek());

    }

}
