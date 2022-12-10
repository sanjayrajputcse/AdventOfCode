package com.sanjay.advent_of_code.aoc_2022.day3;

import com.sanjay.advent_of_code.InputReader;

import java.io.IOException;

/**
 * --- Day 3: Rucksack Reorganization ---
 * Question: https://adventofcode.com/2022/day/3
 * Answer :
 *  Part1: 7597
 *  Part2: 2607
*/
public class Day3 {

    public static void main(String[] args) throws IOException {
        String[] input = parseInput();

        // Part 1
        int prioritySum = 0;
        for (String rucksack : input) {
            String firstCompartment = rucksack.substring(0, rucksack.length()/2);
            String secondCompartment = rucksack.substring(rucksack.length()/2);
            for (char ch1 : firstCompartment.toCharArray()) {
                if (secondCompartment.contains(String.valueOf(ch1))) {
                    prioritySum += getPriority(ch1);
                    break;
                }
            }
        }
        System.out.println("Part1: " + prioritySum);

        // Part 2
        int badgePrioritySum = 0;
        for (int k = 0; k < input.length; k = k+3) {
            String group1 = input[k];
            String group2 = input[k+1];
            String group3 = input[k+2];
            for (char badge : group1.toCharArray()) {
                if (group2.contains(String.valueOf(badge)) && group3.contains(String.valueOf(badge))) {
                    badgePrioritySum += getPriority(badge);
                    break;
                }
            }
        }
        System.out.println("Part2: " + badgePrioritySum);
    }

    private static int getPriority(char c) {
        return (c >= 'a' && c <= 'z') ? (c - 'a' + 1) : (c - 'A' + 27);
    }

    private static String[] parseInput() throws IOException {
        String[] data = InputReader.readLines(System.getProperty("user.dir") + "/src/main/java/com/sanjay/advent_of_code/aoc_2022/day3/input_day3.txt");
        return data;
    }
}

