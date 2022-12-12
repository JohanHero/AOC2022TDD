package org.aoc;

import java.io.IOException;
import java.util.Scanner;

public class Day2 {

    public static void main(String[] args) throws IOException {

        System.out.println("part 1: " + getSumOfFights(Util.readInputToString("src/main/resources/2.txt")));
        System.out.println("part 2: " + getSumOfRiggedFights(Util.readInputToString("src/main/resources/2.txt")));

    }

    private static int getSumOfRiggedFights(String input) {
        int sum = 0;
        Scanner scanner = new Scanner(input);
        while (scanner.hasNextLine())
            sum += getSumOfRiggedFight(scanner.nextLine());

        return sum;
    }

    private static int getSumOfRiggedFight(String line) {
        String first = line.substring(0, line.indexOf(" "));
        String second = line.substring(line.indexOf(" ")+1);

        return switch (first) {
            case "A" -> rockFightRigged(second);
            case "B" -> paperFightRigged(second);
            case "C" -> scissorFightRigged(second);
            default -> throw new IllegalArgumentException("error message");
        };
    }

    protected static int getSumOfFights(String input) throws IOException {
        int sum = 0;
        Scanner scanner = new Scanner(input);
        while (scanner.hasNextLine())
            sum += getSumOfFight(scanner.nextLine());
        return sum;
    }


    public static int getSumOfFight(String line) {

        String first = line.substring(0, line.indexOf(" "));
        String second = line.substring(line.indexOf(" ")+1);

        return switch (first) {
            case "A" -> rockFight(second);
            case "B" -> paperFight(second);
            case "C" -> scissorFight(second);
            default -> throw new IllegalArgumentException("error message");
        };
    }

    protected static int scissorFight(String myHand) {
        return switch (myHand) {
            case "X" -> 7;
            case "Y" -> 2;
            case "Z" -> 6;
            default -> throw new IllegalArgumentException("Error");
        };
    }

    protected static int paperFight(String myHand) {
        return switch (myHand) {
            case "X" -> 1;
            case "Y" -> 5;
            case "Z" -> 9;
            default -> throw new IllegalArgumentException("Error");
        };
    }

    protected static int rockFight(String myHand) {
        return switch (myHand) {
            case "X" -> 4;
            case "Y" -> 8;
            case "Z" -> 3;
            default -> throw new IllegalArgumentException("Error");
        };
    }

    public static int rockFightRigged(String myHand) {
        return switch (myHand) {
            case "X" -> 3;
            case "Y" -> 4;
            case "Z" -> 8;
            default -> throw new IllegalArgumentException("Error");
        };
    }
    public static int paperFightRigged(String myHand) {
        return switch (myHand) {
            case "X" -> 1;
            case "Y" -> 5;
            case "Z" -> 9;
            default -> throw new IllegalArgumentException("Error");
        };
    }
    public static int scissorFightRigged(String myHand) {
        return switch (myHand) {
            case "X" -> 2;
            case "Y" -> 6;
            case "Z" -> 7;
            default -> throw new IllegalArgumentException("Error");
        };
    }
}
