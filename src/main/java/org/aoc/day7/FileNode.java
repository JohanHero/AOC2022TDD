package org.aoc.day7;


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class FileNode {

    public String data;
    public FileNode parent;
    public int sumOfDirValues = 0;
    public List<FileNode> children;
    public static int sumOfDirLessThan100k = 0;


    public FileNode(String data, FileNode parent) {
        this.data = data;
        this.parent = parent;
        this.children = new LinkedList<>();
        this.sumOfDirValues = 0;
    }

    public boolean isRoot() {
        return this.parent == null;
    }

    public boolean isLeaf() {
        return this.children.isEmpty();
    }

    public FileNode addChild(FileNode fileNode) {
        FileNode childNode = new FileNode(fileNode.data, this);
        this.children.add(childNode);
        return childNode;
    }

    public String getData() {
        return data;
    }

    public FileNode getParent() {
        return parent;
    }

    public FileNode moveToChild(String data) {

        FileNode retNode = null;
        for (FileNode child : this.children) {
            if (child.data.equals("dir " + data)) {
                retNode = child;
                break;
            }
        }
        if (retNode == null)
            throw new RuntimeException("Cannot find childNode");
        return retNode;
    }

    public int getNodeValue() {
        return Integer.parseInt(this.data.substring(0, this.data.indexOf(" ")));
    }


    public static void traverseAndSumDir(FileNode node) {

        if (node.children.size() == 0) {
            return;
        }
        for (FileNode fileNode : node.children) {
            traverseAndSumDir(fileNode);
        }
        if (node.parent != null)
            node.parent.sumOfDirValues += node.sumOfDirValues;
    }

    public static void  traverseAndCollectSumOfDir(FileNode node) {

        if(node.children.isEmpty())
            return;

        if(node.sumOfDirValues < 100000)
            sumOfDirLessThan100k += node.sumOfDirValues;

        for (FileNode child:node.children) {
            traverseAndCollectSumOfDir(child);
        }
    }

    public static void collectAllDirFromTree(FileNode node, List<Integer> list) {
        if(node.children.isEmpty())
            return;
        if(node.sumOfDirValues > 0)
            list.add(node.sumOfDirValues);

        for (FileNode child:node.children) {
            collectAllDirFromTree(child, list);
        }


    }

}
