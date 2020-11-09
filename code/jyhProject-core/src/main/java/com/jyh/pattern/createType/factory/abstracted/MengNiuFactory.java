package com.jyh.pattern.factory.abstracted;

import com.jyh.pattern.factory.MengNiu;
import com.jyh.pattern.factory.Milk;

/**
 * 具体生产蒙牛的工厂
 */
public class MengNiuFactory extends AbstractFactory {

    @Override
    public Milk getMilk() {
        return new MengNiu();
    }
}
