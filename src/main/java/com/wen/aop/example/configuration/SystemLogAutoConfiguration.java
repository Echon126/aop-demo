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
 *
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

    /**
     *  TODO @ConditionalOnMissingBean 仅当 BeanFactory 中不包含指定的 bean class 和/或 name 时条件匹配
     *  该条件只能匹配到目前为止 application context 已经处理的 bean 定义，因此强烈建议仅在自动配置类上使用此条件。
     *
     */


    /**
     * TODO @ConditionalOnClass
     *
     */

    /**
     * TODO @EnableAspectJAutoProxy
     *
     *
     */

    /**
     * TODO @AutoConfigureOrder
     *
     *
     */
}
