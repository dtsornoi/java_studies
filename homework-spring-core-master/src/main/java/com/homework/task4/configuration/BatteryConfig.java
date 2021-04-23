package com.homework.task4.configuration;

import com.homework.task4.beans.Battery;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(value = "com.homework.task4.beans")
public class BatteryConfig {
    @Bean
    public Battery battery(){
        Battery battery = new Battery();
        battery.setName("Duracel");
        battery.setPrice(2.0);

        return battery;
    }
}
