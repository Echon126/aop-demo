package com.wen.aop.example.configuration;

import com.wen.aop.example.aop.SystemLogAspect;
import org.springframework.boot.autoconfigure.AutoConfigureOrder;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * 配置
 * @author admin
 * @date 2018-11-20 15:25
 */
@Configuration
@AutoConfigureOrder(2147483647)
@EnableAspectJAutoProxy(proxyTargetClass = true)
@ConditionalOnClass(SystemLogAspect.class)
@ConditionalOnMissingBean(SystemLogAspect.class)
public class SystemLogAutoConfiguration {

    @Bean
    public SystemLogAspect systemLogAspect() {
        return new SystemLogAspect();
    }
}
