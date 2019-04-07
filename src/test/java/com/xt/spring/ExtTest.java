package com.xt.spring;

import com.xt.spring.bean.Blue;
import com.xt.spring.bean.Car;
import com.xt.spring.config.MainConfigOfTx;
import com.xt.spring.ext.ExtConfig;
import com.xt.spring.tx.UserService;
import org.junit.Test;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author xt
 * @create 2019/4/6 7:26
 * @Desc
 */
public class ExtTest {

    AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(ExtConfig.class);
    @Test
    public void test() {
        applicationContext.publishEvent(new ApplicationEvent(new String("我发布的事件")) {
        });
        applicationContext.close();
    }

}
