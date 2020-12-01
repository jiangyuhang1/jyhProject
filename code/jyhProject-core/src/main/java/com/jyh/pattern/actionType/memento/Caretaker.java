package com.jyh.pattern.actionType.memento;

/**
 * 负责人角色
 */
public class Caretaker {

    private Memento memento;

    /**
     * 获取备忘录角色
     * @return
     */
    public Memento getMemento() {
        return memento;
    }

    /**
     * 保存备忘录角色
     * @param memento
     */
    public void setMemento(Memento memento) {
        this.memento = memento;
    }
}
