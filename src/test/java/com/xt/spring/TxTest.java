package com.xt.spring;

import com.xt.spring.config.MainConfigOfTx;
import com.xt.spring.tx.UserService;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author xt
 * @create 2019/4/6 7:26
 * @Desc
 */
public class TxTest {

    AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(MainConfigOfTx.class);
    @Test
    public void test() {
        UserService userService = applicationContext.getBean(UserService.class);
        userService.insertUser();
        applicationContext.close();
    }

}
