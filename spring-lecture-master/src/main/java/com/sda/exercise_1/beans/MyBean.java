package com.sda.exercise_1.beans;

import com.sda.exercise_1.interfaces.NameBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class MyBean {
    private NameBean name;

    @Autowired
    public MyBean(@Qualifier("myFirstName") NameBean name) {
        this.name = name;
    }

    public void setName(NameBean name) {
        this.name = name;
    }

    public String sayHello(){
        return "Hello " + name.getName();
    }
}
