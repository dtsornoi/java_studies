package com.homework.io.task2;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ReadFile {
    public static void main(String[] args) {
        String filePath = "/Users/dmitritsornoi/Desktop/Java Advanced Part 2/src/main/java/com/homework/io/task2/test.txt";
        try(Scanner sc = new Scanner(new File(filePath))){
            while (sc.hasNextLine()){
                String line = sc.nextLine();
                System.out.println(line);
            }
        }catch (FileNotFoundException e){
            System.out.println("File not Found");
            e.printStackTrace();
        }
    }
}
