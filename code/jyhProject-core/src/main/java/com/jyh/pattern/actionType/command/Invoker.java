package com.jyh.pattern.actionType.command;

/**
 * 请求者角色
 * 模拟一个不同的按键，可以下达不同的命令
 */
public class Invoker {

    /**
     * 持有抽象命令角色引用，不直接调用接收者方法，抽象成命令动作
     */
    private Command command;

    public Invoker(Command command){
        this.command = command;
    }

    public void invoke(){
        command.command();
    }
}
