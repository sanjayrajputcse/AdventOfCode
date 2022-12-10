package com.sanjay.advent_of_code.aoc_2022.day5;

import com.sanjay.advent_of_code.InputReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

/**
 * --- Day 5: Supply Stacks ---
 * Question: https://adventofcode.com/2022/day/5
 * Answer :
 *  Part1: CFFHVVHNC
 *  Part2: FSZWBPTBG
*/
public class Day5 {

    public static void main(String[] args) throws IOException {
        String[] input = parseInput();
        // based on input
        int maxStackHeight = 8;
        int maxCrateStacks = 9;
        Stack<Character>[] crateStacks1 = new Stack[maxCrateStacks + 1];
        Stack<Character>[] crateStacks2 = new Stack[maxCrateStacks + 1];
        for (int i = 0; i <= maxCrateStacks; i++) {
            crateStacks1[i] = new Stack<>();
            crateStacks2[i] = new Stack<>();
        }
        //reading crate input
        for (int i = maxStackHeight - 1; i >= 0; i--) {
            for (int j = 1, n = 1; j < input[i].length(); j = j + 4, n++) {
                char crate = input[i].charAt(j);
                if (crate != ' ') {
                    crateStacks1[n].push(crate);
                    crateStacks2[n].push(crate);
                }
            }
        }
        // reading move input
        for (int k = maxStackHeight + 2; k < input.length; k++) {
            int crates = Integer.parseInt(input[k].split(" ")[1]);
            int fromStack = Integer.parseInt(input[k].split(" ")[3]);
            int toStack = Integer.parseInt(input[k].split(" ")[5]);
            Stack<Character> tempStack = new Stack<>();
            for (int n = 0 ; n < crates; n++) {
                crateStacks1[toStack].push(crateStacks1[fromStack].pop());
                tempStack.push(crateStacks2[fromStack].pop());
            }
            while (!tempStack.isEmpty()) crateStacks2[toStack].push(tempStack.pop());
        }

        StringBuilder topCrates1 = new StringBuilder();
        StringBuilder topCrates2 = new StringBuilder();
        for (int i = 1; i <= maxCrateStacks; i++) {
            topCrates1.append(crateStacks1[i].peek());
            topCrates2.append(crateStacks2[i].peek());
        }
        System.out.println("Part1: "+ topCrates1.toString());
        System.out.println("Part2: "+ topCrates2.toString());
    }

    private static String[] parseInput() throws IOException {
        String[] data = InputReader.readLines(System.getProperty("user.dir") + "/src/main/java/com/sanjay/advent_of_code/aoc_2022/day5/input_day5.txt");
        return data;
    }
}

