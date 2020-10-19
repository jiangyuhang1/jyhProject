package com.jyh.multiThread.deadlock;

public class TestDeadLock {
    private final Object a = new Object();
    private final Object b = new Object();

    public void methodA() throws Exception{
        synchronized (a){
            Thread.sleep(2000);
            synchronized (b){
                System.out.println(Thread.currentThread().getName());
            }
        }
    }

    public void methodB() throws Exception{
        synchronized (b){
            Thread.sleep(2000);
            synchronized (a){
                System.out.println(Thread.currentThread().getName());
            }
        }
    }

    public static void main(String[] args){
        TestDeadLock tdl = new TestDeadLock();
        TestDeadLock1 tdl1 = new TestDeadLock1(tdl);
        TestDeadLock2 tdl2 = new TestDeadLock2(tdl);
        tdl1.start();
        tdl2.start();
    }

}

class TestDeadLock1 extends Thread{
    private TestDeadLock tdl;

    public TestDeadLock1(TestDeadLock tdl){
        this.tdl = tdl;
    }

    @Override
    public void run(){
        try {
            tdl.methodA();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}

class TestDeadLock2 extends Thread{
    private TestDeadLock tdl;

    public TestDeadLock2(TestDeadLock tdl){
        this.tdl = tdl;
    }

    @Override
    public void run(){
        try {
            tdl.methodB();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
