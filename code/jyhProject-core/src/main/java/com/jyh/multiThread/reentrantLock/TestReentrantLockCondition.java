package com.jyh.multiThread.reentrantLock;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 使用ReentrantLock和Condition可以实现通知等待模型
 * 与wait和notify使用需要放在synchronized代码块一样，await和signal需要在lock中使用，使用完需要unlock
 * await使用释放对象锁
 */
public class TestReentrantLockCondition {
    private Lock lock = new ReentrantLock();
    private Condition condition = lock.newCondition();

    public void methodA(){
        try{
            lock.lock();
            System.out.println("method A start " + Thread.currentThread().getName());
            Thread.sleep(3000);
            condition.await();
            System.out.println("method A end " + Thread.currentThread().getName());
        }catch (InterruptedException e){
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }

    public void methodB(){
        lock.lock();
        System.out.println("method B " + Thread.currentThread().getName());
        condition.signal();
        lock.unlock();
    }

    public static void main(String[] args) throws Exception{
        TestReentrantLockCondition trlc = new TestReentrantLockCondition();
        TestReentrantLockCondition1 trlc1 = new TestReentrantLockCondition1(trlc);
        TestReentrantLockCondition2 trlc2 = new TestReentrantLockCondition2(trlc);
        trlc1.start();
        trlc2.start();
        //Thread.sleep(3000);
        //trlc.methodB();

    }
}

class TestReentrantLockCondition1 extends Thread{
    private TestReentrantLockCondition trlc;

    public TestReentrantLockCondition1(TestReentrantLockCondition trlc){
        this.trlc = trlc;
    }

    @Override
    public void run() {
        trlc.methodA();
    }
}

class TestReentrantLockCondition2 extends Thread{
    private TestReentrantLockCondition trlc;

    public TestReentrantLockCondition2(TestReentrantLockCondition trlc){
        this.trlc = trlc;
    }

    @Override
    public void run() {
        trlc.methodB();
    }
}
