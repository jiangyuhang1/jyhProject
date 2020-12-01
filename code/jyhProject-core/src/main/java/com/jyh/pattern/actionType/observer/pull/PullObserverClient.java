package com.jyh.pattern.actionType.observer.pull;

/**
 * 拉模型观察者模式客户端
 * 结论:拉模型的重点在于更新观察者的时候，获取的是主题对象，可以根据主题对象，自己决定更新什么信息
 */
public class PullObserverClient {

    public static void main(String[] args) {

        PullAbstractSubject pullAbstractSubject = new PullConcreteSubject("a");
        PullObserver pullObserver = new PullConcreteObserver("b");

        pullAbstractSubject.addPullObserverList(pullObserver);

        pullAbstractSubject.batchUpdateObserver("c");
    }
}
