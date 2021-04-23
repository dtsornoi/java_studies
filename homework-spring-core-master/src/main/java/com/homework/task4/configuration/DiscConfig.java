package com.homework.task4.configuration;

import com.homework.task4.beans.Disc;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(value = "com.homework.task4.beans")
public class DiscConfig {
    @Bean
    public Disc disc(){
        Disc disc = new Disc();
        disc.setName("Movie");
        disc.setPrice(50.0);

        return disc;
    }
}
