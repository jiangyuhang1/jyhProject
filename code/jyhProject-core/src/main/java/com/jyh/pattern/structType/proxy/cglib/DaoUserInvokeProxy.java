package com.jyh.pattern.structType.proxy.cglib;


import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

public class DaoUserInvokeProxy implements MethodInterceptor {
    private Dao dao;

    public DaoUserInvokeProxy(Dao dao){
        this.dao = dao;
    }
    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        System.out.println("开始执行的内容");

        /**
         * 使用invoke方法的写法，代理类必须保持目标对象的引用，否则使用o作为参数造成死循环
         * 这种写法还要知道目标对象，耦合性比使用invokeSuper更强
         * invokeSuper调用的对象是加强版，不要要代理类持有目标对象引用
         */
        Object obj = methodProxy.invoke(dao,objects);
        System.out.println("结束执行的内容");
        return obj;
    }
}
