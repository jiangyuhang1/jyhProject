package com.jyh.pattern.createType.builder;

/**
 * 具体的建造者角色
 * 具体建造一个特定产品的实现类，持有了产品的引用
 * 该类实现了如何建造一个产品的方法
 */
public class ConcreteBuilder implements Builder{

    private Product product = new Product();

    @Override
    public void builderPart1() {
        product.setPart1("id: 123");
    }

    @Override
    public void builderPart2() {
        product.setPart2("name: 垃圾袋");
    }

    @Override
    public Product getProduct() {
        return product;
    }
}
