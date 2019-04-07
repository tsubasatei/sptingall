package com.xt.spring.bean;

import org.springframework.stereotype.Component;

/**
 * @author xt
 * @create 2019/4/5 20:29
 * @Desc
 */
@Component
public class Car {

    public Car() {
        System.out.println("car constructor");
    }

    public void init() {
        System.out.println("car init");
    }

    public void destroy() {
        System.out.println("car destroy");
    }
}
