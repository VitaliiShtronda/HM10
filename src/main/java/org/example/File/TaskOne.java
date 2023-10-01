package org.example.File;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;
import java.util.regex.Pattern;

public class TaskOne {

    public static void main(String[] args) throws Exception{

        String filePath = "Files/file.txt";
        File file = new File(filePath);
        try (Scanner scanner = new Scanner(new FileReader(file))) {
            while (scanner.hasNextLine()) {
                String lineFromFile = scanner.nextLine();
                if (isValidNumber(lineFromFile)) {
                    System.out.println(lineFromFile);
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("e.getMessage() = " + e.getMessage());
        }
    }

    private static boolean isValidNumber(String number) {
        String regex1 = "\\(\\d{3}\\) \\d{3}-\\d{4}";
        String regex2 = "\\d{3}-\\d{3}-\\d{4}";

        Pattern pattern1 = Pattern.compile(regex1);
        Pattern pattern2 = Pattern.compile(regex2);
        boolean isNumberPattern1 = pattern1.matcher(number).matches();
        boolean isNumberPattern2 = pattern2.matcher(number).matches();

        return isNumberPattern1 || isNumberPattern2;
    }

}

