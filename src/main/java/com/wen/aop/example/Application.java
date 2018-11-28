package com.wen.aop.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EnableAutoConfiguration
public class Application {
    //启动的时候注意，由于我们在controller中注入了RestTemplate所以启动的时候需要实例化一个该对象的实例
    @Autowired
    private RestTemplateBuilder builder;

    //通过RestTemplateBuilder来实例化RestTemplate对象，Spring默认已经注入了RestTemplateBuilder对象
    @Bean
    public RestTemplate restTemplate() {
        return builder.build();
    }

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    //查看springboot在启动的时候为我们注入了哪些bean
    /*@Bean
    public CommandLineRunner commandLineRunner(ApplicationContext context) {
        return args -> {

            System.out.println("Let's inspect the beans provided by Spring Boot:");

            String[] beanNames = context.getBeanDefinitionNames();
            Arrays.sort(beanNames);
            for (String beanName : beanNames) {
                System.out.println("springboot启动=时自动注入的类 "+beanName);
            }

        };

    }*/
}
