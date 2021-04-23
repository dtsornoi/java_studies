package com.homework.task2.beans;

import com.homework.task2.interfaces.Delivery;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary
public class RegularDelivery implements Delivery {
    @Override
    public String isDeliveredBy() {
        return "Product is delivered by Regular Delivery";
    }
}
