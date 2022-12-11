package com.sanjay.advent_of_code.aoc_2022.day8;

import com.sanjay.advent_of_code.InputReader;
import java.io.IOException;

/**
 * --- Day 8: Treetop Tree House ---
 * Question: https://adventofcode.com/2022/day/8
 * Answer :
 *  Part1 : 1533
 *  Part2 : 345744
*/
public class Day8 {

    public static void main(String[] args) throws IOException {
        String[] input = parseInput();
        int m = input[0].length();
        int n = input.length;
        // Part 1
        int visibleTrees = 2*m + 2*n - 4; //edge trees
        for(int i = 1; i < n-1; i++) {
            for(int j = 1; j < m-1; j++) {
                int treeHeight = input[i].charAt(j) - '0';
                //left
                boolean visible = true;
                boolean counted = false;
                for(int k = 0; k < j; k++) {
                    if (treeHeight <= (input[i].charAt(k) - '0')) {
                        visible = false;
                        break;
                    }
                }
                if (visible) {
                    visibleTrees++;
                    counted = true;
                }
                //right
                visible = true;
                for(int k = j+1; k < m && visible; k++) {
                    if (treeHeight <= (input[i].charAt(k) - '0')) {
                        visible = false;
                    }
                }
                if (visible && !counted) {
                    visibleTrees++;
                    counted = true;
                }
                //top
                visible = true;
                for(int k = 0; k < i && visible; k++) {
                    if (treeHeight <= (input[k].charAt(j) - '0')) {
                        visible = false;
                    }
                }
                if (visible && !counted) {
                    visibleTrees++;
                    counted = true;
                }
                //bottom
                visible = true;
                for(int k = i+1; k < n && visible; k++) {
                    if (treeHeight <= (input[k].charAt(j) - '0')) {
                        visible = false;
                    }
                }
                if (visible && !counted) {
                    visibleTrees++;
                    counted = true;
                }
            }
        }
        System.out.println("Part1 : " + visibleTrees);

        // Part 1
        int maxScenicTree = 0;
        for(int i = 1; i < n-1; i++) {
            for (int j = 1; j < m - 1; j++) {
                int treeHeight = input[i].charAt(j) - '0';
                int k = j-1;
                while (k > 0 && treeHeight > (input[i].charAt(k) - '0')) k--;
                int leftScenicScore = j - k;
                k = j+1;
                while (k < m-1 && treeHeight > (input[i].charAt(k) - '0')) k++;
                int rightScenicScore = k - j;
                k = i-1;
                while (k > 0 && treeHeight > (input[k].charAt(j) - '0')) k--;
                int topScenicScore = i - k;
                k = i+1;
                while (k < n-1 && treeHeight > (input[k].charAt(j) - '0')) k++;
                int downScenicScore = k - i;
                maxScenicTree = Math.max(maxScenicTree, leftScenicScore * rightScenicScore * topScenicScore * downScenicScore);
            }
        }
        System.out.println("Part2 : " + maxScenicTree);

    }

    private static String[] parseInput() throws IOException {
        String[] data = InputReader.readLines(System.getProperty("user.dir") + "/src/main/java/com/sanjay/advent_of_code/aoc_2022/day8/input_day8.txt");
        return data;
    }
}

