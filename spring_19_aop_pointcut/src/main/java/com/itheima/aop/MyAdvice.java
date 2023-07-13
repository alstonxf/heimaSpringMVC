package com.itheima.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
@Aspect //1、定义通知类
public class MyAdvice {
    //切入点表达式：
//    @Pointcut("execution(void com.itheima.dao.BookDao.update())")
//    @Pointcut("execution(void com.itheima.dao.impl.BookDaoImpl.update())")
//    @Pointcut("execution(* com.itheima.dao.impl.BookDaoImpl.update(*))")    //no
//    @Pointcut("execution(void com.*.*.*.update())")
//    @Pointcut("execution(* *..*(..))")
//    @Pointcut("execution(* *..*e(..))")
//    @Pointcut("execution(void com..*())")
//    @Pointcut("execution(* com.itheima.*.*Service.find*(..))")
    //执行com.itheima包下的任意包下的名称以Service结尾的类或接口中的save方法，参数任意，返回值任意
    // 2、定义切入点
    @Pointcut("execution(* *.save(..))")
    private void pt(){}

    @Pointcut("execution(* *.update(..))")
    private void pt2(){}

    @Before("pt()") //4、绑定切入点与通知关系
    public Long method(){
        //3、通知方法
        //记录程序当前执行执行（开始时间）
        Long startTime = System.currentTimeMillis();
        System.out.println("开始时间"+startTime);
        return startTime;
    }

    @After("pt()") //绑定切入点与通知关系
    public Long method2(){
        //记录程序当前执行时间（结束时间）
        Long endTime = System.currentTimeMillis();
        System.out.println("结束时间"+endTime);
        return endTime;
    }

    @Around("pt2()")
    public void method3(ProceedingJoinPoint pjp) throws Throwable {
        //记录程序当前执行时间（开始时间）
        Long startTime = System.currentTimeMillis();
        System.out.println("开始时间"+startTime);

        //执行目标对象的方法
        Object proceed = pjp.proceed();
        //获取执行签名信息
        Signature signature = pjp.getSignature();
        //通过签名获取执行操作名称(接口名)
        String className = signature.getDeclaringTypeName();
        System.out.println("通过签名获取执行操作名称(接口名)"+className);
        //通过签名获取执行操作名称(方法名)
        String methodName = signature.getName();
        System.out.println("通过签名获取执行操作名称(方法名)"+methodName);

        //记录程序当前执行时间（结束时间）
        Long endTime = System.currentTimeMillis();
        System.out.println("结束时间"+endTime);
        //计算时间差
        Long totalTime = endTime-startTime;
        //输出信息
        System.out.println("执行消耗时间：" + totalTime + "ms");
        System.out.println(System.currentTimeMillis());
    }

}