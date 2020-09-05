package com.jyh.spring.annotation;

import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class Zoo1 {
    //@Resource注解默认by name ，name是其他bean的id
    @Resource(name = "tiger")
    private Tiger tiger;

    //与@Autowired的区别在于一个是,前者属于java,后者属于spring，后者默认装配方式是by type
    @Resource(type = Monkey.class)
    private Monkey monkey;

    public String toString()
    {
        return tiger + "\n" + monkey;
    }
}
