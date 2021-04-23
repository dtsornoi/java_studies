package com.homework.task2;

import com.homework.task2.beans.Battery;
import com.homework.task2.beans.Product;
import com.homework.task2.configuration.JavaConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(JavaConfig.class);

        Battery product = context.getBean(Battery.class);

        System.out.println(product.getDelivery().isDeliveredBy());
    }
}
