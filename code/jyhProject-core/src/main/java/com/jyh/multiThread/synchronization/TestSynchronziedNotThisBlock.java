package com.jyh.multiThread.synchronization;

//测试synchronized(非this对象)
//当多个线程同时执行synchronized(x){}同步代码块时呈同步效果
//当其他线程执行x对象中的synchronized同步方法时呈同步效果
//当其他线程执行x对象方法中的synchronized(this)代码块时也呈同步效果
public class TestSynchronziedNotThisBlock {

    public synchronized void methodA(){
        try{
            System.out.println(Thread.currentThread().getName() + "--" + System.currentTimeMillis());
            Thread.sleep(1000);
            System.out.println(Thread.currentThread().getName() + "--" + System.currentTimeMillis());
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws Exception{
        TestSynchronziedNotThisBlock tsntb = new TestSynchronziedNotThisBlock();
        //TestSynchronziedNotThisBlock tsntbObj = new TestSynchronziedNotThisBlock();
        TestSynchronziedNotThisBlock1 tsntb1 = new TestSynchronziedNotThisBlock1();
        //tsntb3执行的是tsntb对象锁
        TestSynchronziedNotThisBlock3 tsntb3 = new TestSynchronziedNotThisBlock3(tsntb);
        //tsntb2执行的是tsntb1对象里面的方法，同步代码块锁的对象还是tsntb，所以两者还是阻塞
        TestSynchronziedNotThisBlock2 tsntb2 = new TestSynchronziedNotThisBlock2(tsntb,tsntb1);
        tsntb3.start();
        //Thread.sleep(1000);
        tsntb2.start();
    }
}

class TestSynchronziedNotThisBlock1{

    public void methodB(TestSynchronziedNotThisBlock tsntb){
        synchronized (tsntb){
            try{
                System.out.println(Thread.currentThread().getName() + "--" + System.currentTimeMillis());
                Thread.sleep(1000);
                System.out.println(Thread.currentThread().getName() + "--" + System.currentTimeMillis());
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }
    }
}


class TestSynchronziedNotThisBlock2 extends Thread{
    private TestSynchronziedNotThisBlock tsntb;
    private TestSynchronziedNotThisBlock1 tsntb1;

    public TestSynchronziedNotThisBlock2(TestSynchronziedNotThisBlock tsntb,
                                         TestSynchronziedNotThisBlock1 tsntb1){
        this.tsntb = tsntb;
        this.tsntb1 = tsntb1;
    }

    @Override
    public void run() {
        tsntb1.methodB(tsntb);
    }
}

class TestSynchronziedNotThisBlock3 extends Thread{
    private TestSynchronziedNotThisBlock tsntb;


    public TestSynchronziedNotThisBlock3(TestSynchronziedNotThisBlock tsntb){
        this.tsntb = tsntb;

    }

    @Override
    public void run() {
        tsntb.methodA();
    }
}


