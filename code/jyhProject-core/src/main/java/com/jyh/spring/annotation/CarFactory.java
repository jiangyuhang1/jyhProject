package com.jyh.spring.annotation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class CarFactory {
    //装配的接口有两个实现类的话，不指定注入哪一个会报错
    @Autowired
    //使用@Qualifier的注解可以指定注入哪一个实现类，里面是类名，不是bean的id
    @Qualifier("BMW")
    private Car car;

    public String toString() {
        return car.carName();
    }
}
