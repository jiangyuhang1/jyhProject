package com.jyh.spring.annotation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

//首字母出现连续的大写字母，生成的bean id将和类名一致
//也可以通过自定义bean生成的id是啥
@Service("zzoo")
public class ZZoo {

    @Autowired
    private Tiger tiger;
    @Autowired
    private Monkey monkey;

    public Tiger getTiger() {
        return tiger;
    }

    public Monkey getMonkey() {
        return monkey;
    }

    public String toString() {
        return tiger + "\n" + monkey;
    }
}
