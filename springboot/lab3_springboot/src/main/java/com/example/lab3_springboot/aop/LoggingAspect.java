package com.example.lab3_springboot.aop;



import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {

    @Before("execution(* com.bank.service.AccountService.*(..))")
    public void logBefore(JoinPoint joinPoint) {
        System.out.println("Executing: " + joinPoint.getSignature().getName());
    }

    @After("execution(* com.bank.service.AccountService.*(..))")
    public void logAfter(JoinPoint joinPoint) {
        System.out.println("Completed: " + joinPoint.getSignature().getName());
    }
}

