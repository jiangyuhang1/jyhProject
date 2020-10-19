package com.jyh.multiThread.reentrantReadWriteLock;

import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * 测试读写锁，读锁是一种共享锁，允许多个线程同时获得锁
 * 读与读不涉及线程安全问题，加速效率
 */
public class TestReentrantReadLock {
    private ReentrantReadWriteLock readWriteLock = new ReentrantReadWriteLock();

    public void method(){
        try{
            readWriteLock.readLock().lock();
            System.out.println(Thread.currentThread().getName() + " 获得读锁: " + System.currentTimeMillis());
            Thread.sleep(2000);
        }catch (InterruptedException e){
            e.printStackTrace();
        }finally {
            readWriteLock.readLock().unlock();
        }
    }

    public static void main(String[] args){
        TestReentrantReadLock testReentrantReadLock = new TestReentrantReadLock();
        new Thread(() -> testReentrantReadLock.method()).start();
        new Thread(() -> testReentrantReadLock.method()).start();
    }
}
