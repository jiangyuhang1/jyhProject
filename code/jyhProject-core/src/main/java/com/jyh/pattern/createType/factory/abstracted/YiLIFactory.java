package com.jyh.pattern.factory.abstracted;

import com.jyh.pattern.factory.Milk;
import com.jyh.pattern.factory.YiLI;

/**
 * 具体生产伊利的工厂
 */
public class YiLIFactory extends AbstractFactory {

    @Override
    public Milk getMilk() {
        return new YiLI();
    }
}
