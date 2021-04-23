package com.homework.task2.beans;

import com.homework.task2.interfaces.Delivery;
import org.springframework.stereotype.Component;

@Component
public class ExpressDelivery implements Delivery {
    @Override
    public String isDeliveredBy() {
        return "Product is delivered by Express Delivery";
    }
}
