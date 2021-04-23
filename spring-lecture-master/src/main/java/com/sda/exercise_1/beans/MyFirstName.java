package com.sda.exercise_1.beans;

import com.sda.exercise_1.interfaces.NameBean;
import org.springframework.stereotype.Component;

@Component(value = "myFirstName")
public class MyFirstName implements NameBean {
    private String name;

    public MyFirstName() {
        this.name = "Dima";
    }

    @Override
    public String getName() {
        return this.name;
    }
}
