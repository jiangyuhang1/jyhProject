package com.jyh.multiThread.reentrantReadWriteLock;

import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * 测试读写锁，读写锁是互斥锁，同一时间多个线程只有一个线程能获得锁
 * 读与写之间存在线程安全问题
 */
public class TestReentrantReadWriteLock {
    private ReentrantReadWriteLock readWriteLock = new ReentrantReadWriteLock();

    public void methodA(){
        try{
            readWriteLock.readLock().lock();
            System.out.println(Thread.currentThread().getName() + " 获得读锁: " + System.currentTimeMillis());
            Thread.sleep(1000);
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            readWriteLock.readLock().unlock();
        }
    }

    public void methodB(){
        try{
            readWriteLock.writeLock().lock();
            System.out.println(Thread.currentThread().getName() + " 获得写锁: " + System.currentTimeMillis());
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            readWriteLock.writeLock().unlock();
        }
    }

    public static void main(String[] args) throws Exception{
        TestReentrantReadWriteLock testReentrantReadWriteLock = new TestReentrantReadWriteLock();

        new Thread(() -> testReentrantReadWriteLock.methodA()).start();
        Thread.sleep(1000);
        new Thread(() -> testReentrantReadWriteLock.methodB()).start();
    }
}
