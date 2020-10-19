package com.jyh.multiThread.reentrantLock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * ReentrantLock可重入锁，持有的也是对象锁
 * 但是和synchronized持有的对象锁不同，methodB使用synchronized修饰，将异步执行
 * ReentrantLock持有的锁需要手动unlock,由于异常不会释放锁，所以一般使用try catch finally,将unlock在finally中执行
 */
public class TestReentrantLock {
    private Lock lock = new ReentrantLock();

    public void methodA(){
        try {
            lock.lock();
            System.out.println("methodA start " + Thread.currentThread().getName());
            Thread.sleep(5000);
            System.out.println("methodA end " + Thread.currentThread().getName());
        }catch (InterruptedException e){
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }

    public synchronized void methodB(){
        //lock.lock();
        System.out.println("methodB start " + Thread.currentThread().getName());
        System.out.println("methodB end " + Thread.currentThread().getName());
        //lock.unlock();
    }

    public static void main(String[] args){
        TestReentrantLock trl = new TestReentrantLock();
        TestReentrantLock1 trl1 = new TestReentrantLock1(trl);
        TestReentrantLock2 trl2 = new TestReentrantLock2(trl);

        trl1.start();
        trl2.start();
    }
}

class TestReentrantLock1 extends Thread{
    private TestReentrantLock trl;

    public TestReentrantLock1(TestReentrantLock trl){
        this.trl = trl;
    }

    @Override
    public void run() {
        trl.methodA();
    }
}

class TestReentrantLock2 extends Thread{
    private TestReentrantLock trl;

    public TestReentrantLock2(TestReentrantLock trl){
        this.trl = trl;
    }

    @Override
    public void run() {
        trl.methodB();
    }
}
