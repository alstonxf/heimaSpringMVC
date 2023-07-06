package com.itheima.controller;

import com.itheima.domain.Book;
import org.springframework.web.bind.annotation.*;
import java.time.LocalDateTime;

//创建SpringMVC控制器类（等同于Servlet功能）
//@Controller //类注解，设定SpringMVC的核心控制器bean
//@ResponseBody //也可以写在方法上,如果类下面所有方法都带ResponseBody就可以写在类上面。

@RestController //相当于@Controller+@ResponseBody
@RequestMapping("/books") //定义请求路径前缀 ，如果没有设置，默认是""的
public class BookController {

//    @RequestMapping(method = RequestMethod.POST) //前缀加上/save 即 /book/save
    @PostMapping
    //设定请求方法的返回值为字符串类型，并返回自定义json数据
    public String save(@RequestBody Book book){
        System.out.println(LocalDateTime.now()+" book save ..." + book);
        return "{'info':'book save'}";
    }

//    @RequestMapping(value = "/{id}",method = RequestMethod.DELETE)
    @DeleteMapping("/{id}")
    public String delete(@PathVariable Integer id){
        System.out.println(LocalDateTime.now() + " book delete ..." + id);
        return "{'module':'book delete'}";
    }

//    @RequestMapping(method = RequestMethod.PUT)
    @PutMapping
    public String update(@RequestBody Book book){
        System.out.println(LocalDateTime.now() + " book update ..." + book);
        return "{'module':'book update'}";
    }

//    @RequestMapping(value = "/{id}",method = RequestMethod.GET)
    @GetMapping("/{id}")
    public String getById(@PathVariable Integer id){
        System.out.println(LocalDateTime.now() + " book getById ..." + id);
        return "{'module':'book getById'}";
    }

//    @RequestMapping(method = RequestMethod.GET)
    @GetMapping
    public String getAll(){
        System.out.println(LocalDateTime.now() + " book getAll ...");
        return "{'module':'book getAll'}";
    }
}
