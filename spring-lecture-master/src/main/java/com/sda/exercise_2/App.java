package com.sda.exercise_2;

import com.sda.exercise_2.beans.Holiday;
import com.sda.exercise_2.beans.TravelAgency;
import com.sda.exercise_2.configuration.AppConfiguration;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Arrays;

public class App {
    public static void main(String[] args) {

        /*
        * Before Spring
        * */
//        Holiday holiday = new Holiday();
//        holiday.setGreeting("Happy new Year");
//        holiday.setDay(10);
//        holiday.setMonth(5);
//
//        TravelAgency travelAgency = new TravelAgency();
//
//        travelAgency.setHolidayList(Arrays.asList(holiday));
//
//        travelAgency.setMessage("Hooooooray!");
//
//        travelAgency.hello();
//
//        System.out.println(travelAgency.getMessage());

        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(AppConfiguration.class);

        TravelAgency travelAgency = context.getBean(TravelAgency.class);
        travelAgency.setMessage("Hoooray");
        travelAgency.hello();
        travelAgency.getHolidayList()
                .forEach(holiday -> System.out.println(holiday.getGreeting()));
    }
}
