package com.jyh.pattern.actionType.responsibility;

/**
 * 责任链模式，抽象处理人接口
 * 模拟申请项目经费，根据费用的不同，由不同的领导审批，申请单在具体处理人角色之间流转
 */
public abstract class Handler {

    /**
     * 持有自身引用，可以引用自身
     */
    private Handler handler;

    public Handler getHandler() {
        return handler;
    }

    public void setHandler(Handler handler) {
        this.handler = handler;
    }

    public abstract void handlerFeeRequest(boolean isAgree,double fee);
}
