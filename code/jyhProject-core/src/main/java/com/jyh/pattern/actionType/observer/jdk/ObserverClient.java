package com.jyh.pattern.actionType.observer.jdk;

import java.util.Observer;

/**
 * 观察者客户端
 * jdk自带的观察者模式是一种拉模型
 */
public class ObserverClient {

    public static void main(String[] args) {

        Subject subject = new Subject();
        Observer observer = new Watcher(subject);

        subject.setData("start");
        subject.setData("run");
        subject.setData("end");
    }
}
