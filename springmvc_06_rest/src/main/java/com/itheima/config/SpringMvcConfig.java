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
@ComponentScan( value = "com.itheima.controller")
@EnableWebMvc //重点：启用JSON数据类型的自动转换
public class SpringMvcConfig {
}


//或者手动重写转换器
//@Configuration
//@ComponentScan("com.itheima.controller")
//@EnableWebMvc
////为了，你需要配置一个适当的消息转换器。在你的配置类中，可以添加以下代码来配置MappingJackson2HttpMessageConverter作为JSON消息转换器：
////通过重写configureMessageConverters方法，并在其中添加MappingJackson2HttpMessageConverter实例，你将添加了一个默认配置的JSON消息转换器。
////        这样配置之后，Spring MVC将能够自动将请求中的JSON数据绑定到方法参数，并将响应对象自动转换为JSON格式进行返回。
////        请确保在配置类中正确导入WebMvcConfigurer接口，并将其实现类标记为@Override，以确保正确重写configureMessageConverters方法。
////        如果你有其他自定义的消息转换器或其他配置需求，可以根据具体情况进行相应的调整和扩展。
//public class SpringMvcConfig implements WebMvcConfigurer {
//
//    @Override
//    public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
//        converters.add(new MappingJackson2HttpMessageConverter());
//    }
//}