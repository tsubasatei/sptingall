package com.xt.spring.bean;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.EmbeddedValueResolverAware;
import org.springframework.stereotype.Component;
import org.springframework.util.StringValueResolver;

/**
 * @author xt
 * @create 2019/4/5 18:53
 * @Desc
 */
@Component
public class Red implements ApplicationContextAware, BeanNameAware, EmbeddedValueResolverAware {

    private ApplicationContext applicationContext;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        System.out.println("传入的ioc：" + applicationContext);
        this.applicationContext = applicationContext;
    }

    @Override
    public void setBeanName(String s) {
        System.out.println("当前Bean的名字：" + s);
    }

    @Override
    public void setEmbeddedValueResolver(StringValueResolver stringValueResolver) {
        String resolveStringValue = stringValueResolver.resolveStringValue("你好，${os.name}, 我是#{30*60}");
        System.out.println("解析的字符串是：" + resolveStringValue);
    }
}
