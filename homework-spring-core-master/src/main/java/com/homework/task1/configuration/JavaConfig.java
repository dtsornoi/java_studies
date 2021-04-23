package com.homework.task1.configuration;

import com.homework.task1.beans.Battery;
import com.homework.task1.beans.Disc;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(value = "com.homework.task1.beans")
public class JavaConfig {
    @Bean
    public Battery battery(){
        Battery battery = new Battery();
        battery.setName("Duracel");
        battery.setPrice(2.0);

        return battery;
    }

    @Bean
    public Disc disc(){
        Disc disc = new Disc();
        disc.setName("Movie");
        disc.setPrice(50.0);

        return disc;
    }
}
