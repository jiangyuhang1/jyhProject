package com.jyh.pattern.actionType.responsibility;

/**
 * 具体处理人角色
 */
public class GeneralManager extends Handler{


    @Override
    public void handlerFeeRequest(boolean isAgree, double fee) {

        /**
         * 总经理的可以审批1000之外的
         * 超出范围由下个处理人处理
         */
        if(fee >= 1000){
            if(isAgree){
                System.out.println("总经理同意经费申请，额度为: " + fee );
            }else{
                System.out.println("总经理不同意经费申请");
            }
        }else{
            if(getHandler() != null){
                getHandler().handlerFeeRequest(isAgree,fee);
            }
        }
    }
}
