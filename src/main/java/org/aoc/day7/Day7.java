package org.aoc.day7;


import org.aoc.Util;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Day7 {

    public static void main(String[] args) throws IOException {


        run(Util.readInputToString("src/main/resources/7.txt"));

    }

    public static void run(String input) throws IOException {

        FileNode tree = populateTree(input);

        FileNode.traverseAndSumDir(tree);
        FileNode.traverseAndCollectSumOfDir(tree);

        System.out.println("Part 1: " + FileNode.sumOfDirLessThan100k);
        List<Integer> list = new ArrayList<>();
        FileNode.collectAllDirFromTree(tree, list);
        Collections.sort(list);
        for (Integer i : list) {
            if (70000000 - tree.sumOfDirValues + i > 30000000) {
                System.out.println("Part 2: " + i);
                break;
            }
        }

    }

    public static FileNode populateTree(String input) {
        Scanner scanner = new Scanner(input);
        FileNode root = new FileNode(scanner.nextLine(), null);
        FileNode currentNode = root;
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            if (!line.contains("$")) {
                currentNode.addChild(new FileNode(line, null));
                if (Character.isDigit(line.charAt(0))) {
                    currentNode.sumOfDirValues += Integer.parseInt(line.substring(0, line.indexOf(" ")));
                }
            } else if (line.contains("cd ..")) {
                currentNode = currentNode.getParent();
            } else if (line.contains("cd ")) {
                currentNode = currentNode.moveToChild(line.substring(line.indexOf("cd") + 3));
            }
        }
        return root;
    }
}
