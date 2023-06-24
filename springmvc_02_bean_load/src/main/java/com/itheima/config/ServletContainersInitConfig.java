package com.itheima.config;

import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;
import org.springframework.web.servlet.support.AbstractDispatcherServletInitializer;

//将tomcat容器与springMVC容器关联，使得tomcat容器可以访问到springMVC容器。体现在代码上就是WebApplicationContext容器
//初始化Servlet容器，加载SpringMVC环境，并设置SpringMVC请求拦截的路径
// AbstractDispatcherServletInitializer 类是SpringMVC提供的快速初始化Web3.0容器的抽象类，提供了3个接口方法供用户实现
//public class ServletContainersInitConfig extends AbstractDispatcherServletInitializer {
//
//    //创建Servlet容器时，加载springMVC对应的bean并放入WebApplicationContext对象范围中，而WebApplicationContext的作用范围是ServletContext范围，即整个web容器范围。
//    protected WebApplicationContext createServletApplicationContext() {
//        //加载容器初始化的配置类
//        AnnotationConfigWebApplicationContext ctx = new AnnotationConfigWebApplicationContext();
//        ctx.register(SpringMvcConfig.class);
//        return ctx;
//    }
//
//    //设定 SpringMVC对应的请求映射路径，设置为/表示拦截所有请求，任何请求都将转入到SpringMVC进行处理
//    protected String[] getServletMappings() {
//        return new String[]{"/"};//所有请求归MVC处理
//    }
//
//    //如果创建Servlet容器时需要加载非SpringMVC对应的bean，使用当前方法进行，使用方式同createServletApplicationContext()
//    protected WebApplicationContext createRootApplicationContext() {
//        //加载容器初始化的配置类
//        AnnotationConfigWebApplicationContext ctx = new AnnotationConfigWebApplicationContext();
//        ctx.register(SpringConfig.class);
//        return ctx;
//    }
//}

//或者第二种简化开发的写法
public class ServletContainersInitConfig extends AbstractAnnotationConfigDispatcherServletInitializer{

    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class[]{SpringMvcConfig.class};
    }

    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class[]{SpringConfig.class};
    }

    @Override
    protected String[] getServletMappings() {
        return new String[]{"/"};
    }
}


