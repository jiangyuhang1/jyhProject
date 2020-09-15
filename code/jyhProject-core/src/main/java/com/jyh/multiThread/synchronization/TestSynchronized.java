package com.jyh.multiThread.synchronization;

//测试脏读的场景
//多线程并发处理访问对象实例，可能获取的数据被其他线程被更改过了
//在addNum方法中没有加同步锁的
//synchronized是对象锁，如果多个线程对多个对象，将没有意义
public class TestSynchronized {
    int num = 0;

    //未加同步锁，会导致脏读
    public synchronized void addNum(String flag){
        if("a".equals(flag)){
            num = 100;
            System.out.println("a start");
            try{
                Thread.sleep(200);
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }else if("b".equals(flag)){
            num = 200;
            System.out.println("b start");
        }

        System.out.println(flag + " = " + num);
    }

    public static void main(String[] args){
        //synchronized 持有的是对象锁
        TestSynchronized ts = new TestSynchronized();
        //TestSynchronized ts1 = new TestSynchronized();
        TestSynchronizedThread1 tst1 = new TestSynchronizedThread1(ts);
        TestSynchronizedThread2 tst2 = new TestSynchronizedThread2(ts);
        tst1.start();
        tst2.start();
    }
}

class TestSynchronizedThread1 extends Thread{
    private TestSynchronized testSynchronized;

    public TestSynchronizedThread1(TestSynchronized testSynchronized){
        this.testSynchronized = testSynchronized;
    }

    @Override
    public void run() {
        testSynchronized.addNum("a");
    }
}

class TestSynchronizedThread2 extends Thread{
    private TestSynchronized testSynchronized;

    public TestSynchronizedThread2(TestSynchronized testSynchronized){
        this.testSynchronized = testSynchronized;
    }

    @Override
    public void run() {
        testSynchronized.addNum("b");
    }
}
