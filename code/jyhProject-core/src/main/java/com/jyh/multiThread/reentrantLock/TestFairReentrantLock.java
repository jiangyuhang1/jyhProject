package com.jyh.multiThread.reentrantLock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 可以通过ReentrantLock的构造方法来实现公平锁和非公平锁
 * 公平锁的含义是对于多个线程获取同一个对象锁的时候，获取锁的顺序和线程的启动顺序一致
 */
public class TestFairReentrantLock {
    private Lock lock = new ReentrantLock(true);

    public void methodA(){
        try{
            lock.lock();
            System.out.println(Thread.currentThread().getName() + " 获得锁");
        }finally {
            lock.unlock();
        }
    }

    public static void main(String[] args){
        TestFairReentrantLock tfrl = new TestFairReentrantLock();
        TestFairReentrantLock1[] trfl1 = new TestFairReentrantLock1[10];
        for(int i = 0; i < 10; i++)
            trfl1[i] = new TestFairReentrantLock1(tfrl);
        for(int i = 0; i < 10; i++)
            trfl1[i].start();
    }
}

class TestFairReentrantLock1 extends Thread{
    private TestFairReentrantLock tfrl;

    public TestFairReentrantLock1(TestFairReentrantLock tfrl){
        this.tfrl = tfrl;
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + " 运行了");
        tfrl.methodA();
    }
}
