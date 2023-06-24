package com.itheima.config;


import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.stereotype.Controller;

//初始化SpringMVC环境（同Spring环境）
//设定SpringMVC加载对应的bean
@Configuration //注意 被Configuration注释的类会被扫描，同时其bean也会被加载。
@ComponentScan( value = "com.itheima.controller")
public class SpringMvcConfig {
}
