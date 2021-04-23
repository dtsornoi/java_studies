package com.homework.threads.task3;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        int[] numbersArray = new int[]{3, 5, 2, 4, 1};
        int[] numbersArray2 = new int[]{3, 5, 2, 4, 1};

        Thread thread1 = new Thread(() -> {
            Arrays.sort(numbersArray);
            System.out.println("Thread1 has completed sorting");
        });



        Thread thread2 = new Thread(() -> {
            Arrays.sort(numbersArray2);
            System.out.println("Thread2 has completed sorting");
        });

        thread1.start();
        thread2.start();

        System.out.println(Thread.activeCount());
    }
}
