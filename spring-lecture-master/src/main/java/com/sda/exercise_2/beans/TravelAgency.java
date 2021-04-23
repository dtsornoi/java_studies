package com.sda.exercise_2.beans;

import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class TravelAgency {
    private List<Holiday> holidayList;
    private String message;

    public void hello(){
        System.out.println("hello from TravelAgency bean " + message);
    }

    public List<Holiday> getHolidayList() {
        return holidayList;
    }

    public void setHolidayList(List<Holiday> holidayList) {
        this.holidayList = holidayList;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "TravelAgency{" +
                "holidayList=" + holidayList +
                ", message='" + message + '\'' +
                '}';
    }
}
