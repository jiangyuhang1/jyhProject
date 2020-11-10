package com.jyh.pattern.createType.builder;

/**
 * 导演者角色
 * 不持有产品引用，持有的是建造角色的引用，与客户端打交道
 * 协调在客户端需要的时候调用具体的建造者对象去建造对象
 * 定义了一个产品是怎么装配的，在建造者角色建造完不同的零件之后，是按照怎样的组合或者顺序建造出这个对象
 */
public class Director {

    private Builder builder;

    public Director(Builder builder){
        this.builder = builder;
    }

    public void construct(){
        builder.builderPart1();
        builder.builderPart2();
    }
}
