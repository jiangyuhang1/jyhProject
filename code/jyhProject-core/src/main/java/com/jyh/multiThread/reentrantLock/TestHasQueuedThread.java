package com.jyh.multiThread.reentrantLock;


import java.util.concurrent.locks.ReentrantLock;

/**
 * hasQueuedThread(Thread thread)判断当前线程是否在等待获取锁
 * hasQueuedThreads()判断是否有线程在等待获取锁
 */
public class TestHasQueuedThread extends ReentrantLock {

    public void methodA(){
        try{
            lock();
            Thread.sleep(Integer.MAX_VALUE);
        }catch (InterruptedException e){
            e.printStackTrace();
        }finally {
            unlock();
        }
    }

    public static void main(String[] args) throws Exception{
        final TestHasQueuedThread thqt = new TestHasQueuedThread();

        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                thqt.methodA();
            }
        };

        Thread thread1 = new Thread(runnable);
        thread1.start();
        Thread.sleep(3000);

        Thread thread2 = new Thread(runnable);
        thread2.start();
        Thread.sleep(3000);

        Thread thread3 = new Thread(runnable);
        thread3.start();
        Thread.sleep(3000);

        System.out.println("thread1 在等待? : " + thqt.hasQueuedThread(thread1));
        System.out.println("thread2 在等待? : " + thqt.hasQueuedThread(thread2));
        System.out.println("thread3 在等待? : " + thqt.hasQueuedThread(thread3));

        System.out.println("是否有线程等待? : " + thqt.hasQueuedThreads());
    }
}
