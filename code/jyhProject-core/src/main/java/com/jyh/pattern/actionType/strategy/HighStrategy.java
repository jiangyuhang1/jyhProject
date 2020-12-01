package com.jyh.pattern.actionType.strategy;

/**
 * 具体策略角色
 */
public class HighStrategy implements Strategy{

    @Override
    public double calcBookPrice(double bookPrice) {

        System.out.println("高级会员七折优惠");
        return bookPrice * 0.7;
    }
}
