package com.wen.aop.example.utils;

import org.springframework.util.ClassUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author admin
 * @date 2018-11-27 11:18
 */
public class Path {

    //通过用servlet获取绝对路径
    public static String getAbsolutePath(HttpServletRequest request, HttpServletResponse response) {
        return request.getSession().getServletContext().getRealPath("/");
    }

    //springboot获取项目的绝对路径
    public static String getAbsolutePath() {
        String path = ClassUtils.getDefaultClassLoader().getResource("").getPath();
        return path;
    }


}
