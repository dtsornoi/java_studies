package com.sda.demo.beans;

import com.sda.demo.interfaces.BeanName;
import org.springframework.stereotype.Component;

@Component(value = "secondName")
public class SecondName implements BeanName {
    private  String name;

    public SecondName() {
        this.name = "Spring first application";
    }

    @Override
    public String getName() {
        return this.name;
    }
}
