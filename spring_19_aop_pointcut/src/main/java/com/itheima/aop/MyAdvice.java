package com.itheima.aop;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
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
    @Pointcut("execution(* *.save1(..))")
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
//
//    @After("pt()")
//    public void method3(Long startTime,Long endTime){
//        //计算时间差
//        Long totalTime = endTime-startTime;
//        //输出信息
//        System.out.println("执行万次消耗时间：" + totalTime + "ms");
//        System.out.println(System.currentTimeMillis());
//    }

}