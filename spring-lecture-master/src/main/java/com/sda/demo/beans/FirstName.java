package com.sda.demo.beans;

import com.sda.demo.interfaces.BeanName;
import org.springframework.stereotype.Component;

@Component(value = "firstName")
public class FirstName implements BeanName {
    private String name;

    public FirstName(){
        this.name = "SDA";
    }

    @Override
    public String getName() {
        return this.name;
    }
}
