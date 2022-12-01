package com.sanjay.advent_of_code.aoc_2022.day21;

import com.sanjay.advent_of_code.InputReader;
import java.io.IOException;

/**
 * Question: https://adventofcode.com/2022/day/21
 * Answer : 
*/
public class Day21 {

    public static void main(String[] args) throws IOException {
        String[] data = parseInput();
    }

    private static String[] parseInput() throws IOException {
        String[] data = InputReader.readLines(System.getProperty("user.dir") + "/src/main/java/com/sanjay/advent_of_code/aoc_2022/day21/input_day21.txt");
        return data;
    }
}

