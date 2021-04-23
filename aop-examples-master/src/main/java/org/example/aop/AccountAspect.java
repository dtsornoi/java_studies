package org.example.aop;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class AccountAspect {

    @Pointcut("execution(* org.example.dao.*.*(..))")
    @Order(2)
    public void forDaoPackage(){}

    @Pointcut("execution(* org.example.dao.*.set*(..))")
    public void forSetter(){}

    @Pointcut("execution(* org.example.dao.*.get*(..))")
    public void forGetter(){}

    @Pointcut("forDaoPackage() && !(forGetter() || forSetter())")
    @Order(1)
    public void forDaoPackageNoGetterSetter(){}


    @Before("forDaoPackageNoGetterSetter()")
    public void beforeAddAccountAdvice(){
        System.out.println("\n========> Executed before addAccount method");
    }


}
