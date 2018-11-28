package com.wen.aop.example.controller.page;

import com.wen.aop.example.data.repositories.Router;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @author admin
 * @date 2018-11-27 14:39
 */
@Controller
public class PageController {

    //加载主页
    @RequestMapping({"/", "index"})
    public String PageIndex() {
        return "index";
    }

    //路由跳转
    @RequestMapping(value = "/page")
    public String PageContentControler(String param) {
        return param;
    }

    //加载路由列表
    @ResponseBody
    @RequestMapping(value = "/routers")
    public List<String> loadRouters() {
        return Router.Routers();
    }
}
