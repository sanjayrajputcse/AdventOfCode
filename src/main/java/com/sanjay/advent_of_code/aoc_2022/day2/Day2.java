package com.sanjay.advent_of_code.aoc_2022.day2;

import com.sanjay.advent_of_code.InputReader;
import java.io.IOException;

/**
 * Question: https://adventofcode.com/2022/day/2
 * Answer :
 *  Part1: 12679
*/
public class Day2 {

    private static final int WIN = 6;
    private static final int TIE = 3;
    private static final int LOSE = 0;
    private static final int[] moveScore = {1, 2, 3};
    private static final int[] outcomeScore = {LOSE, TIE, WIN};
    private static final int[][] moveGrid = {
            {TIE, WIN, LOSE},
            {LOSE, TIE, WIN},
            {WIN, LOSE, TIE}
    };

    public static void main(String[] args) throws IOException {
        String[] data = parseInput();
        int totalScore = 0;
        for (String line : data) {
            int opponentMove = line.charAt(0) - 'A';
            int myMove = line.charAt(2) - 'X';
            totalScore += moveScore[myMove] + moveGrid[opponentMove][myMove];
        }
        System.out.println("Part1: Score => " + totalScore);

        // Part2
        totalScore = 0;
        for (String line : data) {
            int opponentMove = line.charAt(0) - 'A';
            int outcome = outcomeScore[line.charAt(2) - 'X'];
            int myMove = 0;
            for (int i = 0; i <= 2; i++) {
                if (moveGrid[opponentMove][i] == outcome) {
                    myMove = i;
                    break;
                }
            }

            totalScore += moveScore[myMove] + moveGrid[opponentMove][myMove];
        }
        System.out.println("Part2: Score => " + totalScore);
    }

    private static String[] parseInput() throws IOException {
        String[] data = InputReader.readLines(System.getProperty("user.dir") + "/src/main/java/com/sanjay/advent_of_code/aoc_2022/day2/input_day2.txt");
        return data;
    }
}

