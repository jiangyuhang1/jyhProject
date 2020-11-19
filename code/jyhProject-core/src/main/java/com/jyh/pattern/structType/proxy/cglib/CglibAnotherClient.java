package com.jyh.pattern.structType.proxy.cglib;

import org.springframework.cglib.proxy.Callback;
import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.NoOp;

/**
 * 给代理对象中不同方法不同的拦截策略测试类
 * 不同方法指定不同的策略用法:
 *     1.首先要指定多个代理类，用于不同方法的拦截策略
 *     2.要实现CallFilter接口，对于不同的方法会返回一个int值，指定在Callback数组中到底是选择哪个代理类
 *     3.Noop.INSTANCE用于指定一个空的Callback，不想对一些方法进行拦截，可以指定到这个位置
 */
public class CglibAnotherClient {

    public static void main(String[] args) {
        DaoProxy daoProxy = new DaoProxy();
        DaoAnotherProxy daoAnotherProxy = new DaoAnotherProxy();
        DaoFilter daoFilter = new DaoFilter();

        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(Dao.class);

        Callback[] callbacks = new Callback[]{daoProxy,daoAnotherProxy, NoOp.INSTANCE};
        enhancer.setCallbacks(callbacks);
        enhancer.setCallbackFilter(daoFilter);

        Dao dao = (Dao) enhancer.create();

        dao.update();
        dao.select();
        dao.delete();
    }
}
