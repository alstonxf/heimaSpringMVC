package com.itheima;

import com.itheima.dao.impl.BookDaoImpl;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class test {
    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        //回顾反射的使用
        Constructor<BookDaoImpl> declaredConstructor = BookDaoImpl.class.getDeclaredConstructor();
        BookDaoImpl bookDao = declaredConstructor.newInstance();
        bookDao.save();
        Method declaredMethod = BookDaoImpl.class.getDeclaredMethod("save");
        System.out.println(declaredMethod);
        declaredMethod.invoke(bookDao);
    }
}
