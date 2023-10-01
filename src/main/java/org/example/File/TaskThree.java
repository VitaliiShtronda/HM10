package org.example.File;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class TaskThree {
    public static void main(String[] args) {

        String filePath = "Files/words.txt";
        File file = new File(filePath);

        Map<String, Integer> wordFreq = new HashMap<>();

        try (Scanner scanner = new Scanner( new FileReader(file))){
            while (scanner.hasNext()){
                String wordFromText = scanner.next();
                int value;
                if (wordFreq.get(wordFromText) == null){
                    value = 1;
                } else{
                    value = wordFreq.get(wordFromText) + 1;

                }
                wordFreq.put(wordFromText, value);
            }
        }
        catch (FileNotFoundException e){
            System.out.println("e.getMessage() = " + e.getMessage());
        }
        while (!wordFreq.isEmpty()){
            String maxKey= null;
            for (String key: wordFreq.keySet()){
                if (maxKey == null || wordFreq.get(key) > wordFreq.get(maxKey)){
                    maxKey = key;
                }
            }
            System.out.println("wordFreq.get(maxKey) = " + wordFreq.get(maxKey));
            wordFreq.remove(maxKey);
        }

    }

}
