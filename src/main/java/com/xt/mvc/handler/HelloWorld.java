package com.xt.mvc.handler;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * 注意：
 * 1. 首先要在类的前面添加“Controller”注解，表示是spring的控制器，这里会写一个方法hello（）
 * 2. hello方法上方有一个@RequestMapping， 是用于匹配请求的路径，
 * 3. 返回modelAndView给前端控制器，让它根据setView的要求选择视图解析器传入模型数据进行渲染
 *
 */
@Controller
public class HelloWorld {

    /**
     *  1. 使用RequestMapping注解来映射请求的URL
     *  2. 返回值会通过视图解析器解析为实际的物理视图, 对于 InternalResourceViewResolver 视图解析器，会做如下解析
     *     通过 prefix+returnVal+suffix 这样的方式得到实际的物理视图，然后会转发操作
     *      "/WEB-INF/views/success.jsp"
     *
     * @return
     */
    @GetMapping("/hello")
    public String hello() {
        System.out.println("hello");
        return "success";
    }
}
