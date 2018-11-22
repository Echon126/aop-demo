package com.wen.aop.example;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.expression.ParseException;
import org.springframework.test.context.junit4.SpringRunner;

import javax.naming.NamingException;
import java.io.IOException;
import java.sql.SQLException;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ApplicationTests {
    private static final Logger logger = LoggerFactory.getLogger(ApplicationTests.class);

    @Test
    public void contextLoads() {
        logger.info("info 级别");
        logger.error("error 级别");
        logger.debug("debug 级别");
        logger.warn("warn 界别");
    }

    @Test
    public void testBeanFactory() throws NamingException, SQLException, ParseException, IOException {

        DefaultListableBeanFactory bf = new DefaultListableBeanFactory();

        loadBeanDefinitions(bf);
/*
        //根据名字从bean工厂获取bean
        Hello hello = (Hello) bf.getBean("hello");
        hello.sayHello();

        Hello2 hello2 = (Hello2) bf.getBean("hello2");
        hello2.sayHello();*/

        /**
         *  工厂模式
         *
         * 不同条件下创建不同实例，用于统一管理bean
         * 不同条件下调用不同工厂方法获取不同场景下的bean
         */
    }


    private void loadBeanDefinitions(DefaultListableBeanFactory bf) {
        XmlBeanDefinitionReader beanDefinitionReader = new XmlBeanDefinitionReader(bf);
        String[] configLocations = new String[]{"beans.xml"};
        if (configLocations != null) {
            beanDefinitionReader.loadBeanDefinitions(configLocations);
        }
    }

}
