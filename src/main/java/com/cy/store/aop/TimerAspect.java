package com.cy.store.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

/**
 * @author 张金铭
 * @version 1.8
 * @Date:2022/7/28 3:19
 * @Description:
 */
@SuppressWarnings({"all"})
@Component//将当前类的对象创建使用交给Spring容器维护
@Aspect//将当前类标记为切面类
public class TimerAspect {

    @Around("execution(* com.cy.store.service.impl.*.*(..))")
    public Object around(ProceedingJoinPoint pjp) throws Throwable {
        //执行之前先记录当前
        long start = System.currentTimeMillis();
        Object result = pjp.proceed(); //调用目标方法
        
        //后调用当前时间
        long end = System.currentTimeMillis();
        System.out.println("耗时： "+(end-start));
        return result;
    }

}
