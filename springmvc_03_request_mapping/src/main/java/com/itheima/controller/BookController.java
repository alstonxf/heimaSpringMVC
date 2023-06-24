package com.itheima.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.time.LocalDateTime;

@Controller
public class BookController {


    @RequestMapping("/book/save")
    @ResponseBody //方法注解，设置当前控制器方法响应内容为当前返回值，无需解析
    //设定请求方法的返回值为字符串类型，并返回自定义json数据
    public String save(){
        System.out.println(LocalDateTime.now()+" book save ...");
        return "{'module':'book save'}";
    }
}
