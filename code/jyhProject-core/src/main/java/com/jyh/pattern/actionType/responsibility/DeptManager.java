package com.jyh.pattern.actionType.responsibility;

/**
 * 具体处理人角色
 */
public class DeptManager extends Handler{


    @Override
    public void handlerFeeRequest(boolean isAgree, double fee) {

        /**
         * 部门经理的审批范围在500和1000块钱的范围之内
         * 超出范围由下个处理人处理
         */
        if(fee >= 500 && fee < 1000){
            if(isAgree){
                System.out.println("部门经理同意经费申请，额度为: " + fee );
            }else{
                System.out.println("部门经理不同意经费申请");
            }
        }else{
            if(getHandler() != null){
                getHandler().handlerFeeRequest(isAgree,fee);
            }
        }
    }
}
