package com.sda.exercise_1;

import com.sda.exercise_1.beans.MyBean;
import com.sda.exercise_1.config.AppConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Hello {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(AppConfig.class);
        MyBean bean = context.getBean(MyBean.class);

        System.out.println(bean.sayHello());
        context.close();
    }
}
