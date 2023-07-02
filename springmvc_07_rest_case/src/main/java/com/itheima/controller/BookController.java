package com.itheima.controller;

import com.itheima.domain.Book;
import org.springframework.web.bind.annotation.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;


@RestController //相当于@Controller+@ResponseBody
@RequestMapping("/books") //定义请求路径前缀 ，如果没有设置，默认是""的
public class BookController {

    @PostMapping
    //设定请求方法的返回值为字符串类型，并返回自定义json数据
    public String save(@RequestBody Book book){
        System.out.println(LocalDateTime.now()+" book save ..." + book);
        return "{'module':'book save success'}";
    }

    @GetMapping
    public List<Book> getAll(){
        //模拟数据
        ArrayList<Book> booksList = new ArrayList<>();

        Book book1 = new Book();
        book1.setType("计算机");
        book1.setName("SpringMVC入门教程");
        book1.setDescription("小试牛刀");
        booksList.add(book1);

        Book book2 = new Book();
        book2.setType("计算机");
        book2.setName("SpringMVC实战教程");
        book2.setDescription("一代宗师");
        booksList.add(book2);

        Book book3 = new Book();
        book3.setType("计算机");
        book3.setName("SpringMVC实战教程-进阶");
        book3.setDescription("一代宗师");
        booksList.add(book3);

        System.out.println(LocalDateTime.now() + " book getAll ..." + booksList);
        return booksList;
    }
}
