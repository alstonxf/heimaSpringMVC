package com.itheima;

import com.itheima.config.SpringConfig;
import com.itheima.dao.BookDao;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class App {
    public static void main(String[] args) {
        ApplicationContext ctx = new AnnotationConfigApplicationContext(SpringConfig.class);
        BookDao bookDao = ctx.getBean(BookDao.class);
        bookDao.update();
        bookDao.save();//只有当切入点被调用时才会使用代理对象。否则即使切面关联了该切入点和通知也不会使用代理对象。
        System.out.println("验证代理对象"+bookDao.getClass().getName());

    }
}
