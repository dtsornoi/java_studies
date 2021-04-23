package com.homework.threads.task1;

public class Main {
    public static void main(String[] args) {
        Runnable target;
        Thread thread1 = new Thread(() -> {
            for (int i = 1000; i<2001; i++){
                if (i % 2 == 0){
                    System.out.println(i);
                }
            }
        });

        thread1.start();

        Thread thread2 = new Thread(new MyRunnable());
        thread2.start();
    }
}
