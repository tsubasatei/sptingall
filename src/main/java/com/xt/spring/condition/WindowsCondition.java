package com.xt.spring.condition;

import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.env.Environment;
import org.springframework.core.type.AnnotatedTypeMetadata;

/**
 * 判断是否是 Windows 系统
 *
 * ConditionContext：判断条件能使用的上下文（环境）
 * AnnotatedTypeMetadata：注释信息
 *
 */
public class WindowsCondition implements Condition {
    @Override
    public boolean matches(ConditionContext conditionContext, AnnotatedTypeMetadata annotatedTypeMetadata) {

        // 1. 获取 ioc 使用的 beanfactory
        ConfigurableListableBeanFactory beanFactory = conditionContext.getBeanFactory();
        
        // 2. 获取类加载器
        ClassLoader classLoader = conditionContext.getClassLoader();

        // 3. 获取当前环境信息
        Environment environment = conditionContext.getEnvironment();
        
        // 4. 获取到 bean 定义的注册类
        BeanDefinitionRegistry registry = conditionContext.getRegistry();

        String property = environment.getProperty("os.name");
        if (property.contains("Windows")) {
            return true;
        }
        return false;
    }
}
