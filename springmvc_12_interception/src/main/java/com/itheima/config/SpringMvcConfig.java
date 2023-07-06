package com.itheima.config;


import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.List;

//初始化SpringMVC环境（同Spring环境）
//设定SpringMVC加载对应的bean
@Configuration //注意 被Configuration注释的类会被扫描，同时其bean也会被加载。
@ComponentScan( value = {"com.itheima.controller","com.itheima.config"})
@EnableWebMvc //重点：启用JSON数据类型的自动转换等功能
public class SpringMvcConfig {
}
