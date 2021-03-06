package com.wen.aop.example.controller.test;

import com.wen.aop.example.annotation.SystemControllerLog;
import com.wen.aop.example.annotation.SystemServiceLog;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author admin
 * @date 2018-11-20 15:35
 */
@RestController
public class SimpleComtroller {

    /**
     * 测试AOP实现日志输出
     *
     * @return
     */
    @SystemControllerLog
    @RequestMapping(value = "/messgae", method = RequestMethod.GET)
    public String getMessage() {
        return "hello world";
    }


}
