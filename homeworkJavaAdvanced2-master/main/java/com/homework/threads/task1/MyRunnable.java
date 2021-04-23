package com.homework.threads.task1;

public class MyRunnable implements Runnable{
    @Override
    public void run() {
        for (int i = 14300; i < 17801; i++){
            if (i % 2 == 0){
                System.out.println(i);
            }
        }
    }
}
