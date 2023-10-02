package org.example.File;

import java.io.*;
import java.util.*;

public class TaskThree {
    public static void main(String[] args) {

        String filePath = "Files/words.txt";
        File file = new File(filePath);

        Map<String, Integer> wordFreq = new HashMap<>();

        Map<String, Integer> wordFrequency = new HashMap<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {

                String[] words = line.split("\\s+");
                for (String word : words) {

                    word = word.replaceAll("[^a-zA-Z]", "").toLowerCase();
                    if (!word.isEmpty()) {

                        wordFrequency.put(word, wordFrequency.getOrDefault(word, 0) + 1);
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }


        List<Map.Entry<String, Integer>> sortedWordFrequency = new ArrayList<>(wordFrequency.entrySet());
        sortedWordFrequency.sort((entry1, entry2) -> entry2.getValue().compareTo(entry1.getValue()));


        for (Map.Entry<String, Integer> entry : sortedWordFrequency) {
            System.out.println(entry.getKey() + " " + entry.getValue());
        }
    }
}




