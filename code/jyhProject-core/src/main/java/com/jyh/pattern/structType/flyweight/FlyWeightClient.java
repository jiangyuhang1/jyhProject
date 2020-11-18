package com.jyh.pattern.structType.flyweight;

/**
 * 1.享元模式类似于String字符串常量的创建模式，相同的字符串不会重新new,会从重常量池中拿
 * 2.享元模式可以减少系统创建对象的数量，但是需要根据内蕴标识和外蕴标识判断，无形之中也造成系统的复杂
 */
public class FlyWeightClient {

    public static void main(String[] args) {

        FlyWeight fw1 = FlyWeightFactory.factory("a");
        FlyWeight fw2 = FlyWeightFactory.factory("b");
        FlyWeight fw3 = FlyWeightFactory.factory("a");

        fw1.operation("c");
        fw2.operation("c");
        fw3.operation("c");

        System.out.println(fw1 == fw3);
    }
}
