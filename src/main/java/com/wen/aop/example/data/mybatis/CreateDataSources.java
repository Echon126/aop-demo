package com.wen.aop.example.data.mybatis;

import javax.annotation.Resources;
import java.io.InputStream;
import java.time.LocalDate;

/**
 * @author admin
 * @date 2018-12-24 16:13
 */
public class CreateDataSources {
    private static final String  resources = "mybatis-config.xml";

    public static void initSources(){
    LocalDate localDate = LocalDate.now();
    int year = localDate.getYear();
    int month = localDate.getMonthValue();
    int day = localDate.getDayOfMonth();

        System.out.println(localDate);

    }

    public static void main(String[] args) {
        initSources();
    }


}
