package com.itheima.service.impl;

import com.itheima.controller.Code;
import com.itheima.dao.BookDao;
import com.itheima.domain.Book;

import com.itheima.exception.BusinessException;
import com.itheima.exception.SystemException;
import com.itheima.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookServiceImpl implements BookService {

    @Autowired
    private BookDao bookDao;

    // 保存书籍
    public boolean save(Book book) {
        bookDao.save(book);
        return true;
    }

    // 更新书籍
    public boolean update(Book book) {
        bookDao.update(book);
        return true;
    }

    // 删除书籍
    public boolean delete(Integer id) {
        bookDao.delete(id);
        return true;
    }

    // 根据ID获取书籍
    public Book getById(Integer id) {
        if(id == 1){
            throw new BusinessException(Code.BUSINESS_ERROR,"查询的图书的id是1，测试为传入信息错误");
        }

        //将可能出现的异常进行包装，转换成自定义异常
        try{
            int i =1/0;//模拟一个异常
        }catch (ArithmeticException e){
            throw new SystemException(Code.SYSTEM_TIMEOUT_ERROR,"服务器访问超时，请重试！",e);
        }

        return bookDao.getById(id);
    }

    // 获取所有书籍
    public List<Book> getAll() {
        System.out.println(bookDao.toString());
        return bookDao.getAll();
    }
}
