package com.sanjay.advent_of_code.aoc_2021;

/**
 * Question : https://adventofcode.com/2021/day/2
 * Answer :
 *   Part1 : 1524750
 *   Part2 : 1592426537
*/
public class Day2_Dive {

    public static void main(String[] args) {
        String[] subCourses = myReading();
        int horizontal_pos = 0;
        int depth = 0;
        int aim = 0;
        int depth2 = 0;
        for(String course : subCourses) {
            String splits[] = course.split(" ");
            int n = Integer.parseInt(splits[1]);
            switch(splits[0]) {
                case "forward":
                    horizontal_pos += n;
                    depth2 += n*aim;
                    break;
                case "down":
                    aim += n;
                    depth += n;
                    break;
                case "up":
                    aim -= n;
                    depth -= n;
                    break;
            }
        }
        System.out.println("Part1 : " + (horizontal_pos * depth));
        System.out.println("Part1 : " + (horizontal_pos * depth2));
    }

    private static String[] myReading() {
        return new String[] {
                "forward 1", "down 9", "down 4", "forward 4", "down 2", "down 7", "up 9", "down 5", "forward 9", "forward 9", "down 2", "forward 7", "forward 9", "down 5", "down 2",
                "up 9", "down 7", "forward 6", "down 6", "down 6", "up 1", "down 2", "forward 8", "forward 8", "forward 9", "up 1", "forward 4", "up 1", "forward 3", "forward 5", "up 3",
                "up 7", "down 4", "down 1", "forward 3", "forward 4", "up 3", "forward 9", "down 2", "forward 5", "up 2", "up 1", "up 5", "forward 1", "up 9", "forward 6", "up 4",
                "down 4", "forward 3", "up 7", "down 1", "down 1", "down 8", "forward 3", "forward 1", "up 7", "up 1", "down 4", "up 6", "down 6", "forward 8", "down 3", "down 9",
                "down 6", "up 8", "forward 8", "down 9", "up 7", "down 7", "forward 8", "down 8", "up 6", "down 7", "down 4", "up 7", "forward 7", "forward 7", "forward 2", "forward 5",
                "down 5", "down 9", "down 8", "down 5", "up 3", "down 3", "down 6", "down 6", "forward 1", "down 2", "forward 2", "down 5", "up 2", "forward 5", "down 1", "down 3",
                "forward 4", "down 2", "forward 8", "down 6", "forward 3", "forward 3", "forward 9", "down 9", "down 4", "down 8", "down 7", "down 3", "up 6", "down 7", "forward 9",
                "up 9", "down 8", "forward 9", "forward 8", "down 2", "up 4", "forward 8", "up 7", "down 2", "forward 6", "forward 7", "down 5", "up 4", "down 3", "down 3", "down 5",
                "down 2", "down 5", "forward 8", "forward 8", "down 5", "up 4", "down 6", "forward 5", "up 6", "up 5", "down 4", "forward 7", "forward 5", "down 7", "up 9", "up 4",
                "up 9", "forward 8", "down 8", "down 8", "down 2", "down 8", "down 8", "up 6", "forward 2", "down 9", "forward 5", "forward 4", "down 8", "up 5", "forward 3", "forward 1",
                "down 6", "forward 9", "forward 2", "forward 1", "up 5", "down 2", "forward 5", "up 6", "up 6", "forward 9", "up 3", "forward 2", "forward 9", "down 9", "down 5", "up 4",
                "up 7", "up 8", "forward 4", "forward 3", "down 7", "down 5", "forward 5", "down 6", "forward 9", "up 4", "up 6", "down 2", "forward 6", "forward 7", "up 9", "up 5",
                "down 4", "up 5", "down 2", "forward 4", "up 9", "down 1", "forward 7", "down 9", "forward 5", "down 5", "down 2", "up 4", "up 8", "down 8", "down 7", "up 7", "down 1",
                "forward 5", "forward 8", "down 2", "down 1", "forward 8", "down 7", "up 6", "forward 9", "forward 4", "down 8", "forward 1", "up 8", "forward 3", "up 4", "forward 9",
                "down 6", "forward 5", "forward 1", "forward 8", "forward 5", "forward 8", "down 4", "forward 8", "forward 2", "forward 8", "forward 3", "down 3", "forward 6", "up 6",
                "up 9", "down 4", "down 6", "forward 6", "down 9", "up 2", "down 8", "down 6", "down 1", "forward 1", "down 2", "down 3", "forward 5", "forward 6", "down 5", "up 7",
                "up 2", "forward 2", "down 4", "down 4", "forward 3", "down 4", "up 4", "forward 1", "down 4", "forward 9", "forward 7", "forward 6", "down 3", "down 4", "forward 3",
                "forward 3", "forward 3", "up 6", "forward 4", "forward 7", "forward 3", "forward 5", "forward 7", "forward 4", "down 1", "up 2", "up 7", "forward 4", "down 2", "forward 2",
                "up 7", "down 7", "forward 5", "forward 9", "down 8", "forward 5", "forward 5", "down 9", "forward 1", "forward 6", "down 2", "down 3", "down 1", "down 7", "down 3", "up 3",
                "down 3", "forward 5", "down 4", "forward 6", "forward 2", "down 4", "forward 4", "up 5", "up 3", "forward 2", "forward 5", "down 7", "up 9", "up 5", "down 3", "forward 8",
                "forward 4", "down 8", "up 4", "forward 8", "forward 7", "forward 1", "down 2", "down 6", "up 7", "forward 9", "down 2", "down 4", "down 3", "down 8", "up 4", "down 2",
                "up 3", "forward 1", "down 2", "up 6", "down 9", "up 3", "down 1", "down 1", "forward 4", "down 2", "forward 3", "forward 5", "forward 7", "down 7", "up 3", "up 5", "down 1",
                "down 2", "forward 4", "down 1", "down 1", "down 7", "up 4", "forward 3", "down 3", "forward 2", "down 3", "up 7", "down 1", "up 5", "down 7", "forward 4", "up 2", "forward 5",
                "up 4", "down 4", "down 3", "forward 1", "up 9", "down 5", "forward 9", "forward 1", "down 7", "down 2", "down 4", "down 2", "forward 3", "down 1", "down 2", "up 9", "forward 2",
                "down 8", "forward 1", "forward 3", "down 5", "down 4", "forward 2", "forward 8", "forward 9", "down 9", "down 6", "up 3", "forward 1", "down 6", "down 7", "up 3", "forward 9",
                "down 2", "up 4", "forward 3", "forward 6", "forward 6", "down 7", "forward 7", "forward 6", "down 7", "up 9", "forward 7", "down 1", "down 8", "down 2", "down 2", "down 9",
                "down 6", "forward 1", "down 9", "forward 9", "forward 8", "forward 6", "forward 9", "down 5", "forward 9", "forward 4", "forward 4", "down 6", "forward 6", "forward 5",
                "forward 7", "down 7", "down 9", "forward 4", "down 9", "up 5", "forward 6", "down 6", "forward 9", "up 7", "forward 6", "up 6", "up 9", "forward 9", "up 4", "down 3", "up 9",
                "down 8", "down 2", "forward 4", "down 8", "down 2", "forward 2", "down 5", "up 3", "down 1", "forward 4", "down 3", "forward 3", "down 9", "forward 6", "forward 6", "down 9",
                "forward 6", "forward 1", "down 5", "up 1", "forward 3", "forward 1", "forward 5", "down 8", "forward 7", "forward 2", "up 3", "forward 8", "forward 1", "forward 7", "down 1",
                "down 4", "forward 7", "forward 9", "forward 4", "down 2", "forward 5", "forward 3", "forward 9", "forward 3", "up 3", "forward 9", "down 3", "forward 9", "forward 3", "forward 7",
                "down 5", "forward 6", "down 6", "forward 5", "forward 1", "down 1", "forward 8", "down 3", "up 1", "down 6", "forward 7", "up 5", "up 7", "down 3", "forward 8", "up 8", "down 4",
                "up 6", "up 7", "forward 1", "forward 2", "forward 7", "down 1", "forward 4", "down 8", "up 6", "up 7", "up 4", "down 7", "down 8", "down 6", "forward 5", "forward 9", "down 7",
                "forward 8", "down 9", "down 9", "forward 5", "forward 2", "up 4", "down 2", "forward 3", "down 2", "forward 1", "down 7", "down 6", "forward 5", "up 2", "forward 4", "down 4",
                "forward 5", "forward 7", "up 5", "down 7", "forward 9", "forward 3", "forward 6", "up 8", "down 9", "forward 1", "up 8", "forward 3", "down 6", "down 1", "down 3", "down 4", "up 2",
                "up 3", "forward 8", "up 7", "down 2", "forward 1", "down 6", "forward 1", "down 8", "forward 3", "forward 5", "forward 5", "up 5", "forward 4", "forward 6", "down 8", "up 7", "forward 8",
                "up 6", "forward 5", "down 4", "forward 8", "down 3", "forward 7", "forward 9", "forward 8", "up 9", "forward 4", "up 5", "up 8", "down 8", "forward 1", "down 1", "forward 3", "forward 9",
                "down 9", "up 2", "forward 5", "down 1", "down 6", "forward 2", "forward 2", "down 2", "down 8", "forward 5", "up 2", "up 2", "forward 3", "down 6", "up 2", "down 2", "down 1", "up 9",
                "forward 6", "up 4", "forward 4", "down 2", "forward 8", "up 9", "down 1", "forward 9", "up 3", "up 7", "forward 5", "down 9", "down 2", "down 5", "up 4", "up 8", "up 2", "down 1", "up 4",
                "forward 8", "forward 2", "down 8", "forward 9", "forward 1", "down 5", "forward 3", "down 6", "forward 3", "up 2", "down 9", "down 6", "down 4", "down 9", "down 8", "forward 2", "forward 7",
                "up 4", "forward 8", "up 9", "up 6", "forward 2", "down 1", "down 5", "down 5", "down 3", "up 9", "up 9", "forward 9", "forward 5", "down 1", "down 3", "down 8", "down 4", "forward 5", "up 4",
                "down 2", "down 5", "down 4", "down 8", "down 2", "forward 9", "forward 7", "up 9", "forward 8", "down 9", "down 2", "forward 5", "down 9", "forward 7", "down 2", "down 9", "forward 4", "up 7",
                "down 9", "forward 6", "forward 2", "down 1", "down 9", "down 3", "down 7", "down 8", "down 5", "down 9", "down 1", "up 9", "down 7", "forward 7", "up 4", "down 2", "down 4", "forward 6",
                "forward 8", "forward 1", "forward 2", "up 2", "up 2", "forward 9", "down 9", "forward 8", "forward 6", "forward 5", "down 2", "forward 7", "up 3", "up 8", "forward 1", "forward 5", "down 7",
                "down 7", "forward 5", "down 1", "up 3", "up 8", "forward 5", "forward 7", "forward 3", "down 6", "up 7", "forward 8", "down 5", "up 3", "forward 7", "down 2", "down 1", "down 1", "forward 1",
                "down 1", "down 8", "down 3", "up 1", "forward 8", "forward 9", "forward 5", "forward 8", "down 2", "forward 3", "down 5", "up 9", "down 9", "down 5", "forward 1", "up 9", "up 4", "up 7", "up 9",
                "up 4", "down 2", "forward 6", "forward 4", "up 5", "up 6", "down 8", "down 6", "down 6", "up 3", "forward 3", "down 9", "down 5", "down 5", "forward 7", "down 6", "forward 7", "down 9", "down 8",
                "down 3", "down 7", "down 4", "down 1", "forward 6", "up 7", "down 1", "forward 7", "down 2", "forward 4", "down 3", "forward 6", "up 7", "forward 3", "down 3", "up 6", "down 2", "down 4",
                "down 8", "forward 6", "down 4", "forward 7", "down 2", "forward 9", "down 3", "down 6", "down 3", "down 6", "forward 4", "down 8", "up 5", "down 6", "forward 6", "down 6", "forward 9", "up 8",
                "down 7", "up 1", "forward 4", "up 3", "forward 9", "up 6", "forward 4", "up 8", "forward 2", "down 7", "down 7", "forward 1", "up 9", "up 7", "forward 3", "down 1", "up 5", "forward 3",
                "forward 1", "forward 3", "forward 7", "down 6", "down 1", "forward 9", "up 1", "up 1", "down 8", "down 7", "forward 1", "up 8", "up 6", "down 8", "forward 1", "up 3", "down 7", "forward 7",
                "down 7", "forward 4", "forward 6", "up 2", "down 9", "forward 9", "down 4", "up 2", "forward 7", "forward 4", "up 8", "up 5", "down 8", "forward 7", "forward 6", "down 1", "up 5", "up 5",
                "down 3", "forward 7", "forward 1", "forward 7", "forward 1", "down 3", "forward 3", "forward 4", "forward 6", "down 3", "up 4", "up 5", "down 8", "up 3", "forward 4", "forward 6", "forward 8",
                "forward 4", "forward 7", "down 9", "up 3", "down 1", "up 4", "forward 8", "forward 5", "forward 4", "forward 1", "down 2", "down 7", "down 6", "forward 4", "forward 2", "up 2", "down 2", "forward 2",
                "forward 2", "up 6", "forward 6", "forward 1", "forward 8", "up 7", "forward 4", "forward 2", "down 2", "down 1", "forward 4", "down 4", "up 7", "up 2", "up 3", "down 5", "forward 2", "forward 9",
                "down 2", "down 9", "down 4", "down 8", "up 9", "up 5", "up 2", "forward 6", "down 6", "forward 9", "forward 7", "forward 8", "forward 4", "up 9", "forward 9", "down 8", "down 2", "forward 5", "down 8",
                "down 8", "forward 8", "forward 6", "forward 7", "down 8", "forward 1", "forward 6", "down 4", "forward 1", "down 3", "forward 1", "down 8", "forward 2", "down 4", "down 6", "down 4", "up 9", "forward 6",
                "up 3", "down 7", "forward 3", "down 8", "forward 6", "forward 3", "down 1", "forward 1", "up 6", "down 1", "down 2", "forward 5", "down 3", "up 5", "forward 6", "forward 7", "forward 2", "forward 9",
                "down 7", "up 4", "forward 6", "forward 8", "down 6", "down 7", "down 4", "down 5", "down 6", "down 3", "up 1", "forward 2", "forward 3", "down 1", "down 7", "up 8", "forward 1", "forward 6", "up 3",
                "down 1", "up 6", "down 2", "up 1", "up 7", "forward 3", "up 8", "forward 7", "forward 5", "forward 5"
        };

    }
}