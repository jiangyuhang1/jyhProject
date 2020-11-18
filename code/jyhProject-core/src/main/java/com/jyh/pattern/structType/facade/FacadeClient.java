package com.jyh.pattern.structType.facade;

/**
 * 门面模式的优点:1.松耦合，让客户端与子系统之间松耦合
 * 2.简单易用，客户端只要和门面角色打交道就可以轻松调用不同模块的方法，而不需要关注子模块的内部实现
 */
public class FacadeClient {

    public static void main(String[] args) {
        Facade facade = new Facade();

        /**
         * 通过门面角色统一处理不同模块间暴露的方法
         */
        facade.a();
        facade.b();
    }
}
