package com.wen.aop.example.utils;

/**
 * @author admin
 * @date 2018-11-22 10:15
 */
public class Test {
    public static void main(String[] args) {
        String str="aHR0cDovLzEwLjE5My4yNDEuMTM2OjgwOTAvYjJiL3BvcnRhbC9hdXRoLmh0bT91c2VySUQ9dHY5MzIwNTE2MjIxMSZ1c2VyVG9rZW49dHY5MzIwNTE2MjIxMSZjb250ZW50SUQ9MTAwMDgwMDEwMDAwMDMwMTIwMTgxMTA3MTUwNTEyMTM=";
        String url = new String(Base64Utils.decode(str.getBytes()));
        System.out.println("xxxxx"+url);
    }
}
