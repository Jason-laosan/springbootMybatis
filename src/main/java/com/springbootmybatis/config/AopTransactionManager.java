//package com.springbootmybatis.config;
//
//import org.aopalliance.intercept.Joinpoint;
//import org.aspectj.lang.ProceedingJoinPoint;
//import org.aspectj.lang.annotation.Around;
//import org.aspectj.lang.annotation.Aspect;
//import org.aspectj.lang.annotation.Pointcut;
//import org.springframework.stereotype.Component;
//
//@Aspect
//@Component
//public class AopTransactionManager {
//
//    @Pointcut("execution(* *..*ServiceImpl.*(..))")
//    public void excudeService(Joinpoint joinpoint){
//
//    }
//
//    @Around("excudeService()")
//    public Object excudeServiceMethod(ProceedingJoinPoint proceedingJoinPoint) {
//        return null;
//    }
//
//
//}
