package org.aoc;

import java.io.IOException;
import java.util.*;

public class Day6 {

    public static void main(String[] args) throws IOException {
        System.out.println("Part 1: " + findDifferentCharactersInString(Util.readInputToString("src/main/resources/6.txt"), 4));
        System.out.println("Part 2: " + findDifferentCharactersInString(Util.readInputToString("src/main/resources/6.txt"), 14));
    }

    public static int findDifferentCharactersInString(String readInputToString, int lengthOfString) {
        Scanner scanner = new Scanner(readInputToString);
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();

            for (int i = 1; i < line.length(); i++) {
                if (uniqueCharacters(line.substring(i, i + lengthOfString))) {
                    return i + lengthOfString;
                }
            }
        }
        return -1;
    }

    static boolean uniqueCharacters(String str) {
        for (int i = 0; i < str.length(); i++)
            for (int j = i + 1; j < str.length(); j++)
                if (str.charAt(i) == str.charAt(j))
                    return false;
        return true;
    }
}
