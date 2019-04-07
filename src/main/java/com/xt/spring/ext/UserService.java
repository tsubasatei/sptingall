package com.xt.spring.ext;

import org.springframework.context.ApplicationEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

/**
 * @author xt
 * @create 2019/4/6 16:47
 * @Desc
 */
@Service
public class UserService {

    @EventListener(classes={ApplicationEvent.class})
    public void listen(ApplicationEvent event){
        System.out.println("UserService。。监听到的事件："+event);
    }
}
