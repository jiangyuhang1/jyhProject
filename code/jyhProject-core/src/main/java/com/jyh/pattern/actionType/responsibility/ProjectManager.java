package com.jyh.pattern.actionType.responsibility;

/**
 * 具体处理人角色，根据场景判断是由自己处理还是转交给下个处理人处理
 */
public class ProjectManager extends Handler{

    @Override
    public void handlerFeeRequest(boolean isAgree, double fee) {

        /**
         * 项目经理可以审批500以内的经费
         */
        if(fee < 500){
            if(isAgree){
                System.out.println("项目经理同意经费申请，额度为: " + fee );
            }else{
                System.out.println("项目经理不同意经费申请" );
            }
        /**
         * 不在项目经理审批范围内的，传递给下个审核人操作
         */
        }else{
            if(getHandler() != null){
                getHandler().handlerFeeRequest(isAgree,fee);
            }
        }

    }
}
