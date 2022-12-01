package com.sanjay.advent_of_code;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class InputReader {

    public static String[] readLines(String filePath) throws IOException {
        List<String> lines = Files.readAllLines(Paths.get(filePath));
        String[] data = new String[lines.size()];
        for (int i = 0; i < lines.size(); i++) {
            data[i] = lines.get(i);
        }
        return data;
    }

    public static String[][] readGridAsString(String filePath) throws IOException {
        String[] lines = readLines(filePath);
        String[][] data = new String[lines.length][];
        for (int i = 0; i < lines.length; i++) {
            String line = lines[i];
            String[] splits = line.split(" ");
            System.arraycopy(splits, 0, data[i], 0, splits.length);
        }
        return data;
    }

    public static int[][] readGridAsInt(String filePath) throws IOException {
        String[] lines = readLines(filePath);
        int[][] data = new int[lines.length][];
        for (int i = 0; i < lines.length; i++) {
            String line = lines[i];
            String[] splits = line.split(" ");
            data[i] = new int[splits.length];
            for (int j = 0; j < splits.length; j++) {
                data[i][j] = Integer.parseInt(splits[j]);
            }
        }
        return data;
    }

}
