package com.jyh.pattern.structType.proxy.cglib;

import org.springframework.cglib.proxy.Enhancer;

/**
 * cglib动态代理调用通用写法
 */
public class CglibClient {

    public static void main(String[] args) {

        DaoProxy dp =new DaoProxy();
        Enhancer enhancer = new Enhancer();

        /**
         * 需要代理的类
         */
        enhancer.setSuperclass(Dao.class);

        /**
         * 回调的代理类对象
         */
        enhancer.setCallback(dp);

        /**
         * 设置不拦截构造器中的函数
         */
        enhancer.setInterceptDuringConstruction(false);

        /**
         * 该创建Dao对象的代码，也会对构造方法中的方法进行拦截操作
         */
        Dao dao = (Dao) enhancer.create();
        dao.select();
        dao.update();
    }
}
