package org.aoc;

import java.io.IOException;
import java.util.*;

public class Day5 {

    public static void main(String[] args) throws IOException {
        runPart1(Util.readInputToString("src/main/resources/5.txt"));
        System.out.println();
        runPart2(Util.readInputToString("src/main/resources/5.txt"));
    }

    public static int findAmountOfStacksNeeded(String readInputToString) {

        Scanner scanner = new Scanner(readInputToString);
        String numberOfStacks = null;
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine().trim();
            if (line.split(" ")[0].equals("1")) {
                numberOfStacks = line.trim().split("")[line.length() - 1];
                break;
            }
        }
        return Integer.parseInt(numberOfStacks);
    }

    public static List<Stack<String>> populateStacks(String input) {

        List<Stack<String>> stackList = new ArrayList<>();
        for (int i = 0; i < findAmountOfStacksNeeded(input) + 1; i++)
            stackList.add(new Stack<>());

        List<String> instructions = new ArrayList<>(Arrays.asList(input.split("1")));
        String startValues = instructions.get(0);
        Scanner scanner = new Scanner(startValues);

        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            int spaceCount = 0;
            for (int i = 0; i < line.length(); i++) {
                char a = line.charAt(i);
                if (a == ' ') {
                    spaceCount++;

                } else if (Character.isAlphabetic(a)) {
                    int skipStacks = (spaceCount) / 4;

                    stackList.get(skipStacks + 1).push(String.valueOf(a));
                    spaceCount += 3;
                }
            }
        }
        //Revers since I push crates from top to bottom
        stackList.forEach(Collections::reverse);
        return stackList;
    }

    public static List<String> getInstructions(String input) {
        List<String> instructions = new ArrayList<>(Arrays.asList(input.split("move")));
        instructions.remove(0);
        return instructions.stream().map(String::trim).toList();
    }

    public static List<Stack<String>> runInstructions(List<Stack<String>> stacks, List<String> instructions) {

        for (String instruction : instructions) {
            int pieces = Integer.parseInt(instruction.substring(0, instruction.indexOf(" ")));
            int fromStack = Integer.parseInt(instruction.substring(instruction.indexOf("from") + 5, instruction.indexOf("to") - 1));
            int toStack = Integer.parseInt(instruction.substring(instruction.indexOf("to") + 3));

            executeOperation(pieces, fromStack, toStack, stacks);
        }
        return stacks;
    }

    public static List<Stack<String>> runInstructionsPart2(List<Stack<String>> stacks, List<String> instructions) {
        for (String instruction : instructions) {
            int pieces = Integer.parseInt(instruction.substring(0, instruction.indexOf(" ")));
            int fromStack = Integer.parseInt(instruction.substring(instruction.indexOf("from") + 5, instruction.indexOf("to") - 1));
            int toStack = Integer.parseInt(instruction.substring(instruction.indexOf("to") + 3));

            executeOperationPart2(pieces, fromStack, toStack, stacks);
        }
        return stacks;
    }

    private static void executeOperationPart2(int pieces, int fromStack, int toStack, List<Stack<String>> stacks) {
        StringBuilder crates = new StringBuilder();
        for (int i = 0; i < pieces; i++) {
            crates.append(stacks.get(fromStack).pop());
        }
        //reverse so that they end up in the "right" order for part 2
        crates.reverse();
        for (int i = 0; crates.toString().length() > i; i++) {
            stacks.get(toStack).push(String.valueOf(crates.charAt(i)));
        }
    }

    private static void executeOperation(int pieces, int fromStack, int toStack, List<Stack<String>> stacks) {
        for (int i = 0; i < pieces; i++) {
            stacks.get(toStack).push(stacks.get(fromStack).pop());
        }
    }

    public static void runPart1(String input) {
        List<Stack<String>> stacks = populateStacks(input);
        runInstructions(stacks, getInstructions(input));
        System.out.print("part1: ");
        for (int i = 1; i < stacks.size(); i++) {
            System.out.print(stacks.get(i).lastElement());
        }
    }

    public static void runPart2(String input) {
        List<Stack<String>> stacks = populateStacks(input);
        runInstructionsPart2(stacks, getInstructions(input));
        System.out.print("part2: ");
        for (int i = 1; i < stacks.size(); i++) {
            System.out.print(stacks.get(i).lastElement());
        }
    }
}
