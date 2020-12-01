package com.jyh.pattern.actionType.memento;

/**
 * 发起人角色
 */
public class Originator {

    private String state;

    /**
     * 将发起人角色的状态保存到备忘录对象中
     * @return
     */
    public Memento getMemento(){
        return new Memento(state);
    }

    /**
     * 将发起者角色的状态恢复
     */
    public void restoreMemento(Memento memento){
        this.state = memento.getState();
    }

    public void setState(String state) {
        this.state = state;
        System.out.println("当前状态: " + this.state);
    }

    public String getState() {
        return state;
    }
}
