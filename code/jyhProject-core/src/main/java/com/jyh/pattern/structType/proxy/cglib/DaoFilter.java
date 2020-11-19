package com.jyh.pattern.structType.proxy.cglib;

import org.springframework.cglib.proxy.CallbackFilter;

import java.lang.reflect.Method;

/**
 * 实现一个代理类对同一个类中不同方法拦截策略不同，需要实现CallbackFilter
 */
public class DaoFilter implements CallbackFilter {

    @Override
    public int accept(Method method) {

        if("select".equals(method.getName())){
            return 0;
        }else if("update".equals(method.getName())){
            return 1;
        }
        return 2;
    }
}
