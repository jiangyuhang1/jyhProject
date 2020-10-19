package com.jyh.multiThread.threadLocal;

public class TestThreadLocal {
    private int i = 1;

    public int getI() {
        return i;
    }

    public void setI(int i) {
        this.i = i;
    }

    public void methodA(){
        System.out.println(i);
    }

    public void methodB(){
        System.out.println(i);
    }

    public static void main(String[] args) throws Exception{
        TestThreadLocal ttl = new TestThreadLocal();
        //ttl.methodA();
        //ttl.methodB();

        TestThreadLocal1 ttl1 = new TestThreadLocal1(ttl);
        TestThreadLocal2 ttl2 = new TestThreadLocal2(ttl);

        ttl1.start();
        ttl2.start();

    }
}

class TestThreadLocal1 extends Thread{
    private TestThreadLocal ttl;

    public TestThreadLocal1(TestThreadLocal ttl){
        this.ttl = ttl;
    }

    @Override
    public void run() {
        ttl.setI(3);
        ttl.methodA();
    }
}


class TestThreadLocal2 extends Thread{
    private TestThreadLocal ttl;

    public TestThreadLocal2(TestThreadLocal ttl){
        this.ttl = ttl;
    }

    @Override
    public void run() {
        ttl.methodB();
    }
}


