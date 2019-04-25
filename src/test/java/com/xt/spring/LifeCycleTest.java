package com.xt.spring;

import com.xt.spring.config.MainConfigOfLifeCycle;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author xt
 * @create 2019/4/5 20:39
 * @Desc
 */
public class LifeCycleTest {

    //1、创建ioc容器
    AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(MainConfigOfLifeCycle.class);

    @Test
    public void test () {
        System.out.println("容器创建完成。。。");
//        Dog dog = applicationContext.getBean(Dog.class);
//        Cat cat = applicationContext.getBean(Cat.class);
//        Car bean = applicationContext.getBean(Car.class);

        // 关闭容器
        applicationContext.close();
    }
}
