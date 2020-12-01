package com.jyh.pattern.actionType.strategy;

/**
 * 具体策略角色
 */
public class MiddleStrategy implements Strategy{

    @Override
    public double calcBookPrice(double bookPrice) {
        System.out.println("中级会员八折优惠");
        return bookPrice * 0.8;
    }
}
