package com.xt.spring.dao;

import org.springframework.stereotype.Repository;

/**
 * @author xt
 * @create 2019/4/5 16:23
 * @Desc
 */
@Repository
public class PersonDao {
    private String lable = "1";

    @Override
    public String toString() {
        return "PersonDao{" +
                "lable='" + lable + '\'' +
                '}';
    }

    public String getLable() {
        return lable;
    }

    public void setLable(String lable) {
        this.lable = lable;
    }
}
