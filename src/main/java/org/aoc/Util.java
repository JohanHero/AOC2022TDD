package org.aoc;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;

public class Util {

    public static String readInputToString(String path) throws IOException {
        try {
            Path fileName = Path.of(path);
            return Files.readString(fileName);
        } catch (Exception e) {
            throw new IOException("aj aj aj ");
        }

    }

    public static Map<String, Integer> createValueMap() {

        Map<String, Integer> valueMap = new HashMap<>();
        String upperLetters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String lowerLetter = "abcdefghijklmnopqrstuvwxyz";
        char[] charsUpper = upperLetters.toCharArray();
        char[] charsLower = lowerLetter.toCharArray();
        StringBuilder sb = new StringBuilder(55);
        //Just adding ö to get the indexes right
        sb.append('ö');
        sb.append(charsLower);
        sb.append(charsUpper);
        char[] result = sb.toString().toCharArray();


        for (int i = 1; i < 53; i++) {
            valueMap.put(String.valueOf(result[i]), i);
        }
        return valueMap;
    }

    public static List<Stack<String>> createArrayOfStacks(String input) {
        List<Stack<String>> listOfStacks = new ArrayList<>();
        Scanner scanner = new Scanner(input);
        String line;
        while (scanner.hasNextLine()) {
            line = scanner.nextLine();
            var a = line.length() / 3;
            if (line.isBlank())
                break;

        }

        return listOfStacks;
    }
    public static int[][] create2DGrid(String input) throws IOException {

    Scanner s = new Scanner(input);
    int size = s.nextLine().length();
        s.close();
    Scanner scanner = new Scanner(input);
    int[][] grid = new int[size][size];
        while (scanner.hasNextLine()) {

        for (int row = 0; row < size; row++) {
            String line = scanner.nextLine();
            for (int col = 0; col < size; col++) {
                int num = Integer.parseInt(String.valueOf(line.charAt(col)));
                grid[row][col] = num;
            }
        }
    }
        return grid;
}
}
