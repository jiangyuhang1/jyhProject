package com.jyh.multiThread.synchronization;

//测试同步方法及对象锁
//如果一个对象的所有方法都加了同步锁，即使前面的线程调用的和后面线程调用的是不同的对象
public class TestSynchronizedMethod {

    public synchronized void methodA(){
        System.out.println(Thread.currentThread().getName() + " start");
        try{
            Thread.sleep(2000);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + " end");
    }

    public synchronized void methodB(){
        System.out.println(Thread.currentThread().getName() + " start");
        try{
            Thread.sleep(2000);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + " end");
    }


    public static void main(String[] args){
        TestSynchronizedMethod tsm = new TestSynchronizedMethod();
        TestSynchronizedMethod1 tsm1 = new TestSynchronizedMethod1(tsm);
        //B线程和A线程调用同一个对象，但是methodB()没有加对象锁，所以在A运行期间，B线程可以调用methodB()
        TestSynchronizedMethod2 tsm2 = new TestSynchronizedMethod2(tsm);
        tsm1.setName("A");
        tsm2.setName("B");
        tsm1.start();
        tsm2.start();

    }
}

class TestSynchronizedMethod1 extends Thread{
    private TestSynchronizedMethod tsm;

    public TestSynchronizedMethod1(TestSynchronizedMethod tsm){
        this.tsm = tsm;
    }

    @Override
    public void run() {
        this.tsm.methodA();
    }
}


class TestSynchronizedMethod2 extends Thread{
    private TestSynchronizedMethod tsm;

    public TestSynchronizedMethod2(TestSynchronizedMethod tsm){
        this.tsm = tsm;
    }

    @Override
    public void run() {
        this.tsm.methodB();
    }
}
