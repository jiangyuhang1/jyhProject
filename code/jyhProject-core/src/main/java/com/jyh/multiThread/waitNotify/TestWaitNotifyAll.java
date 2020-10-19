package com.jyh.multiThread.waitNotify;

//测试多个wait线程可以被notifyAll全部唤醒
//notifyAll不会立即释放锁，会等到线程执行完在释放锁，wait线程此时接到通知会获取到对象锁，但是具有随机性
public class TestWaitNotifyAll {

    public synchronized void methodA(){
        try {
            System.out.println(Thread.currentThread().getName() + " start!");
            this.wait();
            System.out.println(Thread.currentThread().getName() + " end!");
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }

    public synchronized void methodB(){
        System.out.println(Thread.currentThread().getName() + " start!");
        this.notifyAll();
        System.out.println(Thread.currentThread().getName() + " end!");
    }

    public static void main(String[] args) throws Exception{
        TestWaitNotifyAll twnf = new TestWaitNotifyAll();
        TestNotifyAll1 tna1 = new TestNotifyAll1(twnf);
        TestNotifyAll1 tna2 = new TestNotifyAll1(twnf);
        TestNotifyAll1 tna3 = new TestNotifyAll1(twnf);
        tna1.start();
        tna2.start();
        tna3.start();

        Thread.sleep(3000);
        TestNotifyAll2 tna4 = new TestNotifyAll2(twnf);
        tna4.start();
    }
}

class TestNotifyAll1 extends Thread{
    private TestWaitNotifyAll twna;

    public TestNotifyAll1(TestWaitNotifyAll twna){
        this.twna = twna;
    }

    @Override
    public void run() {
        twna.methodA();
    }
}

class TestNotifyAll2 extends Thread{
    private TestWaitNotifyAll twna;

    public TestNotifyAll2(TestWaitNotifyAll twna){
        this.twna = twna;
    }

    @Override
    public void run() {
        twna.methodB();
    }
}
