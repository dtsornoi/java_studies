package com.homework.task2.configuration;

import com.homework.task2.beans.Battery;
import com.homework.task2.beans.Disc;
import com.homework.task2.interfaces.Delivery;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(value = "com.homework.task2.beans")
public class JavaConfig {
    @Bean
    public Battery battery(Delivery delivery){
        Battery battery = new Battery(delivery);
        battery.setName("Duracel");
        battery.setPrice(2.0);

        return battery;
    }

    @Bean
    public Disc disc(Delivery delivery){
        Disc disc = new Disc(delivery);
        disc.setName("Movie");
        disc.setPrice(50.0);

        return disc;
    }
}
