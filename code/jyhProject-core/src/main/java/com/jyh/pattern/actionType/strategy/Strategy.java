package com.jyh.pattern.actionType.strategy;

/**
 * 抽象策略角色
 * 将具体策略角色的行为抽象出来
 * 不同
 */
public interface Strategy {

    double calcBookPrice(double bookPrice);
}
