package com.wen.aop.example.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.ThreadPoolExecutor;

/**
 * @author admin
 * @date 2018-11-23 11:23
 */
@Configuration
@EnableAsync
public class TaskExecutePool {
    private final Integer threadCount = 4;


    @Bean
    public ThreadPoolTaskExecutor taskPool() {
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        //核心线程数，正常情况下情况下运行的线程数
        executor.setCorePoolSize(threadCount);

        //当核心线程数都在跑任务，还有多余的任务或存到此处
        executor.setQueueCapacity(6);

        //最大线程数，如果queueCapacity存满了，就会启动更多的线程，知道线程数达到maxPoolSize
        //如果还有任务，则根据拒绝策略进行处理
        executor.setMaxPoolSize(8);

        //线程空闲时：空闲线程时间超过的会被销毁（不包括核心线程数）
        executor.setKeepAliveSeconds(60);

        //线程名前缀
        executor.setThreadNamePrefix("taskPool");

        //拒绝策略：不在新线程中执行任务，而是有调用者所在的线程执行
        executor.setRejectedExecutionHandler(new ThreadPoolExecutor.CallerRunsPolicy());

        //直接抛出异常拒绝
        //executor.setRejectedExecutionHandler(new ThreadPoolExecutor.AbortPolicy());
        executor.initialize();
        return executor;
    }


}
