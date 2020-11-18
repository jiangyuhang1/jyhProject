package com.jyh.pattern.structType.decorator;

/**
 * 具体抽象构件角色(猴子)
 */
public class Monkey implements GreatSage{

    @Override
    public void move() {
        System.out.println("跳跃");
    }
}
