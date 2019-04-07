package com.xt.spring;

import com.xt.spring.bean.Boss;
import com.xt.spring.bean.Car;
import com.xt.spring.bean.Color;
import com.xt.spring.bean.Red;
import com.xt.spring.config.MainConfigOfAutowired;
import com.xt.spring.dao.PersonDao;
import com.xt.spring.service.PersonService;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author xt
 * @create 2019/4/6 7:26
 * @Desc
 */
public class AutowiredTest {

    AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(MainConfigOfAutowired.class);
    @Test
    public void test() {
        PersonService personService = applicationContext.getBean(PersonService.class);
        System.out.println(personService);
        PersonDao personDao = applicationContext.getBean(PersonDao.class);
        System.out.println(personDao);
        System.out.println("==============");

        Boss boss = applicationContext.getBean(Boss.class);
        System.out.println(boss);
        Car car = applicationContext.getBean(Car.class);
        System.out.println(car);

        System.out.println("==============");
        Color color = applicationContext.getBean(Color.class);
        System.out.println(color);

        System.out.println("==============");

        System.out.println(applicationContext);
        applicationContext.close();
    }

}
