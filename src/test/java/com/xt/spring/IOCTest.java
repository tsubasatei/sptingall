package com.xt.spring;

import com.xt.spring.bean.Person;
import com.xt.spring.config.MainConfig;
import com.xt.spring.config.MainConfig2;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.core.env.Environment;

import java.util.Arrays;
import java.util.Map;

/**
 * @author xt
 * @create 2019/4/5 16:21
 * @Desc
 */
public class IOCTest {

    ApplicationContext applicationContext = new AnnotationConfigApplicationContext(MainConfig2.class);

    @Test
    public void testImport () {
        printBean(applicationContext);
        //工厂Bean获取的是调用getObject创建的对象
        Object colorFactoryBean = applicationContext.getBean("colorFactoryBean");
        Object colorFactoryBean2 = applicationContext.getBean("&colorFactoryBean");
        System.out.println(colorFactoryBean.getClass().getName());
        System.out.println(colorFactoryBean2.getClass().getName());
        System.out.println(colorFactoryBean == colorFactoryBean2);
    }

    public void printBean(ApplicationContext applicationContext) {
        String[] beanDefinitionNames = applicationContext.getBeanDefinitionNames();
        Arrays.stream(beanDefinitionNames).forEach(System.out::println);
    }

    @Test
    public void test03 () {
        String[] namesForType = applicationContext.getBeanNamesForType(Person.class);
        Arrays.stream(namesForType).forEach(System.out::println);

        Map<String, Person> beansOfType = applicationContext.getBeansOfType(Person.class);
        System.out.println(beansOfType);

        // 获取环境变量的值： Windows 10
        Environment environment = applicationContext.getEnvironment();
        String property = environment.getProperty("os.name");
        System.out.println(property);

    }

    @Test
    public void test02 () {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(MainConfig2.class);
        System.out.println("ioc容器创建完成....");
        Person person = applicationContext.getBean(Person.class);
        Person person1 = (Person) applicationContext.getBean("person");
        System.out.println(person == person1);

    }

    @Test
    public void test() {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(MainConfig.class);
        String[] definitionNames = applicationContext.getBeanDefinitionNames();
        Arrays.stream(definitionNames).forEach(System.out::println);
    }
}
