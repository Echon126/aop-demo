package com.wen.aop.example;

import com.wen.aop.example.data.entity.ResponseData;
import com.wen.aop.example.service.OrderService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.expression.ParseException;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

import javax.naming.NamingException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

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

    @Autowired
    OrderService orderService;

    @Test
    public void testOrderService() throws InterruptedException {
        for (int i = 0; i < 20; i++) {
            orderService.getOrder();
            System.out.println("等待休眠");
        }
    }


    private static final String url = "http://localhost:8089/";


    @Autowired
    RestTemplate restTemplate;

    @Test
    public void testResmplate() {
        ResponseData responseData = new ResponseData("200","调用成功",new Date());
        String message = this.restTemplate.postForObject(url + "entity", responseData, String.class);
        logger.info("调用返回值信息" + message);
    }

    @Test
    public void testMap(){
        Map<String, Object> hashMap = new HashMap<String, Object>();
        hashMap.put("name","zhangsan");
        hashMap.put("age","18");
        ResponseData responseData = new ResponseData("200","调用成功",new Date());
        String message = this.restTemplate.postForObject(url+"map",responseData,String.class);
        logger.info("调用返回信息"+message);
    }
}
