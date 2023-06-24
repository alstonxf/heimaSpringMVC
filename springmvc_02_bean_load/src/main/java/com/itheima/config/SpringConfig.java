package com.itheima.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.stereotype.Controller;

@Configuration
//方式1
//@ComponentScan({"com.itheima.service","com.itheima.dao"})

//方式2 includeFilters，excludeFilters,包括与排除要加载的类
@ComponentScan( value = "com.itheima"
        ,
        excludeFilters = @ComponentScan.Filter(
                type = FilterType.ANNOTATION,
                classes = Controller.class
        )
)
public class SpringConfig {

}
