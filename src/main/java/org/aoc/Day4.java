package org.aoc;

import java.io.IOException;
import java.util.Scanner;

public class Day4 {


    public static void main(String[] args) throws IOException {
        System.out.println("Part 1: " + runPart1(Util.readInputToString("src/main/resources/4.txt")));
        System.out.println("Part 2: " + runPart2(Util.readInputToString("src/main/resources/4.txt")));
    }

    public static boolean checkOverLap(String line) {
        String s1 = line.substring(0, line.indexOf(','));
        String s2 = line.substring(line.indexOf(',') + 1);

        int firstFirst = Integer.parseInt(s1.substring(0, s1.indexOf('-')));
        int firstSecond = Integer.parseInt(s1.substring(s1.indexOf('-') + 1));

        int secondFirst = Integer.parseInt(s2.substring(0, s2.indexOf('-')));
        int secondSecond = Integer.parseInt(s2.substring(s2.indexOf('-') + 1));
        return firstFirst >= secondFirst && firstSecond <= secondSecond || secondFirst >= firstFirst && secondSecond <= firstSecond;
    }

    public static int runPart1(String readInputToString) {

        int sum = 0;
        Scanner scanner = new Scanner(readInputToString);
        while (scanner.hasNextLine()) {
            if (checkOverLap(scanner.nextLine()))
                sum++;
        }
        return sum;
    }

    public static boolean checkOverLapPart2(String line) {
        String s1 = line.substring(0, line.indexOf(','));
        String s2 = line.substring(line.indexOf(',') + 1);

        int firstFirst = Integer.parseInt(s1.substring(0, s1.indexOf('-')));
        int firstSecond = Integer.parseInt(s1.substring(s1.indexOf('-') + 1));

        int secondFirst = Integer.parseInt(s2.substring(0, s2.indexOf('-')));
        int secondSecond = Integer.parseInt(s2.substring(s2.indexOf('-') + 1));
        return firstFirst >= secondFirst && firstFirst <= secondSecond
                || firstSecond >= secondFirst && firstSecond <= secondSecond
                || secondFirst >= firstFirst && secondFirst <= firstSecond
                || secondSecond <= firstFirst && secondSecond >= firstSecond;
    }

    public static int runPart2(String readInputToString) {
        int sum = 0;
        Scanner scanner = new Scanner(readInputToString);
        while (scanner.hasNextLine()) {
            if (checkOverLapPart2(scanner.nextLine()))
                sum++;
        }
        return sum;
    }
}
