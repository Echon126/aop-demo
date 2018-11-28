package com.wen.aop.example.data.repositories;

import java.util.Arrays;
import java.util.List;

/**
 * @author admin
 * @date 2018-11-28 11:04
 */
public class Router {
    private static List<String> list = Arrays.asList("/page/home/index3","/main", "/page/forms/form", "/page/elements/general_elements","/page/elements/media_gallery");

    public static List<String> Routers() {
        return list;
    }
}
