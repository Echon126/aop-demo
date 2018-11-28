package com.wen.aop.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author admin
 * @date 2018-11-27 14:39
 */
@Controller
public class PageController {

    @RequestMapping(value = "/index")
    public String PageIndex() {
        return "index";
    }

    @RequestMapping(value = "/page")
    public String PageContentControler(String param) {
        return param;
    }
}
