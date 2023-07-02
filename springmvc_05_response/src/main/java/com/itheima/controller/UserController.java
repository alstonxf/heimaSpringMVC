package com.itheima.controller;

import com.itheima.domain.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

//创建SpringMVC控制器类（等同于Servlet功能）

@Controller //类注解，设定SpringMVC的核心控制器bean
public class UserController {

    @RequestMapping("/toJumpPage") //前缀加上/save 即 /user/save
    //响应页面/跳转页面
    public String toJumpPage(){
        System.out.println(LocalDateTime.now()+" 跳转页面 ...");
        return "page.jsp";
    }

    @RequestMapping("/toText")
    @ResponseBody
    public String toText(){
        System.out.println(LocalDateTime.now() + " 返回纯文本数据 ...");
        return "response text";
    }

    //响应POJO对象
    @RequestMapping("/toJsonPOJO")
    @ResponseBody
    public User toJsonPOJO(){
        System.out.println(LocalDateTime.now() + " 返回json对象数据");
        User user = new User();
        user.setName("itcast");
        user.setAge(15);
        return user;
    }

    //响应POJO集合对象
    @RequestMapping("/toJsonList")
    @ResponseBody
    public List<User> toJsonList(){
        System.out.println(LocalDateTime.now() + " 返回json集合数据");
        User user1 = new User();
        user1.setName("use1名字");
        user1.setAge(15);

        User user2 = new User();
        user2.setName("use2名字");
        user2.setAge(15);

        ArrayList<User> userList = new ArrayList<User>();
        userList.add(user1);
        userList.add(user2);

        return userList;
    }

}
