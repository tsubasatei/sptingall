package com.xt.spring;

import com.xt.spring.bean.Person;
import com.xt.spring.config.MainConfigOfPropertyVaules;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;

import java.util.Arrays;

/**
 * @author xt
 * @create 2019/4/6 7:26
 * @Desc
 */
public class PropertyValuesTest {

    AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(MainConfigOfPropertyVaules.class);
    @Test
    public void test() {
        printBeans(applicationContext);

        System.out.println("--------------");
        Person person = (Person) applicationContext.getBean("person");
        System.out.println(person);

        System.out.println("==============");
        ConfigurableEnvironment environment = applicationContext.getEnvironment();
        String property = environment.getProperty("person.nickName");
        System.out.println(property);
        applicationContext.close();
    }

    private void printBeans(AnnotationConfigApplicationContext applicationContext) {
        String[] definitionNames = applicationContext.getBeanDefinitionNames();
        Arrays.stream(definitionNames).forEach(System.out::println);
    }
}
