package com.jyh.pattern.structType.proxy.cglib;

import org.springframework.cglib.proxy.Enhancer;

public class DaoUserInvokeClient {

    public static void main(String[] args) {

        Dao dao = new Dao();
        DaoUserInvokeProxy daoUserInvokeProxy = new DaoUserInvokeProxy(dao);

        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(Dao.class);
        enhancer.setCallback(daoUserInvokeProxy);
        enhancer.setInterceptDuringConstruction(false);

        Dao dao1 = (Dao) enhancer.create();
        dao1.update();
        dao1.select();
    }
}
