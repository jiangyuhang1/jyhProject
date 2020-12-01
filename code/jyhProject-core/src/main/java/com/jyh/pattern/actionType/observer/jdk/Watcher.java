package com.jyh.pattern.actionType.observer.jdk;

import java.util.Observable;
import java.util.Observer;

/**
 * 具体观察者角色
 */
public class Watcher implements Observer {

    /**
     * 通过构造函数将观察者登记到主题中
     * @param o
     */
    public Watcher(Observable o){
        o.addObserver(this);
    }


    @Override
    public void update(Observable o, Object arg) {
        System.out.println("状态方法改变: " + ((Subject)o).getData());
    }
}
