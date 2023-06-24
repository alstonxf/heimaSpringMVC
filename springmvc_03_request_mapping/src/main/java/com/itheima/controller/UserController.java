package com.itheima.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.time.LocalDateTime;

//创建SpringMVC控制器类（等同于Servlet功能）

@Controller //类注解，设定SpringMVC的核心控制器bean
@RequestMapping("/user") //定义请求路径前缀 ，如果没有设置，默认是""的
public class UserController {

    @RequestMapping("/save") //前缀加上/save 即 /user/save
    @ResponseBody
    //设定请求方法的返回值为字符串类型，并返回自定义json数据
    public String save(){
        System.out.println(LocalDateTime.now()+" user save ...");
        return "{'info':'springmvc'}";
    }

    @RequestMapping("/delete")
    @ResponseBody
    public String delete(){
        System.out.println(LocalDateTime.now() + "user delete ...");
        return "{'module':'user delete'}";
    }

}
