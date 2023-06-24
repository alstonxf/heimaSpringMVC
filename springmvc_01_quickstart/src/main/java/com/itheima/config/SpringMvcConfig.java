package com.itheima.config;


import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

//初始化SpringMVC环境（同Spring环境）
//设定SpringMVC加载对应的bean
@Configuration
@ComponentScan("com.itheima.controller")
public class SpringMvcConfig {
}
