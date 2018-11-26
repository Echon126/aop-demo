package com.wen.aop.example.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

/**
 * @author admin
 * @date 2018-11-23 11:38
 */
@Service
public class OrderService {
    private static Logger logger = LoggerFactory.getLogger(OrderService.class);

    @Async
    public void getOrder() {
        //Thread.sleep(5000);
        logger.info("getOrder current thread is" + Thread.currentThread());
    }
}
