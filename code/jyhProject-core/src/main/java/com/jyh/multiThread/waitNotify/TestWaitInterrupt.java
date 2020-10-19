package com.jyh.multiThread.waitNotify;

//测试wait()可以被中断的场景
public class TestWaitInterrupt {

    public synchronized void methodA(){
        try{
            System.out.println(Thread.currentThread().getName() + " start!");
            this.wait();
        }catch (InterruptedException e){
            System.out.println("wait 被 interrupt 中断了");
        }
    }

    public static void main(String[] args) throws Exception{
        TestWaitInterrupt twi = new TestWaitInterrupt();
        TestInterrupt ti = new TestInterrupt(twi);
        ti.start();
        Thread.sleep(3000);
        ti.interrupt();
    }
}

class TestInterrupt extends Thread{
    private TestWaitInterrupt twi;

    public TestInterrupt(TestWaitInterrupt twi){
        this.twi = twi;
    }

    @Override
    public void run() {
        twi.methodA();
    }
}
