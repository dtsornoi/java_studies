package org.example.aop;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {

    @Before("execution(public void getBook())")
    public void beforeGetBookAdvice(){
        System.out.println(getClass() + ": Before getBook");
    }
}
