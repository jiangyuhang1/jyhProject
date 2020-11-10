package com.jyh.pattern.createType.builder;

/**
 * 抽象建造角色
 * 约定了需要建造的产品的标准
 * 定义了一个产品不同零件是怎么构造的
 */
public interface Builder {

    void builderPart1();

    void builderPart2();

    Product getProduct();
}
