package com.jyh.multiThread.reentrantLock;


import java.util.concurrent.locks.ReentrantLock;

/**
 * getQueueLength(),获取等待对象锁的线程数，是个估计值
 * isFair判断是否是公平锁，ReentrantLock构造函数默认非公平锁
 */
public class TestGetQueueLengthAndIsFair {
    private ReentrantLock lock = new ReentrantLock();

    public void methodA(){
        try {
            lock.lock();
            System.out.println("method A start " + Thread.currentThread().getName());
            System.out.println("is fair: " + lock.isFair());
            Thread.sleep(100000000);
        }catch (InterruptedException e){
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }

    public static void main(String[] args){
        final TestGetQueueLengthAndIsFair tgqlaif = new TestGetQueueLengthAndIsFair();

        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                tgqlaif.methodA();
            }
        };

        Thread[] threads = new Thread[10];
        for(int i = 0; i < 10; i++)
            threads[i] = new Thread(runnable);
        for(int i = 0; i < 10; i++)
            threads[i].start();

        System.out.println("有" + tgqlaif.lock.getQueueLength() + "线程在等待获得锁");
    }

}
