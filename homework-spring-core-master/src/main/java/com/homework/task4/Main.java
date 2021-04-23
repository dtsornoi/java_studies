package com.homework.task4;

import com.homework.task4.beans.Battery;
import com.homework.task4.beans.Disc;
import com.homework.task4.beans.ShoppingCart;
import com.homework.task4.configuration.BatteryConfig;
import com.homework.task4.configuration.DiscConfig;
import com.homework.task4.configuration.ShoppingCartConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(
                        BatteryConfig.class,
                        DiscConfig.class,
                        ShoppingCartConfig.class);

        Disc disc = context.getBean(Disc.class);
        Battery battery = context.getBean(Battery.class);

        ShoppingCart shoppingCart = context.getBean(ShoppingCart.class);
        shoppingCart.addProduct(disc);
        shoppingCart.addProduct(battery);
        shoppingCart.listAllProducts();

        ShoppingCart shoppingCart2 = context.getBean(ShoppingCart.class);
        System.out.println(shoppingCart);
        System.out.println(shoppingCart2);
    }
}
