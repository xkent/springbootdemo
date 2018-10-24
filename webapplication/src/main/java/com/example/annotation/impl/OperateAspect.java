package com.example.annotation.impl;

import com.example.annotation.MyLog;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;


@Aspect
@Component
public class OperateAspect {
    @Pointcut("@annotation(com.example.annotation.MyLog)")
    public void annotationPointCut() {
        System.out.println("----->annotationPointCut");
    }

    @Before("annotationPointCut()")
    public void before(JoinPoint joinPoint) {
        MethodSignature sign = (MethodSignature) joinPoint.getSignature();
        Method method = sign.getMethod();
        MyLog annotation = method.getAnnotation(MyLog.class);
        System.out.print("打印：" + annotation.value() + " 前置日志");
    }

    @After("annotationPointCut()")
    public void after(JoinPoint joinPoint) {
        MethodSignature sign = (MethodSignature) joinPoint.getSignature();
        Method method = sign.getMethod();
        MyLog annotation = method.getAnnotation(MyLog.class);
        System.out.print("打印：" + annotation.value() + " 后置日志");
    }
}
