package com.itheima.dao.impl;

import com.itheima.dao.BookDao;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

@Repository
public class BookDaoImpl implements BookDao {

    public void save() {
        //业务执行万次
        for (int i = 0;i<10000;i++) {
//            System.out.println("book dao save ...");
        }
        System.out.println("book dao save ..." + BookDaoImpl.class.getName());
    }

    public void update(){
        System.out.println("book dao update ...");
    }
}
