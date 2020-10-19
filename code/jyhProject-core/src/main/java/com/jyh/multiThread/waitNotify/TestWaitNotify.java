package com.jyh.multiThread.waitNotify;

/*
wait():使线程进入预执行队列，直到接收到通知(notify)或者中断(interrupt)，调用wait(),
线程必须获得该对象的锁，因此只能在同步方法或者同步块中调用，释放锁
notify():随机唤醒一个wait的线程，但wait线程不是立刻获取对象锁，因为notify不会立即释放对象锁，需要等到
线程执行结束，notify也需要在同步方法或者同步块中执行
 */
public class TestWaitNotify {

    public static void main(String[] args) throws Exception{
        Object obj = new Object();
        WaitThread wt = new WaitThread(obj);
        NotifyThread nt = new NotifyThread(obj);
        wt.start();
        Thread.sleep(2000);
        nt.start();
    }
}

class WaitThread extends Thread{
    private Object obj;

    public WaitThread(Object obj){
        this.obj = obj;
    }

    @Override
    public void run() {
        synchronized (obj){
            try {
                System.out.println(Thread.currentThread().getName() + "-- start!");
                obj.wait();
                System.out.println(Thread.currentThread().getName() + "-- end!");
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }
    }
}

class NotifyThread extends Thread{
    private Object obj;

    public NotifyThread(Object obj){
        this.obj = obj;
    }

    @Override
    public void run() {
        synchronized (obj){
            System.out.println(Thread.currentThread().getName() + "-- start!");
            obj.notify();
            System.out.println(Thread.currentThread().getName() + "-- end!");
        }
    }
}
