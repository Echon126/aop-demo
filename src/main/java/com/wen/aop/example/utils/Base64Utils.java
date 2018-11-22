package com.wen.aop.example.utils;

import org.apache.tomcat.util.codec.binary.Base64;

/**
 * @author admin
 * @date 2018-11-22 10:15
 */
public class Base64Utils {

    public static byte[] decode(final byte[] bytes) {
        return Base64.decodeBase64(bytes);
    }

    /**
     * 二进制数据编码为BASE64字符串
     *
     * @param bytes
     * @return
     * @throws Exception
     */
    public static String encode(final byte[] bytes) {
        return new String(Base64.encodeBase64(bytes));
    }
}
