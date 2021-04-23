package com.sda.spring;

import com.sda.spring.configuration.DIConfiguration;
import com.sda.spring.consumer.MyApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ClientApplication {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(DIConfiguration.class);

        MyApplication app = context.getBean(MyApplication.class);
        app.processMessage("Hi Dima", "dima@abc.com");

        context.close();
    }
}
