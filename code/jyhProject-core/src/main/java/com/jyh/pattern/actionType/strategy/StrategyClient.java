package com.jyh.pattern.actionType.strategy;

/**
 * 策略模式客户端
 * 概要:1.策略模式核心不在于如何实现算法，在于如何组织算法，抽象出来，在不同场景调用不同的算法
 *     2.经常见到的是把不同的策略类中公有的行为抽象出来，本身还有其他行为，因此顶层是抽象类
 *     3.可以避免使用多层if else,可以把公共部分写在抽象策略角色内，避免代码重复
 *     缺点：1.客户端必须知道所有的策略类，来决定使用哪种策略
 *          2.场景过多，策略类也会增加很多
 */
public class StrategyClient {

    public static void main(String[] args) {

        Strategy strategy1 = new NormalStrategy();
        Strategy strategy2 = new MiddleStrategy();
        Strategy strategy3 = new HighStrategy();

        StrategyContext sc1 = new StrategyContext(strategy1);
        StrategyContext sc2 = new StrategyContext(strategy2);
        StrategyContext sc3 = new StrategyContext(strategy3);

        System.out.println(sc1.quote(10.00));
        System.out.println(sc2.quote(10.00));
        System.out.println(sc3.quote(10.00));
    }
}
