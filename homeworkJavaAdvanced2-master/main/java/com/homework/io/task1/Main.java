package com.homework.io.task1;

import java.io.File;

public class Main {
    public static void main(String[] args) {
        String[] pathNames;

        File file = new File("/Users/dmitritsornoi/Desktop/Java Advanced Part 2/src/main/java/com/homework");

        pathNames = file.list();

        for (String pathname: pathNames){
            System.out.println(pathname);
        }
    }
}
