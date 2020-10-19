package com.jyh.multiThread.synchronization;

//测试两个线程同时访问一个对象，即使不同的线程调用不同的同步代码块，也存在阻塞
//synchronized块获得的是一个对象锁，换句话说，synchronized块锁定的是整个对象。
public class TestSynchronizedMutexBlock {

    public void methodA(){
        synchronized (this){
            try {
                System.out.println(Thread.currentThread().getName() + "-" + System.currentTimeMillis());
                Thread.sleep(2000);
                System.out.println(Thread.currentThread().getName() + "-" + System.currentTimeMillis());
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }
    }

    public void methodB(){
        synchronized (this){
            System.out.println(Thread.currentThread().getName() + "-" + System.currentTimeMillis());
            System.out.println(Thread.currentThread().getName() + "-" + System.currentTimeMillis());
        }
    }

    public synchronized void methodC(){
        System.out.println(Thread.currentThread().getName());
    }

    public static void main(String[] args) throws Exception{
        TestSynchronizedMutexBlock tsmb = new TestSynchronizedMutexBlock();
        TestSynchronizedMutexBlock1 tsmb1 = new TestSynchronizedMutexBlock1(tsmb);
        TestSynchronizedMutexBlock2 tsmb2 = new TestSynchronizedMutexBlock2(tsmb);
        TestSynchronizedMutexBlock3 tsmb3 = new TestSynchronizedMutexBlock3(tsmb);

        tsmb1.start();
        tsmb2.start();
        Thread.sleep(1000);
        tsmb3.start();

    }
}

class TestSynchronizedMutexBlock1 extends Thread{
    private TestSynchronizedMutexBlock tsmb;

    public TestSynchronizedMutexBlock1(TestSynchronizedMutexBlock tsmb){
        this.tsmb = tsmb;
    }

    @Override
    public void run() {
        tsmb.methodA();
    }
}

class TestSynchronizedMutexBlock2 extends Thread{
    private TestSynchronizedMutexBlock tsmb;

    public TestSynchronizedMutexBlock2(TestSynchronizedMutexBlock tsmb){
        this.tsmb = tsmb;
    }

    @Override
    public void run() {
        tsmb.methodB();
    }
}

class TestSynchronizedMutexBlock3 extends Thread{
    private TestSynchronizedMutexBlock tsmb;

    public TestSynchronizedMutexBlock3(TestSynchronizedMutexBlock tsmb){
        this.tsmb = tsmb;
    }

    @Override
    public void run() {
        tsmb.methodC();
    }
}
