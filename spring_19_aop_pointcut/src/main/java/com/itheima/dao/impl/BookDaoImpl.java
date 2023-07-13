package com.itheima.dao.impl;

import com.itheima.dao.BookDao;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

import java.util.concurrent.TimeUnit;

@Repository
public class BookDaoImpl implements BookDao {

    public void save() {
        //业务执行万次
        for (int i = 0;i<10000;i++) {
            System.out.println("book dao save ...");
        }
        System.out.println("book dao save ..." + BookDaoImpl.class.getName());
    }

    public void update() throws InterruptedException {
        //休眠方法1
        int i = 0;
        for (int i1 = 0; i1 < 3; i1++) {
            System.out.println("休眠"+i+"秒");
            Thread.currentThread().sleep(i * 1000);
            i+=1;
        }

        //休眠方法2
//        1 TimeUnit.DAYS.sleep(1);//天
//        2 TimeUnit.HOURS.sleep(1);//小时
//        3 TimeUnit.MINUTES.sleep(1);//分
//         TimeUnit.SECONDS.sleep(3);//秒
//        5 TimeUnit.MILLISECONDS.sleep(1000);//毫秒
//        6 TimeUnit.MICROSECONDS.sleep(1000);//微妙
//        7 TimeUnit.NANOSECONDS.sleep(1000);//纳秒
        System.out.println("book dao update ...");
    }
}
