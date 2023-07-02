package com.itheima.controller;

import com.itheima.domain.User;
import com.itheima.domain.User2;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

//创建SpringMVC控制器类（等同于Servlet功能）

@Controller //类注解，设定SpringMVC的核心控制器bean
public class UserController {

    @RequestMapping("/commonParam")
    @ResponseBody
    public String commonParam(String name, int age){
        System.out.println(LocalDateTime.now() + "user commonParam ...");
        System.out.println("普通参数传递 name ==> " + name);
        System.out.println("普通参数传递 age ==> " + age);
        return "{'module':'commonParam'}";
    }

    //普通参数：请求参数名与形参名不同, 可以通过@RequestParam(前端传的参数名)
    @RequestMapping("/commonParamDifferentName")
    @ResponseBody
    public String commonParamDifferentName(@RequestParam(name = "name") String userName, @RequestParam("age") int age){
        System.out.println(LocalDateTime.now() + "userName commonParam ...");
        System.out.println("普通参数传递 userName ==> " + userName);
        System.out.println("普通参数传递 age ==> " + age);
        return "{'module':'common Param Different Name'}";
    }

    //POJO参数
    @RequestMapping("/pojoParam")
    @ResponseBody
    public String pojoParam(User user){
        System.out.println("pojo参数传递 user ===> " + user);
        return "{'module':'pojo param'}";
    }

    //POJO参数[嵌套POJO数据] POJO中有引用类型
    @RequestMapping("/pojoContainPojoParam")
    @ResponseBody
    public String pojoContainPojoParam(User2 user2){
        System.out.println("pojo参数传递 user2 ===> " + user2);
        return "{'module':'pojoContainPojoParam param'}";
    }

    // 数组参数
    @RequestMapping("arrayParam")
    @ResponseBody
    public String arrayParam(String[] likes){
        System.out.println("数组参数传递 likes ==> " + Arrays.toString(likes));
        return "{'module':'array param'}";
    }

    // 集合参数 需要手动指示 LIST 是@RequestParam ，因为如果没加@RequestParam，框架会误以为List是一个引用类型，而去创建其对象。
    @RequestMapping("listParam")
    @ResponseBody
    public String listParam(@RequestParam List likes){
        System.out.println("集合参数传递 likes ==> " + likes);
        return "{'module':'list param'}";
    }

    // 集合参数 json 格式
    @RequestMapping("/listParamForJson")
    @ResponseBody
    public String listParamForJson(@RequestBody List<String> likes){
        System.out.println("list common(json)参数传递 list ==> " + likes);
        return "{'module':'list common for json param'}";
    }

    // POJO参数 json 格式
    @RequestMapping("/pojoParamForJson")
    @ResponseBody
    public String pojoParamForJson(@RequestBody User2 user){
        System.out.println("pojo参数传递 user ===> " + user);
        return "{'module':'pojoParamForJson'}";
    }

    // 集合参数 json 格式
    @RequestMapping("/listPojoParamForJson")
    @ResponseBody
    public String listPojoParamForJson(@RequestBody List<User> likes){
        System.out.println("list pojo(json)参数传递 list ==> " + likes);
        return "{'module':'list pojo for json param'}";
    }

    // 日期参数
    @RequestMapping("/dateParam")
    @ResponseBody
    public String dateParam(Date date,@DateTimeFormat(pattern = "yyyy-MM-dd") Date date1,@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss") Date date2){
        System.out.println("参数传递 date ==> " + date);
        System.out.println("参数传递 date1 ==> " + date1);
        System.out.println("参数传递 date2 ==> " + date2);
        return "{'module':'date param'}";
    }
}
