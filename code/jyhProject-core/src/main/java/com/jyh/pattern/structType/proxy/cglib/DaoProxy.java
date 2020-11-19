package com.jyh.pattern.structType.proxy.cglib;

//import net.sf.cglib.proxy.MethodInterceptor;
//import net.sf.cglib.proxy.MethodProxy;

import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * 使用spring集成的cglib来实现动态代理
 */
public class DaoProxy implements MethodInterceptor {


    /**
     * 在代理的类的方法前后打印两句话
     * @param o: 要进行增强的对象
     * @param method: 要拦截的方法
     * @param objects: 参数列表
     * @param methodProxy: 对方法的代理
     * @return
     * @throws Throwable
     */
    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        System.out.println("Before invoke method");

        /**
         * 表示对o对象的方法调用
         */
        methodProxy.invokeSuper(o,objects);
        System.out.println("After invoke method");
        return o;
    }
}
