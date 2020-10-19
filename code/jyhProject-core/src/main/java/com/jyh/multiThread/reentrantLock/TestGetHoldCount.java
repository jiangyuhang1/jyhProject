package com.jyh.multiThread.reentrantLock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * ReentrantLock是一种可重入的锁
 * getHoldCount()当前线程一条路线调用的lock的次数，不同路不累加
 */
public class TestGetHoldCount {
    private ReentrantLock lock = new ReentrantLock();

    public void methodA(){
        try{
            lock.lock();
            System.out.println("线程获取lock数" + lock.getHoldCount());
            this.methodB();
            Thread.sleep(3000);
            this.methodC();
        }catch (InterruptedException e){
            e.printStackTrace();
        }finally {
            lock.unlock();
        }

    }

    public void methodB(){
        lock.lock();
        System.out.println("线程获取lock数" + lock.getHoldCount());
        lock.unlock();
    }

    public void methodC(){
        lock.lock();
        System.out.println("线程获取lock数" + lock.getHoldCount());
        lock.unlock();
    }

    public static void main(String[] args){
        //匿名内部类
        new Thread(new Runnable() {
            @Override
            public void run() {
                new TestGetHoldCount().methodA();
            }
        }).start();

        //lambda表达式
        //new Thread(() -> new TestGetHoldCount().methodA()).start();
    }
}
