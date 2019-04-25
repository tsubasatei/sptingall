package com.xt.mvc.handler;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author xt
 * @create 2019/4/5 12:09
 * @Desc
 */
@ControllerAdvice
public class SpringMVCTestExceptionHandler {
    @ExceptionHandler({ArithmeticException.class})
    public ModelAndView handleArithmeticException(Exception ex) {
        System.out.println("出错了：" + ex);
        ModelAndView mv = new ModelAndView("error");
        mv.addObject("ex",ex);
        return mv;
    }
}
