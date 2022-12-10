package com.sanjay.advent_of_code.aoc_2022.day1;

import com.sanjay.advent_of_code.InputReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * --- Day 1: Calorie Counting ---
 * Question: https://adventofcode.com/2022/day/1
 * Answer :
 *  Part1: 69177
 *  Part2: 207456
*/
public class Day1 {

    public static void main(String[] args) throws IOException {
        String[] data = parseInput();
        int maxCaloriesSoFar = Integer.MIN_VALUE;
        int totalCalories = 0;
        List<Integer> totalCaloriesList = new ArrayList<>();
        for (String line : data) {
            if(!line.isEmpty()) {
                totalCalories += Integer.parseInt(line);
            } else {
                maxCaloriesSoFar = Math.max(maxCaloriesSoFar, totalCalories);
                totalCaloriesList.add(totalCalories);
                totalCalories = 0;
            }
        }
        totalCaloriesList.add(totalCalories);
        maxCaloriesSoFar = Math.max(maxCaloriesSoFar, totalCalories);
        System.out.println("Part1: " + maxCaloriesSoFar);
        totalCaloriesList.sort(Comparator.reverseOrder());
        System.out.println("Part2: " + (totalCaloriesList.get(0)+totalCaloriesList.get(1)+totalCaloriesList.get(2)));
    }

    private static String[] parseInput() throws IOException {
        String[] data = InputReader.readLines(System.getProperty("user.dir") + "/src/main/java/com/sanjay/advent_of_code/aoc_2022/day1/input_day1.txt");
        return data;
    }
}

