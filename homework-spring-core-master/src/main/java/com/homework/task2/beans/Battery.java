package com.homework.task2.beans;

import com.homework.task2.interfaces.Delivery;
import org.springframework.stereotype.Component;

@Component
public class Battery extends Product {
    public Battery(Delivery delivery) {
        super(delivery);
    }
}
