package com.homework.task1;

import com.homework.task1.beans.Disc;
import com.homework.task1.configuration.JavaConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(JavaConfig.class);

        Disc disc = context.getBean(Disc.class);

        System.out.println(disc.getName());
    }
}
