package org.aoc;

import java.io.IOException;
import java.util.*;

public class Day1 {

    public static void main(String[] args) throws IOException {


        String input = Util.readInputToString("src/main/resources/input_1.txt");

        System.out.println("Part 1: " + getMaxNumber(getSumsOfConnectedNumbers(input)));
        System.out.println("Part 2: " + getSumOfTopThree(getSumsOfConnectedNumbers(input)));

    }

    protected static List<Integer> getSumsOfConnectedNumbers(String inputTest1) {

        Scanner scanner = new Scanner(inputTest1);
        int sum = 0;
        List<Integer> sums = new ArrayList<>();
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            if (!line.isEmpty()) {
                sum += Integer.parseInt(line);
            } else {
                sums.add(sum);
                sum = 0;
            }
        }
        return sums;
    }

    protected static int getSumOfTopThree(List<Integer> sums) {
        sums.sort(Collections.reverseOrder());
        return sums.get(0) + sums.get(1) + sums.get(2);
    }

   protected static int getMaxNumber(List<Integer> sumsOfConnectedNumbers) {
        return Collections.max(sumsOfConnectedNumbers);
    }
}
