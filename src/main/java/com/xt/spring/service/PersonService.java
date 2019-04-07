package com.xt.spring.service;

import com.xt.spring.dao.PersonDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.inject.Inject;

/**
 * @author xt
 * @create 2019/4/5 16:22
 * @Desc
 */
@Service
public class PersonService {

//    @Qualifier("personDao")
//    @Autowired(required = false)
//    @Resource(name = "personDao2")
    @Inject
    private PersonDao personDao;

    public void print() {
        System.out.println(personDao);
    }

    @Override
    public String toString() {
        return "PersonService{" +
                "personDao=" + personDao +
                '}';
    }
}
