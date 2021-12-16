package com.sanjay.advent_of_code.aoc_2021.utils;

public interface InputProcessor {

    static void leftAdjust(String[] input, int length) {
        StringBuilder line = new StringBuilder();
        for (String i : input) {
            if (line.length() + i.length() > length) {
                System.out.println(line);
                line = new StringBuilder();
            }
            line.append("\"").append(i).append("\", ");
        }
    }

}
