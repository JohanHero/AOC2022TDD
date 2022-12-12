package org.aoc;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Day3 {
    private int sum;
    public static final Map<String, Integer> valueMap = Util.createValueMap();

    public Day3() {
        this.sum = 0;
    }

    public static void main(String[] args) throws IOException {
        Day3 d1 = new Day3();
        d1.run("src/main/resources/3.txt");
        System.out.println("Part 1: " + d1.getSum());

        Day3 d2 = new Day3();
        d2.runPart2("src/main/resources/3.txt");
        System.out.println("Part 2: " + d2.getSum());
    }

    public void runPart2(String path) throws IOException {
        String input = Util.readInputToString(path);
        Scanner scanner = new Scanner(input);
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            addToSum(findDuplicateFromThreeLines(Arrays.asList(
                    line,
                    scanner.nextLine(),
                    scanner.nextLine()
            )));
        }
    }

    public void run(String path) throws IOException {
        String input = Util.readInputToString(path);
        Scanner scanner = new Scanner(input);
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            addToSum(findDuplicateChar(line));
        }
    }

    public static String findDuplicateChar(String line) {
        List<String> first = Arrays.stream(line.substring(0, line.length() / 2).split("")).toList();
        String second = line.substring(line.length() / 2);

        String duplicate = null;
        for (String a : first) {
            if (second.contains(a)) {
                duplicate = a;
                break;
            }
        }
        if (duplicate == null)
            throw new IllegalArgumentException("Something is not right...");
        return duplicate;
    }

    public void addToSum(String duplicateChar) {
        this.sum += valueMap.get(duplicateChar);
    }

    public static String findDuplicateFromThreeLines(List<String> threeLines) {

        String first = threeLines.get(0);
        String second = threeLines.get(1);
        String third = threeLines.get(2);
        String duplicateChar = null;

        for (int i = 0; i < first.length(); i++) {
            if (second.contains(first.substring(i, i + 1)) && third.contains(first.substring(i, i + 1))) {
                duplicateChar = String.valueOf(first.charAt(i));
                break;
            }
        }

        if (duplicateChar == null)
            throw new RuntimeException("Something went wrong....");
        return duplicateChar;
    }

    public int getSum() {
        return sum;
    }
}
