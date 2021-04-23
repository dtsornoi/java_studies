package com.sda.exercise_2.configuration;

import com.sda.exercise_2.beans.Holiday;
import com.sda.exercise_2.beans.TravelAgency;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
@ComponentScan(value = "com.sda.exercise_2.beans")
public class AppConfiguration {
    @Bean
    public Holiday christmas(){
        Holiday theChristmas = new Holiday();
        theChristmas.setGreeting("Happy new Year");
        theChristmas.setMonth(5);
        theChristmas.setDay(10);
        return theChristmas;
    }

    @Bean
    public TravelAgency travelAgency(List<Holiday> holidayList){
        TravelAgency travelAgency = new TravelAgency();
        travelAgency.setMessage("This is msg from ta bean");
        travelAgency.setHolidayList(holidayList);
        return travelAgency;
    }
}
