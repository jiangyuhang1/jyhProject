package com.jyh.multiThread.reentrantLock;

import java.util.concurrent.locks.ReentrantLock;

/**
 * isHeldCurrentThread()获取当前线程是否获取到锁
 * isLocked()获取有没有任意线程获取到锁
 */
public class TestIsHeldCurrentThreadAndIsLocked extends ReentrantLock {

    public void methodA(){
        try{
            lock();
            System.out.println(Thread.currentThread().getName() + "线程保持了当前锁?: " + isHeldByCurrentThread());
            System.out.println("有任意线程保持了当前锁?: " + isLocked());
            Thread.sleep(Integer.MAX_VALUE);
        }catch (InterruptedException e){
            e.printStackTrace();
        }finally {
            unlock();
        }
    }

    public void methodB(){
        System.out.println(Thread.currentThread().getName() + "线程保持了当前锁?: " + isHeldByCurrentThread());
        System.out.println("有任意线程保持了当前锁?: " + isLocked());
    }

    public static void main(String[] args){
        final TestIsHeldCurrentThreadAndIsLocked tihctail = new TestIsHeldCurrentThreadAndIsLocked();

        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                tihctail.methodA();
            }
        };

        Runnable runnable1 = new Runnable() {
            @Override
            public void run() {
                tihctail.methodB();
            }
        };

        Thread thread = new Thread(runnable);
        Thread thread1 = new Thread(runnable1);
        thread.start();
        thread1.start();
    }
}
