package com.xt.spring;

import com.xt.spring.bean.Yellow;
import com.xt.spring.config.MainConfigOfProfile;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Arrays;

/**
 * Profile：
 * 		Spring为我们提供的可以根据当前环境，动态的激活和切换一系列组件的功能；
 *
 * 开发环境、测试环境、生产环境；
 * 数据源：(/A)(/B)(/C)；
 *
 *
 * @Profile：指定组件在哪个环境的情况下才能被注册到容器中，不指定，任何环境下都能注册这个组件
 *
 * 1）、加了环境标识的bean，只有这个环境被激活的时候才能注册到容器中。默认是default环境
 * 2）、写在配置类上，只有是指定的环境的时候，整个配置类里面的所有配置才能开始生效
 * 3）、没有标注环境标识的bean在，任何环境下都是加载的；
 */
public class ProfileTest {

    //1、使用命令行动态参数: 在虚拟机参数位置加载 -Dspring.profiles.active=test
    //2、代码的方式激活某种环境；
    AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
    @Test
    public void test() {
        //1、创建一个applicationContext
        //2、设置需要激活的环境
//        applicationContext.getEnvironment().setActiveProfiles("test", "dev");
        applicationContext.getEnvironment().setActiveProfiles("dev");

        //3、注册主配置类
        applicationContext.register(MainConfigOfProfile.class);

        //4、启动刷新容器
        applicationContext.refresh();
        String[] definitionNames = applicationContext.getBeanDefinitionNames();
        Arrays.stream(definitionNames).forEach(System.out::println);

        Yellow bean = applicationContext.getBean(Yellow.class);
        System.out.println(bean);
        applicationContext.close();
    }

}
