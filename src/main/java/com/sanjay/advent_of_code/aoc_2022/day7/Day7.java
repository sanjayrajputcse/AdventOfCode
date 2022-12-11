package com.sanjay.advent_of_code.aoc_2022.day7;

import com.sanjay.advent_of_code.InputReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

/**
 * --- Day 7: No Space Left On Device ---
 * Question: https://adventofcode.com/2022/day/7
 * Answer :
 *  Part1: 1443806
 *  Part2: 942298
*/
public class Day7 {

    public static class DirectoryTreeNode {
        public boolean isDir = true;
        public int fileSize = 0;
        public int dirSize = 0;
        public HashMap<String, DirectoryTreeNode> children;

        public DirectoryTreeNode() {
            this.children = new HashMap<>();
        }
    }

    public static void main(String[] args) throws IOException {
        String[] input = parseInput();
        DirectoryTreeNode root = buildTree(input, new int[]{0}, new DirectoryTreeNode());
        //Part 1
        System.out.println("Part1: " + findBigDirs(root));
        //Part 2
        List<Integer> allDirs = new ArrayList<>();
        findAllDir(root, allDirs);
        Collections.sort(allDirs);
        int rootDirSize = root.dirSize;
        int i = 0;
        while (i < allDirs.size() && (rootDirSize - allDirs.get(i)) >= 40000000) i++;
        System.out.println("Part2: " + allDirs.get(i));

    }

    private static void findAllDir(DirectoryTreeNode root, List<Integer> allDirSize) {
        allDirSize.add(root.dirSize);
        root.children.forEach((name, node) -> {
            if (node.isDir) {
                findAllDir(node, allDirSize);
            }
        });
    }

    private static int findBigDirs(DirectoryTreeNode root) {
        int[] bigDirsSum = root.dirSize < 100000 ? new int[]{root.dirSize} : new int[]{0};
        root.children.forEach((name, node) -> {
            if (node.isDir) {
                bigDirsSum[0] += findBigDirs(node);
            }
        });
        return bigDirsSum[0];
    }

    private static DirectoryTreeNode buildTree(String[] input, int[] index, DirectoryTreeNode parent) {
        while (index[0] < input.length) {
            index[0]++;
            if (input[index[0]].equals("$ cd ..")) {
                return parent;
            } else if (input[index[0]].startsWith("$ cd ")) {
                DirectoryTreeNode child = buildTree(input, index, parent.children.get(input[index[0]].split(" ")[2]));
                parent.dirSize += child.dirSize;
            } else if (input[index[0]].equals("$ ls")){
                index[0]++;
                while (index[0] < input.length && !input[index[0]].startsWith("$")) {
                    String lsOutLine = input[index[0]];
                    DirectoryTreeNode curNode = new DirectoryTreeNode();
                    if (!lsOutLine.startsWith("dir")) {
                        curNode.fileSize = Integer.parseInt(lsOutLine.split(" ")[0]);
                        curNode.isDir = false;
                    }
                    parent.children.put(lsOutLine.split(" ")[1], curNode);
                    parent.dirSize += curNode.fileSize;
                    index[0]++;
                }
                if (index[0] < input.length) index[0]--;
            }
        }
        return parent;
    }

    private static String[] parseInput() throws IOException {
        String[] data = InputReader.readLines(System.getProperty("user.dir") + "/src/main/java/com/sanjay/advent_of_code/aoc_2022/day7/input_day7.txt");
        return data;
    }
}

