package com.springstudent.springbootdatajpa.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.util.logging.Logger;

@Aspect
@Component
public class TutorialAspect {
    private Logger logger = Logger.getLogger(getClass().getName());

    @Pointcut("execution(* com.springstudent.springbootdatajpa.controller.*.*(..))")
    private void forControllerPackage(){}

    @Pointcut("execution(* com.springstudent.springbootdatajpa.entity.*.*(..))")
    private void forEntityPackage(){}

    @Pointcut("execution(* com.springstudent.springbootdatajpa.service.*.*(..))")
    private void forServicePackage(){}

    @Pointcut("forControllerPackage() || forServicePackage() || forEntityPackage()")
    private void forAppFlow(){}

    @Before("forAppFlow()")
    public void before(JoinPoint joinPoint){
        String method = joinPoint.getSignature().toShortString();

        logger.info("@Before : calling method: " + method);

        Object[] args = joinPoint.getArgs();

        for (Object argument : args){
            logger.info("=> argument: " + argument);
        }
    }

    @AfterReturning(pointcut = "forAppFlow()", returning = "result")
    public void afterReturning(JoinPoint joinPoint, Object result){
        String method = joinPoint.getSignature().toShortString();
        logger.info("@AfterReturning: from method: " + method);

        logger.info("=> result: " + result);
    }
}
