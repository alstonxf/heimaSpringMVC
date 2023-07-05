package com.itheima.controller;

import com.itheima.exception.BusinessException;
import com.itheima.exception.SystemException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ProjectExceptionAdvice {
    @ExceptionHandler(SystemException.class) //异常处理器
    public Result doSystemException(SystemException ex){
        //记录日志
        //发送消息给运维
        //发送邮件给开发人员
        return new Result(ex.getCode(),null,ex.getMessage());
    }

    @ExceptionHandler(BusinessException.class) //异常处理器
    public Result doSystemException(BusinessException ex){
        //记录日志
        //发送消息给运维
        //发送邮件给开发人员
        return new Result(ex.getCode(),null,ex.getMessage());
    }

    @ExceptionHandler(Exception.class) //异常处理器
    public Result doException(Exception e){
        //记录日志
        //发送消息给运维
        //发送邮件给开发人员
        System.out.println("发现异常"+e);
        return new Result(Code.SYSTEM_UNKNOWN_ERROR,null,"未知异常"+e);
    }
}
