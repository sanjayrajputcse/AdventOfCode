package com.sanjay.advent_of_code.aoc_2022.day6;

import com.sanjay.advent_of_code.InputReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * --- Day 6: Tuning Trouble ---
 * Question: https://adventofcode.com/2022/day/6
 * Answer :
 *  Part1: 1876
 *  Part2: 2202
*/
public class Day6 {

    public static void main(String[] args) throws IOException {
        String input = parseInput()[0];
        // Part 1
        HashMap<Character, Integer> seen = new HashMap<>();
        int processedChars = 0;
        int minUniqueChars = 4;
        for (int i = 0; i < input.length(); i++) {
            Character ch = input.charAt(i);
            seen.merge(ch, 1, Integer::sum);
            if (seen.size() == minUniqueChars) {
                processedChars = i+1;
                break;
            }
            if (i >= minUniqueChars-1) {
                Character firstChar = input.charAt(i-(minUniqueChars-1));
                seen.put(firstChar, seen.get(firstChar) - 1);
                if (seen.get(firstChar) == 0) {
                    seen.remove(firstChar);
                }
            }
        }
        System.out.println("Part1: " + processedChars);

        // Part 2
        seen = new HashMap<>();
        processedChars = 0;
        minUniqueChars = 14;
        for (int i = 0; i < input.length(); i++) {
            Character ch = input.charAt(i);
            seen.merge(ch, 1, Integer::sum);
            if (seen.size() == minUniqueChars) {
                processedChars = i+1;
                break;
            }
            if (i >= minUniqueChars-1) {
                Character firstChar = input.charAt(i-(minUniqueChars-1));
                seen.put(firstChar, seen.get(firstChar) - 1);
                if (seen.get(firstChar) == 0) {
                    seen.remove(firstChar);
                }
            }
        }
        System.out.println("Part2: " + processedChars);
    }

    private static String[] parseInput() throws IOException {
        String[] data = InputReader.readLines(System.getProperty("user.dir") + "/src/main/java/com/sanjay/advent_of_code/aoc_2022/day6/input_day6.txt");
        return data;
    }
}

