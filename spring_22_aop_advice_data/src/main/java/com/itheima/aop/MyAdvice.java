package com.itheima.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
@Aspect
public class MyAdvice {
    @Pointcut("execution(* com.itheima.dao.BookDao.findName(..))")
    private void pt(){}
    @Pointcut("execution(* com.itheima.dao.BookDao.findName1(..))")
    private void pt1(){}

    //JoinPoint：用于描述切入点的对象，必须配置成通知方法中的第一个参数，可用于获取原始方法调用的参数
    @Before("pt()")
    public void before(JoinPoint jp) {
        Object[] args = jp.getArgs();
        System.out.println("before 获取参数 "+ Arrays.toString(args));
        System.out.println("before advice ..." );
    }

    @After("pt()")
    public void after(JoinPoint jp) {
        Object[] args = jp.getArgs();
        System.out.println("after 获取参数 "+ Arrays.toString(args));
        System.out.println("after advice ...");
    }

    //ProceedingJoinPoint：专用于环绕通知，是JoinPoint子类，可以实现对原始方法的调用
    @Around("pt()")
    public Object around(ProceedingJoinPoint pjp) {
        Object[] args = pjp.getArgs();
        System.out.println("Around环绕通知 获取参数" + Arrays.toString(args));
        args[0] = 666;
        args[1] = "修改后的参数值";
        Object ret = null;
        try {
            //修改传入参数为666
            System.out.println("修改传入参数为" + Arrays.toString(args));
            ret = pjp.proceed(args);//如果环绕通知和其他通知共同作用在同一个切点上，环绕通知相当于包在外面一层，当走到pjp.proceed时会开始执行befor，after等其他通知。
            System.out.println("返回结果为" + ret);
        } catch (Throwable t) {
            t.printStackTrace();
        }
        return ret;
    }

    //设置返回后通知获取原始方法的返回值，要求returning属性值必须与方法形参名相同
    @AfterReturning(value = "pt()",returning = "ret")
    public void afterReturning(JoinPoint jp,String ret) {
        System.out.println("afterReturning advice ..."+ret);
    }

    @AfterReturning(value = "pt1()",returning = "ret")
    public void afterReturning(JoinPoint jp,Object ret) {//测试了返回Object 替换 Integer
        System.out.println("afterReturning advice ..."+ret);
    }

    //设置抛出异常后通知获取原始方法运行时抛出的异常对象，要求throwing属性值必须与方法形参名相同
    @AfterThrowing(value = "pt()",throwing = "t")
    public void afterThrowing(Throwable t) {
        System.out.println("afterThrowing advice ..."+t);
    }
}
