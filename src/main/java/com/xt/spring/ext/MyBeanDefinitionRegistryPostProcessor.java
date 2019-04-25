package com.xt.spring.ext;

import com.xt.spring.bean.Car;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.AbstractBeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.BeanDefinitionRegistryPostProcessor;
import org.springframework.stereotype.Component;

/**
 * @author xt
 * @create 2019/4/6 15:53
 * @Desc
 */
@Component
public class MyBeanDefinitionRegistryPostProcessor implements BeanDefinitionRegistryPostProcessor {
    //BeanDefinitionRegistry Bean定义信息的保存中心，以后BeanFactory就是按照BeanDefinitionRegistry里面保存的每一个bean定义信息创建bean实例；
    @Override
    public void postProcessBeanDefinitionRegistry(BeanDefinitionRegistry beanDefinitionRegistry) throws BeansException {
        System.out.println("MyBeanDefinitionRegistryPostProcessor...postProcessBeanDefinitionRegistry...bean的数量："
                + beanDefinitionRegistry.getBeanDefinitionCount());
        //RootBeanDefinition beanDefinition = new RootBeanDefinition(Car.class);
        AbstractBeanDefinition beanDefinition = BeanDefinitionBuilder.rootBeanDefinition(Car.class).getBeanDefinition();
        beanDefinitionRegistry.registerBeanDefinition("hello", beanDefinition);
    }


    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory configurableListableBeanFactory) throws BeansException {

        System.out.println("MyBeanDefinitionRegistryPostProcessor...postProcessBeanFactory...bean的数量："
                + configurableListableBeanFactory.getBeanDefinitionCount());
    }
}
