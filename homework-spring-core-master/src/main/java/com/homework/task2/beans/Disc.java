package com.homework.task2.beans;

import com.homework.task2.interfaces.Delivery;
import org.springframework.stereotype.Component;

@Component
public class Disc extends Product {

    public Disc(Delivery delivery) {
        super(delivery);
    }
}
