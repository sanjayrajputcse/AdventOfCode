package com.sanjay.advent_of_code;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class CodeGenUtil {

    public static void main(String[] args) throws IOException {
        String basePath = "src/main/java/com/sanjay/advent_of_code/aoc_2022";
        Files.createDirectories(Paths.get(basePath));

        for (int day = 1; day <= 25; day++) {
            Path dirPath = Paths.get(basePath + "/" + "day" + day);
            Path createdDir = Files.createDirectories(dirPath);
            System.out.println("day folder created: " + createdDir.toAbsolutePath());

            // create input file
            String inputFilePath = createdDir.toAbsolutePath() + "/" + "input_day" + day + ".txt";
            File inputFile = new File(inputFilePath);
            inputFile.createNewFile();
            System.out.println("new input file created: " + inputFilePath);

            // create java file
            String javaFilePath = createdDir.toAbsolutePath() + "/" + "Day" + day + ".java";
            File javaFile = new File(javaFilePath);
            javaFile.createNewFile();
            System.out.println("new java file created: " + javaFilePath);

            List<String> fileContent = new ArrayList<>();
            fileContent.add(
                    "package com.sanjay.advent_of_code.aoc_2022.day" + day + ";" + "\n" +
                    "\n" +
                    "import com.sanjay.advent_of_code.InputReader;\n" +
                    "import java.io.IOException;\n" +
                    "\n" +
                    "/**\n" +
                    " * Question: https://adventofcode.com/2022/day/" + day + "\n" +
                    " * Answer : \n" +
                    "*/\n" +
                    "public class Day"+ day + " {\n" +
                    "\n" +
                    "    public static void main(String[] args) throws IOException {\n" +
                    "        String[] data = parseInput();\n" +
                    "    }\n" +
                    "\n" +
                    "    private static String[] parseInput() throws IOException {\n" +
                    "        String[] data = InputReader.readLines(System.getProperty(\"user.dir\") + \"" + "/" + basePath + "/day" + day + "/input_day" + day + ".txt\");\n" +
                    "        return data;\n" +
                    "    }\n" +
                    "}\n"
            );
            Files.write(javaFile.toPath(), fileContent);
        }
    }

}
