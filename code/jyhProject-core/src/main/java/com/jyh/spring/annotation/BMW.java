package com.jyh.spring.annotation;

import org.springframework.stereotype.Service;

@Service
public class BMW implements Car{
    public String carName() {
        return "BMW car";
    }
}
