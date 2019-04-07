package com.xt.spring.controller;

import com.xt.spring.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

/**
 * @author xt
 * @create 2019/4/5 16:23
 * @Desc
 */
@Controller
public class PersonController {

    @Autowired
    private PersonService personService;
}
