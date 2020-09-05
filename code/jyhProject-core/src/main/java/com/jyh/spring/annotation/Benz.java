package com.jyh.spring.annotation;

import org.springframework.stereotype.Service;

@Service
public class Benz implements Car{
    public String carName() {
        return "Benz car";
    }
}
