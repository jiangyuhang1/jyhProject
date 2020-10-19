package com.jyh.multiThread.reentrantReadWriteLock;

import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * 测试写锁，写锁是一种互斥锁，同一时间只有一个线程能获得锁
 * 写于写之间存在线程安全问题
 */
public class TestReentrantWriteLock {
    private ReentrantReadWriteLock readWriteLock = new ReentrantReadWriteLock();

    public void method(){
        try{
            readWriteLock.writeLock().lock();
            System.out.println(Thread.currentThread().getName() + " 获得写锁: " + System.currentTimeMillis());
            Thread.sleep(2000);
        }catch (InterruptedException e){
            e.printStackTrace();
        }finally {
            readWriteLock.writeLock().unlock();
        }
    }

    public static void main(String[] args){
        TestReentrantWriteLock testReentrantWriteLock = new TestReentrantWriteLock();
        new Thread(() -> testReentrantWriteLock.method()).start();
        new Thread(() -> testReentrantWriteLock.method()).start();
    }
}
