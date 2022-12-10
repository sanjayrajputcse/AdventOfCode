package com.sanjay.advent_of_code.aoc_2022.day4;

import com.sanjay.advent_of_code.InputReader;
import java.io.IOException;

/**
 * --- Day 4: Camp Cleanup ---
 * Question: https://adventofcode.com/2022/day/4
 * Answer :
 *  Part1: 494
 *  Part2: 833
*/
public class Day4 {

    public static void main(String[] args) throws IOException {
        String[] input = parseInput();
        int fullyContainsPairs = 0;
        int overlappingPairs = 0;
        for (String pair : input) {
            String[] pair1Range = pair.split(",")[0].split("-");
            String[] pair2Range = pair.split(",")[1].split("-");
            int range1Start = Integer.parseInt(pair1Range[0]);
            int range1End = Integer.parseInt(pair1Range[1]);
            int range2Start = Integer.parseInt(pair2Range[0]);
            int range2End = Integer.parseInt(pair2Range[1]);
            // Part 1
            if ((range1Start <= range2Start && range1End >= range2End) ||
                    (range2Start <= range1Start && range2End >= range1End)) {
                fullyContainsPairs++;
            }
            // Part 2
            if (!(range1End < range2Start || range2End < range1Start)) {
                overlappingPairs++;
            }
        }
        System.out.println("Part1: " + fullyContainsPairs);
        System.out.println("Part2: " + overlappingPairs);
    }

    private static String[] parseInput() throws IOException {
        String[] data = InputReader.readLines(System.getProperty("user.dir") + "/src/main/java/com/sanjay/advent_of_code/aoc_2022/day4/input_day4.txt");
        return data;
    }
}

