package com.sda.demo.beans;

import com.sda.demo.interfaces.BeanName;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class MyBean {
    private BeanName name;

    @Autowired
    public MyBean(@Qualifier("firstName") BeanName name) {
        this.name = name;
    }

    public void setName(BeanName name) {
        this.name = name;
    }

    public String sayHello(){
        return "Hello " + name.getName();
    }
}
