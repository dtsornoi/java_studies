package com.homework.threads.task2;

import java.util.List;

public class Bridge {
    List<Car> cars;

    public Bridge(List<Car> cars) {
        this.cars = cars;
    }

    public synchronized void driveThrough(){
        for (Car car : cars){
            Thread thread = startingNewThreadWithCarObject(car);
            puttingThreadToSleep(thread);
        }
    }

    private void puttingThreadToSleep(Thread thread) {
        try {
            thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private Thread startingNewThreadWithCarObject(Car car) {
        Thread thread = new Thread(() -> {
            System.out.println(car.getCarName() + " "+ car.getCarType() + " is going through bridge");
        });
        thread.start();
        return thread;
    }
}
