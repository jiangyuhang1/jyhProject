package com.jyh.pattern.actionType.observer.push;

/**
 * 推模型观察者模式客户端
 * 说明:1.观察者模式，又称发布(publish)-订阅(subscribe)模式，模型(model)-视图(view)模式，
 *     源(source)-监听器(listener)，从属模式(Dependents)
 *     2.定义了一对多的依赖关系，让多个观察者同时监听一个主题对象，当主题对象状态发生变化，观察者状态
 *     也全部更新
 *     3.当前是一种推模型的观察者模型，含义是主题对象向观察者对象推送主题对象详细信息，不管观察者需不需要
 */
public class PushObserverClient {

    public static void main(String[] args) {
        PushObserver pushObserver = new PushConcreteObserver("a");
        PushAbstractSubject pushAbstractSubject = new PushConcreteSubject();

        pushAbstractSubject.addPushObserver(pushObserver);
        pushAbstractSubject.batchUpdatePushObserver("b");
    }

}
