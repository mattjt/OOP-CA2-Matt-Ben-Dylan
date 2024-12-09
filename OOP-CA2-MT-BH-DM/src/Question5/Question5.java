package org.example.Question5;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

/**
 *  Name:Ben Hand
 *  Class Group:SD2B
 */
public class Question5 {    //Java Identifier Count (Map)

    public static void readFile(String fileName) throws FileNotFoundException {

        HashMap<String, Integer> identifierCountMap = new HashMap<>();
        HashMap<String, List<String>> lineMap = new HashMap<>();

        File file = new File(fileName);
        Scanner scanner = new Scanner(file);

        int lineNumber = 0;

        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            lineNumber++;
            String[] words = line.split("\\s+");
            for (String word : words) {

                word = word.toLowerCase().replaceAll("[^A-Za-z0-9_]+", "");

                if (!word.isEmpty()) {

                    identifierCountMap.put(word, identifierCountMap.getOrDefault(word, 0) + 1);
                    String lineDetail = lineNumber + ": " + line;
                    lineMap.putIfAbsent(word, new ArrayList<>());

                    if (!lineMap.get(word).contains(lineDetail)) {
                        lineMap.get(word).add(lineDetail);
                    }
                }
            }
        }

        scanner.close();

        for (String word : identifierCountMap.keySet()) {
            System.out.println(word + ": " + identifierCountMap.get(word));
            for (String lineDetail : lineMap.get(word)) {
                System.out.println(lineDetail);
            }
            System.out.println();
        }
    }

    public static void main(String[] args) throws FileNotFoundException {
       readFile("./OOP-CA2-MT-BH-DM/src/Question2/Question2.java");
    }
}
