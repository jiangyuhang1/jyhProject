package com.jyh.pattern.structType.proxy.dynamicProxy;

import java.lang.reflect.Proxy;

/**
 * 动态代理客户端
 * 优点: 1.即使需要代理的接口越来越多也不需要拓展代理角色，因为代理的是Object对象
 *      2.动态代理是一种AOP面向切面编程技术
 * 缺点: 只能代理接口，如果想直接代理类会抛异常IllegalArgumentException:xxx is not an interface
 * 如果想代理类需要使用cglib来实现代理
 */
public class DynamicProxyClient {

    /**
     * 动态代理调用方式
     */

    public static void main(String[] args) {
        DynamicServer ds = new DynamicBaiduServer();

        ClassLoader classLoader = ds.getClass().getClassLoader();
        Class[] intefaces = ds.getClass().getInterfaces();
        DynamicProxy dp = new DynamicProxy(ds);

        /**
         * 生成新的代理对象实例需要传入三个参数，类的加载器，需要代理的接口数组，代理角色对象
         */
        DynamicServer proxy = (DynamicServer) Proxy.newProxyInstance(classLoader,intefaces,dp);


        /**
         * 调用目标对象的方法，就会触发代理角色对象中的invoke方法
         */
        System.out.println(proxy.getTitle("http://news.baidu.com"));
    }
}
