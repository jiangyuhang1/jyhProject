package com.jyh.pattern.actionType.strategy;

/**
 * 上下文角色，持有策略角色引用
 */
public class StrategyContext {

    private Strategy strategy;

    public StrategyContext(Strategy strategy){
        this.strategy = strategy;
    }

    public double quote(double bookPrice){
        return strategy.calcBookPrice(bookPrice);
    }
}
