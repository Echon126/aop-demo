package com.wen.aop.example.utils;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;

/**
 * 格式化成JSON字符串
 * @author admin
 * @date 2018-11-20 15:18
 */
public class JsonUtil {
    public static String toJSONString(Object object){
        return JSON.toJSONString(object, SerializerFeature.DisableCircularReferenceDetect);
    }
}
