package com.homework.io.task5;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        List<User> userList = new ArrayList<>();
        String filePath = "/Users/dmitritsornoi/Desktop/Java Advanced Part 2/src/main/java/com/homework/io/task5/test.csv";
        try {
            Scanner scanner = new Scanner(new FileReader(filePath));

            while(scanner.hasNext()){
              String[]  currentLine = scanner.next().split(",");
              User user = new User(currentLine[0], currentLine[1], Integer.parseInt(currentLine[2]));
              userList.add(user);
            }

            userList.stream()
                    .forEach(user -> System.out.println(user.toString()));

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
