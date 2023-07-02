package com.itheima.controller;

import com.itheima.domain.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

//创建SpringMVC控制器类（等同于Servlet功能）

@Controller //类注解，设定SpringMVC的核心控制器bean
@RequestMapping("/users") //定义请求路径前缀 ，如果没有设置，默认是""的
public class UserController {

//    @RequestMapping(value = "/users",method = RequestMethod.POST) //前缀加上/save 即 /user/save
    @RequestMapping(method = RequestMethod.POST) //前缀加上/save 即 /user/save
    @ResponseBody
    //设定请求方法的返回值为字符串类型，并返回自定义json数据
    public String save(@RequestBody User user){
        System.out.println(LocalDateTime.now()+" user save ..." + user);
        return "{'info':'user save'}";
    }

    @RequestMapping(value = "/{id}",method = RequestMethod.DELETE)
    @ResponseBody
    public String delete(@PathVariable Integer id){
        System.out.println(LocalDateTime.now() + " user delete ..." + id);
        return "{'module':'user delete'}";
    }

    @RequestMapping(method = RequestMethod.PUT)
    @ResponseBody
    public String update(@RequestBody User user){
        System.out.println(LocalDateTime.now() + " user update ..." + user);
        return "{'module':'user update'}";
    }

    @RequestMapping(value = "/{id}",method = RequestMethod.GET)
    @ResponseBody
    public String getById(@PathVariable Integer id){
        System.out.println(LocalDateTime.now() + " user getById ..." + id);
        return "{'module':'user getById'}";
    }

    @RequestMapping(method = RequestMethod.GET)
    @ResponseBody
    public String getAll(){
        System.out.println(LocalDateTime.now() + " user getAll ...");
        return "{'module':'user getAll'}";
    }
}
