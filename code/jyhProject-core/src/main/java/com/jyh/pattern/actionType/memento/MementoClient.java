package com.jyh.pattern.actionType.memento;

/**
 * 备忘录模式客户端
 * 概要: 1.发起者角色负责生成备忘录角色并且将本身对象的状态存储在备忘录角色中
 *      2.负责人角色用于统一管理备忘录角色
 */
public class MementoClient {

    public static void main(String[] args) {
        Originator originator = new Originator();
        Caretaker caretaker = new Caretaker();

        originator.setState("On");

        /**
         * 将发起人角色状态保存到备忘录角色中，并将备忘录角色放在负责人中统一管理
         */
        caretaker.setMemento(originator.getMemento());

        originator.setState("Off");

        /**
         * 从负责人角色中将备忘录角色获取出来，用来恢复发起人角色状态
         */
        originator.restoreMemento(caretaker.getMemento());
        System.out.println("恢复后状态: " + originator.getState());
    }
}
