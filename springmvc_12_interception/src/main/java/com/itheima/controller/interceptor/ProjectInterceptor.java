package com.itheima.controller.interceptor;

import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
public class ProjectInterceptor implements HandlerInterceptor {
    //前置
    @Override
    //request:请求对象
    //response:响应对象
    //handler:被调用的处理器对象，本质上是一个方法对象，对反射技术中的Method对象进行了再包装
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        String contentType = request.getHeader("Content-Type");
//        System.out.println(handler.getClass());
        HandlerMethod hm = (HandlerMethod) handler;//可以c'zuo
        System.out.println("preHandle...");
        return true;//如果返回false会中止原始操作。
    }

    //后置
    @Override
    //modelAndView:如果处理器执行完成具有返回结果，可以读取到对应数据与页面信息，并进行调整。
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        System.out.println("postHandle...");
    }

    @Override
    //ex 可以拿到原程序异常
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        System.out.println("afterCompletion...");
    }
}

