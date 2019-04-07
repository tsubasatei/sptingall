package com.xt.spring;

import com.xt.spring.bean.Person;
import com.xt.spring.config.MainConfig;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Arrays;

/**
 * @author xt
 * @create 2019/4/5 15:47
 * @Desc
 */
public class MainTest {

    public static void main(String[] args) {
        // 配置文件方式
//        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("beans.xml");
//        Person person = (Person) applicationContext.getBean("person");
//        System.out.println(person);

        // 注解驱动 方式
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(MainConfig.class);
        Person person = applicationContext.getBean(Person.class);
        System.out.println(person);

        Person person01 = (Person) applicationContext.getBean("person");
        System.out.println(person01);

        System.out.println("--------");

        String[] names = applicationContext.getBeanNamesForType(Person.class);
        Arrays.stream(names).forEach(System.out::println);

    }
}
