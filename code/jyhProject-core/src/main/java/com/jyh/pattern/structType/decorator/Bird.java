package com.jyh.pattern.structType.decorator;

/**
 * 具体装饰角色(变化成鸟)
 */
public class Bird extends Change{

    public Bird(GreatSage gs){
        super(gs);
    }

    @Override
    public void move() {
        System.out.println("飞翔");
    }

    public void eat(){
        System.out.println("果实");
    }
}
