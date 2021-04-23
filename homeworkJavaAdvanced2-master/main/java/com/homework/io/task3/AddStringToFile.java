package com.homework.io.task3;

import java.io.*;

public class AddStringToFile {
    public static void main(String[] args) {
        String string = "Hello World";
        String fileName = "/Users/dmitritsornoi/Desktop/Java Advanced Part 2/src/main/java/com/homework/io/io/file.txt";
        try{
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(fileName));
            bufferedWriter.write(string);

            bufferedWriter.close();
        }catch (FileNotFoundException e){
            System.out.println("File Not Found");
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
