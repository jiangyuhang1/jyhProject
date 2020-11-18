package com.jyh.pattern.structType.facade;

/**
 * 门面模式中的门面角色
 */
public class Facade {

    ModuleA a = new ModuleA();
    ModuleB b = new ModuleB();

    public void a(){
        /**
         * 调用子模块中暴露的方法
         */
        a.a1();
    }

    public void b(){
        b.b1();
    }
}
