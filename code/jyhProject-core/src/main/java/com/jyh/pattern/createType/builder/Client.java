package com.jyh.pattern.createType.builder;

/**
 * 建造模式测试类
 * 与工厂和单例模式的区别在于，建造模式不仅仅生产对象，更是对对象的属性一种建造的过程
 * 理解：1.原来对一个对象的属性设置值的时候需要调用其setter方法，客户端需要知道产品的具体细节
 *      2.将一个对象的属性setter过程封装在建造者角色中，通过导演者与客户端打交道
 *      3.可以是客户端在生产对象时不需要知道产品有哪些零件，也不需要知道怎么生产
 *      4.可以将产品的内部表象与产品的生产过程隔离开来
 *
 * 使用场景：1.对象内部属性复杂
 *         2.内部属性存在相互依赖，可能要先给一个属性赋值才可以给其他属性赋值，可以通过导演者角色排列组合
 *         3.内部属性存在其他系统的不易得到的属性
 *
 */
public class Client {

    public static void main(String[] args) {

        Builder builder = new ConcreteBuilder();
        Director director = new Director(builder);
        director.construct();
        Product product = builder.getProduct();
        System.out.println(product.getPart1());
        System.out.println(product.getPart2());
    }
}
