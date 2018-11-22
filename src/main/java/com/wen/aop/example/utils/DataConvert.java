package com.wen.aop.example.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author admin
 * @date 2018-11-22 17:10
 */
public class DataConvert {
    private static final Logger logger = LoggerFactory.getLogger(DataConvert.class);


    /**
     * 十进制转化成十六进制
     *
     * @param data
     * @return
     */
    private static String getHexString(int data) {
        return Integer.toHexString(data);
    }

    /**
     * n进制转化成十进制
     *
     * @param data
     * @param n
     * @return
     */
    private static Integer getInt(String data, Integer n) {
        return Integer.parseInt(data, n);
    }

}
