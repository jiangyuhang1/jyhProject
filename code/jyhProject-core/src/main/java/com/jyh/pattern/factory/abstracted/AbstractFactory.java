package com.jyh.pattern.factory.abstracted;

import com.jyh.pattern.factory.Milk;

/**
 * 抽象工厂模式抽象类
 */
public abstract class AbstractFactory {

    public abstract Milk getMilk();
}
