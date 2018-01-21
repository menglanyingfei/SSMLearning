package com.wtu.spring.aop.annotation;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * 切面
 *
 * @Author menglanyingfei
 * @Created on 2018.01.17 17:06
 */
@Component
@Aspect
public class MyLog {
    /**
     * 环绕通知得在切面的方法中带上一个参数, 类型是ProceedingJoinPoint
     * 通过该对象proceed方法来调用目标对象的业务方法
     */
    @SuppressWarnings("deprecation")
    @Around(value = "execution(* com.wtu.spring.aop.annotation.UserDaoImpl.addUser(..))")
    public void writeConsole(ProceedingJoinPoint pjp) throws Throwable {
        System.out.println(new Date().toLocaleString());
        pjp.proceed(); // 相当于调用目标对象的切入点方法
        System.out.println(new Date().toLocaleString());
    }

    @SuppressWarnings("deprecation")
    @Before(value = "execution(* com.wtu.spring.aop.annotation.UserDaoImpl.deleteUser(..))")
    public void writeConsole() throws Throwable {
        System.out.println(new Date().toLocaleString());
    }
}
