package com.xt.spring;

import com.xt.spring.aop.MathCalculator;
import com.xt.spring.config.MainConfigOfAOP;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Arrays;



public class AOPTest {


    AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(MainConfigOfAOP.class);

    @Test
    public void test() {
        //1、不要自己创建对象
        MathCalculator mathCalculator = applicationContext.getBean(MathCalculator.class);
        mathCalculator.div(1, 0);

    }

}
