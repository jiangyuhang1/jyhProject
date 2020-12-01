package com.jyh.pattern.actionType.observer.jdk;

import java.util.Observable;

/**
 * 具体主题角色
 */
public class Subject extends Observable {

    private String data = "";

    public String getData(){
        return data;
    }

    public void setData(String data) {

        if(!this.data.equals(data)){
            this.data = data;
            setChanged();
        }

        /**
         * 通知观察者角色更新
         */
        notifyObservers();
    }
}
