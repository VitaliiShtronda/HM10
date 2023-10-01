package org.example;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.*;
import java.util.InputMismatchException;
import java.util.LinkedList;
import java.util.Scanner;


public class Task2 {
    public static void main(String[] args) throws IOException {


        String filePath = "Files/file.txt";
        File file = new File(filePath);


        File dir = new File(file.getParent());
        dir.mkdir();
        file.createNewFile();


        LinkedList<User> users = new LinkedList<>();


        try (Scanner scanner = new Scanner(new FileReader(file))) {
            if (scanner.hasNextLine()) {
                scanner.nextLine();
            }
            while (scanner.hasNextLine()) {
                User user = new User(scanner.next(), scanner.nextInt());
                users.add(user);
            }
        } catch (FileNotFoundException e) {
            System.out.println("e.getMessage() = " + e.getMessage());
        } catch (InputMismatchException e){
            System.out.println("Wrong data in the file");
        }


        File jsonFile = new File("Files/user.json");

        jsonFile.createNewFile();

        try (FileWriter fw = new FileWriter(jsonFile)) {
            Gson gson = new GsonBuilder().setPrettyPrinting().create();
            String json = gson.toJson(users);
            fw.write(json);
        }
    }
}


class User {
    private String name;
    private int age;

    public User() {
    }

    public User(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
