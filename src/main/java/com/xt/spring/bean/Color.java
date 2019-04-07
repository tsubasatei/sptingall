package com.xt.spring.bean;

/**
 * @author xt
 * @create 2019/4/5 18:53
 * @Desc
 */
public class Color {

    private Car car;

    public Color() {

    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    @Override
    public String toString() {
        return "Color{" +
                "car=" + car +
                '}';
    }
}
