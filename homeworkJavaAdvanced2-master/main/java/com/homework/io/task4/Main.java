package com.homework.io.task4;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        String currentWord;
        String longestWord = "";
        String filePath = "/Users/dmitritsornoi/Desktop/Java Advanced Part 2/src/main/java/com/homework/io/task2/test.txt";
        try(Scanner sc = new Scanner(new File(filePath))){
            while (sc.hasNext()){
                currentWord = sc.next();
                if (currentWord.length() > longestWord.length())
                    longestWord = currentWord;
            }
            System.out.println(longestWord);
        }catch (FileNotFoundException e){
            System.out.println("File not Found");
            e.printStackTrace();
        }
    }
}
