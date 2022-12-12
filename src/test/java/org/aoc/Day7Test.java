package org.aoc;

import org.aoc.day7.Day7;
import org.aoc.day7.FileNode;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Day7Test {


    @Test
    void test() throws IOException {
        Day7.run(Util.readInputToString("src/test/resources/7_test.txt"));
    }

    @Test
    void isRoot() {
        FileNode root = new FileNode(null, null);
        Assertions.assertTrue(root.isRoot());
    }

    @Test
    void isLeaf() {
        FileNode root = new FileNode(null, null);
        Assertions.assertTrue(root.isLeaf());
    }

    @Test
    void addChild() {
        FileNode root = new FileNode(null, null);
        root.addChild(new FileNode(null, root));
        root.addChild(new FileNode("151515", root));
        Assertions.assertEquals(2, root.children.size());
    }

    @Test
    void populateRoot() throws IOException {
        String input = """
                $ cd /
                $ ls
                dir a
                14848514 b.txt
                8504156 c.dat
                dir d
                """;
        FileNode tree = Day7.populateTree(input);

    }

    @Test
    void moveToChild() {
        String input = """
                $ cd /
                $ ls
                dir a
                14848514 b.txt
                8504156 c.dat
                dir d
                $ cd a
                $ ls
                """;
        FileNode tree = Day7.populateTree(input);
        FileNode expectedChild = new FileNode("dir a", tree);
        Assertions.assertEquals(expectedChild.data, tree.moveToChild("a").data);
        Assertions.assertEquals(tree, tree.moveToChild("a").getParent());
    }

    @Test
    void day2() throws IOException {

        FileNode tree = Day7.populateTree(Util.readInputToString("src/test/resources/7_test.txt"));

        FileNode.traverseAndSumDir(tree);

        FileNode.traverseAndCollectSumOfDir(tree);

        int sizeToRemove = 70000000 - tree.sumOfDirValues;

        List<Integer> listOfDir = new ArrayList<>();
        FileNode.collectAllDirFromTree(tree, listOfDir);
        Collections.sort(listOfDir);
        int val = 0;
        for (Integer i : listOfDir) {
            if (70000000 - tree.sumOfDirValues + i > 30000000) {
                System.out.println(i);
                val = i;
                break;
            }
        }

        Assertions.assertEquals(24933642, val);
    }


}
