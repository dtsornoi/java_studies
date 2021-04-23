package com.homework.task3;

import com.homework.task3.beans.Battery;
import com.homework.task3.beans.Disc;
import com.homework.task3.configuration.BatteryConfig;
import com.homework.task3.configuration.DiscConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(BatteryConfig.class, DiscConfig.class);

        Disc disc = context.getBean(Disc.class);
        Battery battery = context.getBean(Battery.class);
        System.out.println(disc.getName());
        System.out.println(battery.getName());
    }
}
