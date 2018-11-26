package com.wen.aop.example.utils;

import org.aopalliance.intercept.MethodInvocation;
import org.aspectj.lang.JoinPoint;
import org.springframework.aop.ProxyMethodInvocation;
import org.springframework.aop.interceptor.ExposeInvocationInterceptor;

import java.io.File;
import java.nio.file.FileSystemNotFoundException;

/**
 * @author admin
 * @date 2018-11-22 10:15
 */
public class Test {
    public static void main(String[] args) {
        String str = "aHR0cDovLzEwLjE5My4yNDEuMTM2OjgwOTAvYjJiL3BvcnRhbC9hdXRoLmh0bT91c2VySUQ9dHY5MzIwNTE2MjIxMSZ1c2VyVG9rZW49dHY5MzIwNTE2MjIxMSZjb250ZW50SUQ9MTAwMDgwMDEwMDAwMDMwMTIwMTgxMTA3MTUwNTEyMTM=";
        String url = new String(Base64Utils.decode(str.getBytes()));
        System.out.println("xxxxx" + url);
    }


    private static void getFile(String fileName) {
        File file = new File(fileName);

        if (!file.exists()) {
            throw new FileSystemNotFoundException("file is not exists");
        }
        //TODO throw 是语句抛出一个异常，一般是在代码块的内部，当程序中出现某种逻辑错误时有程序员主要抛出某种特定类型的异常
        //TODO throws  当某个方法可能会抛出某种异常时用于throws 声明可能抛出的异常，然后交给上层调用它的方法程序处理
    }


}
