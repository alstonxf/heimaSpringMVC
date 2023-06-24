package com.itheima.controller;

import jdk.nashorn.internal.parser.JSONParser;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.time.LocalDateTime;

//创建SpringMVC控制器类（等同于Servlet功能）

@Controller //类注解，设定SpringMVC的核心控制器bean
public class UserController {

    @RequestMapping("/save")//方法注解，设置当前控制器方法请求访问路径，在本案例中就是用/save关联了save方法。
    @ResponseBody //方法注解，设置当前控制器方法响应内容为当前返回值，无需解析
    //设定请求方法的返回值为字符串类型，并返回自定义json数据
    public String save(){
        System.out.println(LocalDateTime.now()+" user save ...");
        return "{'info':'springmvc'}";
    }

}
