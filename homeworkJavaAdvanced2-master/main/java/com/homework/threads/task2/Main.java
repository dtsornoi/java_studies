package com.homework.threads.task2;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        Car car1 = new Car("Audi", "sedan");
        Car car2 = new Car("BMW", "mini-van");
        Car car3 = new Car("Toyota", "Jeep");
        Car car4 = new Car("Mercedes", "Buss");
        Car car5 = new Car("Peugeot", "Sub");

        var cars = List.of(car1, car2, car3, car4, car5);

        Bridge bridge = new Bridge(cars);
        bridge.driveThrough();
    }
}
