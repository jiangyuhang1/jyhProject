package com.jyh.pattern.structType.proxy.cglib;


import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * 代理模式的提升版，给Dao中不同的方法进行不同的拦截策略
 */
public class DaoAnotherProxy implements MethodInterceptor {

    /**
     * 在方法的前后打印系统时间戳
     * @param o
     * @param method
     * @param objects
     * @param methodProxy
     * @return
     * @throws Throwable
     */
    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        System.out.println("开始时间: " + System.currentTimeMillis());
        /**
         * 调用的是超类中的方法，如果是使用的是invoke,调用的是子类,会循环调用
         */
        methodProxy.invokeSuper(o,objects);

        //methodProxy.invoke(o,objects);
        System.out.println("结束时间: " + System.currentTimeMillis());
        return o;
    }
}
