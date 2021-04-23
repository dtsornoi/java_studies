package com.homework.task3.configuration;

import com.homework.task3.beans.Disc;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(value = "com.homework.task3.beans")
public class DiscConfig {
    @Bean
    public Disc disc(){
        Disc disc = new Disc();
        disc.setName("Movie");
        disc.setPrice(50.0);

        return disc;
    }
}
