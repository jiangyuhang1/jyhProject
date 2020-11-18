package com.jyh.pattern.structType.decorator;

/**
 * 具体装饰角色(变化成鱼)
 */
public class Fish extends Change{

    public Fish(GreatSage gs){
        super(gs);
    }

    @Override
    public void move() {
        System.out.println("游泳");
    }

    /**
     *具体装饰角色自己的行为
     */
    public void eat(){
        System.out.println("虾米");
    }
}
