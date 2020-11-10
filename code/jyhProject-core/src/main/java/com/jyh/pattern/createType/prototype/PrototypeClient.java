package com.jyh.pattern.createType.prototype;

/**
 * 原型模式测试类
 */
public class PrototypeClient {

    public static void main(String[] args) {
        ConcretePrototype cp = new ConcretePrototype();

        for(int i = 0; i < 5; i++){
            ConcretePrototype clonecp = (ConcretePrototype) cp.clone();
            clonecp.show();
        }
    }
}
