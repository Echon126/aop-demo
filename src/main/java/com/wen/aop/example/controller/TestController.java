package com.wen.aop.example.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

/**
 * @author admin
 * @date 2018-11-21 11:04
 */
@RestController
public class TestController {
    private static final Logger logger = LoggerFactory.getLogger(TestController.class);
    String str[] ={"1","2","3"};
    List<String> list = Arrays.asList(str);
    @GetMapping("/test")
    public String test()  {
        logger.info("---------------testAOP---------------");
        return "hello world";
    }

}
