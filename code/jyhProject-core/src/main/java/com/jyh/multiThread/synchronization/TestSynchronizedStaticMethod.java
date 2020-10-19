package com.jyh.multiThread.synchronization;

//测试类锁
//静态方法持有的锁和非静态方法持有的锁是不一样的锁，前者是类锁，后者是对象锁
//两者之间不会阻塞，不同线程调用相同的类锁会阻塞
public class TestSynchronizedStaticMethod {

    public synchronized static void methodA(){
        try{
            System.out.println(Thread.currentThread().getName() + "--" + System.currentTimeMillis());
            Thread.sleep(2000);
            System.out.println(Thread.currentThread().getName() + "--" + System.currentTimeMillis());
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }

    public synchronized static void methodB(){
        try{
            System.out.println(Thread.currentThread().getName() + "--" + System.currentTimeMillis());
            Thread.sleep(2000);
            System.out.println(Thread.currentThread().getName() + "--" + System.currentTimeMillis());
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }

    public synchronized void methodC(){
        try{
            System.out.println(Thread.currentThread().getName() + "--" + System.currentTimeMillis());
            Thread.sleep(2000);
            System.out.println(Thread.currentThread().getName() + "--" + System.currentTimeMillis());
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }

    public static void main(String[] args){
        TestSynchronizedStaticMethod tssm = new TestSynchronizedStaticMethod();

        //类锁就算不同的线程持有不同的对象实例，也会阻塞
        //TestSynchronizedStaticMethod tssm1 = new TestSynchronizedStaticMethod();
        //TestStaticMethod1 tsm1 = new TestStaticMethod1(tssm);
        //TestStaticMethod2 tsm2 = new TestStaticMethod2(tssm1);
        TestStaticMethod1 tsm1 = new TestStaticMethod1();
        TestStaticMethod2 tsm2 = new TestStaticMethod2();
        TestStaticMethod3 tsm3 = new TestStaticMethod3(tssm);

        tsm1.start();
        tsm2.start();
        tsm3.start();
    }
}

class TestStaticMethod1 extends Thread{
    /*private TestSynchronizedStaticMethod tssm;

    public TestStaticMethod1(TestSynchronizedStaticMethod tssm){
        this.tssm = tssm;
    }

    @Override
    public void run() {
        tssm.methodA();
    }*/

    @Override
    public void run() {
        TestSynchronizedStaticMethod.methodA();
    }
}

class TestStaticMethod2 extends Thread{
    /*private TestSynchronizedStaticMethod tssm;

    public TestStaticMethod2(TestSynchronizedStaticMethod tssm){
        this.tssm = tssm;
    }

    @Override
    public void run() {
        tssm.methodB();
    }*/

    @Override
    public void run() {
        TestSynchronizedStaticMethod.methodA();
    }
}

class TestStaticMethod3 extends Thread{
    private TestSynchronizedStaticMethod tssm;

    public TestStaticMethod3(TestSynchronizedStaticMethod tssm){
        this.tssm = tssm;
    }

    @Override
    public void run() {
        tssm.methodC();
    }
}
