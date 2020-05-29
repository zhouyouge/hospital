package com.future.utils;

import org.apache.log4j.Logger;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;

import java.util.Arrays;

@Aspect
public class ServiceLogger {
    private static Logger logger = Logger.getLogger(ServiceLogger.class);

    /*@Before("execution(* com.service..*.*(..))")
    public void before(JoinPoint joinPoint){
        logger.info("前置调用"+joinPoint.getTarget()+"的"+joinPoint.getSignature().getName()+"方法，方法入参"+ Arrays.toString(joinPoint.getArgs()));
    }

    @AfterReturning(value = "execution(* com.service..*.*(..))",returning = "result")
    public void afterReturning(JoinPoint jp,Object result){
        logger.info("后置调用："+jp.getTarget()+"的"+jp.getSignature().getName()+"方法，方法返回值："+result);
    }

    @AfterThrowing(value = "execution(* com.service..*.*(..))",throwing = "e")
    public void afterThrowing(JoinPoint jp,RuntimeException e){
        logger.info("异常抛出增强调用"+jp.getTarget()+"的"+jp.getSignature().getName()+"方法，方法抛出的异常:"+e);
    }

    @After("execution(* com.service..*.*(..))")
    public void  afterFinally(JoinPoint jp){
        logger.info("最终增强调用完："+jp.getTarget()+"的"+jp.getSignature().getName()+"方法");
    }
*/
    @Around("execution(* *.service..*.*(..))")
    public Object round(ProceedingJoinPoint joinPoint){
        logger.info("r:前置增强调用："+joinPoint.getTarget()+"的"+joinPoint.getSignature().getName()+"方法，方法入参："+Arrays.toString(joinPoint.getArgs()));

        Object result = null;
        try {
            result = joinPoint.proceed();
            logger.info("r:后置增强调用："+joinPoint.getTarget()+"的"+joinPoint.getSignature().getName()+"方法，方法返回值："+result);
            return  result;
        } catch (Throwable throwable) {
            logger.info("r:异常抛出增强调用"+joinPoint.getTarget()+"的"+joinPoint.getSignature().getName()+"方法，方法抛出的异常:"+throwable);
            throw new RuntimeException();
        }finally {
            logger.info("r:最终增强调用完："+joinPoint.getTarget()+"的"+joinPoint.getSignature().getName()+"方法");
        }


    }




}


