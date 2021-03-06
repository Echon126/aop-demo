package com.wen.aop.example.controller.test;

import com.wen.aop.example.service.OrderService;
import com.wen.aop.example.utils.Path;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Arrays;
import java.util.List;

/**
 * @author admin
 * @date 2018-11-21 11:04
 */
@RestController
public class TestController {
    private static final Logger logger = LoggerFactory.getLogger(TestController.class);
    String str[] = {"1", "2", "3"};
    List<String> list = Arrays.asList(str);

    @Autowired
    OrderService orderService;


    @GetMapping("/test")
    public String test() throws Exception {
        logger.info("---------------testAOP---------------");
        throw new Exception();
        //return "hello world";
    }



    @RequestMapping("/testPool")
    protected String str() throws InterruptedException {
        orderService.getOrder();
        return "sssssssssssss";
    }

    @RequestMapping(value="/path")
    public String getAbsolutePath(HttpServletRequest request, HttpServletResponse response){
       String path= Path.getAbsolutePath();
       return path;
    }

}
