package com.jyh.pattern.actionType.strategy;

/**
 * 具体策略角色
 */
public class NormalStrategy implements Strategy{

    @Override
    public double calcBookPrice(double bookPrice) {
        System.out.println("初级会员没有折扣");
        return bookPrice;
    }
}
