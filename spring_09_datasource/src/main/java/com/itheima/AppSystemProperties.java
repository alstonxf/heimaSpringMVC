package com.itheima;

import java.util.Map;

public class AppSystemProperties {
    public static void main(String[] args) throws Exception{
        Map<String, String> env = System.getenv();
        System.out.println(env);
    }
}
