package com.jyh.pattern.actionType.command;

/**
 * 命令模式接收者角色
 * 模拟一个录音机功能
 */
public class Receiver {

    public void play(){
        System.out.println("开始播放");
    }

    public void stop(){
        System.out.println("暂停播放");
    }

    public void back(){
        System.out.println("倒退");
    }
}
