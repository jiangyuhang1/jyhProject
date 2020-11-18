package com.jyh.pattern.structType.decorator;

/**
 * 抽象装饰角色(七十二变化)
 */
public class Change implements GreatSage{

    private GreatSage gs;

    public Change(GreatSage gs){
        this.gs = gs;
    }

    @Override
    public void move() {
        gs.move();
    }
}
