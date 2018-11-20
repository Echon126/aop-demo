package com.wen.aop.example.utils;

import java.util.UUID;

/**
 * 存取线程ID
 * @author admin
 * @date 2018-11-20 15:15
 */
public class ThreadUtil {
    private static final ThreadLocal<String> threadLocal = new ThreadLocal<>();

    public static String getThreadId() {
        String threadId = threadLocal.get();
        if (null == threadId) {
            threadId = UUID.randomUUID().toString();
            threadLocal.set(threadId);
        }
        return threadId;
    }
}
