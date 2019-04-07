package com.xt.spring.bean;

import org.springframework.beans.factory.FactoryBean;

/**
 * @author xt
 * @create 2019/4/5 20:06
 * @Desc
 */
public class ColorFactoryBean implements FactoryBean<Color> {

    //是单例？
    //true：这个bean是单实例，在容器中保存一份
    //false：多实例，每次获取都会创建一个新的bean；
    @Override
    public boolean isSingleton() {
        return false;
    }

    //创建一个Spring定义的FactoryBean
    @Override
    public Color getObject() throws Exception {
        System.out.println("ColorFactoryBean ... getObject ... ");
        return new Color();
    }

    @Override
    public Class<?> getObjectType() {
        return Color.class;
    }
}
