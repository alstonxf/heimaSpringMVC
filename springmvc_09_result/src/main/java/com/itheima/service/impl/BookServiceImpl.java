package com.itheima.service.impl;

import com.itheima.dao.BookDao;
import com.itheima.domain.Book;

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
        return bookDao.getById(id);
    }

    // 获取所有书籍
    public List<Book> getAll() {
        System.out.println(bookDao.toString());
        return bookDao.getAll();
    }
}
