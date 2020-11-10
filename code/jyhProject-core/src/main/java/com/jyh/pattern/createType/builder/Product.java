package com.jyh.pattern.createType.builder;

/**
 * 建造模式中的产品角色
 * 需要建造具体的产品，包含了该产品的所有属性
 */
public class Product {

    private String part1;

    private String part2;

    public String getPart1() {
        return part1;
    }

    public String getPart2() {
        return part2;
    }

    public void setPart1(String part1) {
        this.part1 = part1;
    }

    public void setPart2(String part2) {
        this.part2 = part2;
    }
}
