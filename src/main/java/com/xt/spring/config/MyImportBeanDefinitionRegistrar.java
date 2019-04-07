package com.xt.spring.config;

import com.xt.spring.bean.Raimbow;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.type.AnnotationMetadata;

/**
 * AnnotationMetadata：当前类的注解信息
 * BeanDefinitionRegistry:BeanDefinition注册类；
 * 		把所有需要添加到容器中的bean；调用
 * 		BeanDefinitionRegistry.registerBeanDefinition手工注册进来
 */
public class MyImportBeanDefinitionRegistrar implements ImportBeanDefinitionRegistrar {
    @Override
    public void registerBeanDefinitions(AnnotationMetadata annotationMetadata, BeanDefinitionRegistry beanDefinitionRegistry) {
        boolean blue = beanDefinitionRegistry.containsBeanDefinition("com.xt.spring.bean.Blue");
        boolean red = beanDefinitionRegistry.containsBeanDefinition("com.xt.spring.bean.Red");
        if (blue && red) {
            //指定Bean定义信息；（Bean的类型，Bean Scope信息。。。）
            BeanDefinition beanDefinition = new RootBeanDefinition(Raimbow.class);
            //注册一个Bean，指定bean名
            beanDefinitionRegistry.registerBeanDefinition("rainbow", beanDefinition);
        }
    }
}
