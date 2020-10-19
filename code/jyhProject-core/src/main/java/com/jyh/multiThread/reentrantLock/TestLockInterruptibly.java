package com.jyh.multiThread.reentrantLock;


import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 使用lockInterruptibly()获取锁，可以使等待的线程中断
 * 使用lock()方法获取锁，即使调用中断方法，依然可以使等待的线程获取锁
 */
public class TestLockInterruptibly {
    private Lock lock = new ReentrantLock();

    public void methodA(){
        String name = Thread.currentThread().getName();
        try {
            System.out.println(name + "开始获取锁");
            lock.lockInterruptibly();
            System.out.println(name + "获取锁");
            Thread.sleep(3000);
        }catch (InterruptedException e){
            System.out.println(name + "被中断");
        }finally {
            try{
                lock.unlock();
                System.out.println(name + "释放锁");
            }catch (Exception e){
                System.out.println(name + "没有得到锁结束运行");
            }
        }
    }

    public static void main(String[] args) throws Exception{
        TestLockInterruptibly tli = new TestLockInterruptibly();
        Thread thread1 = new Thread(() -> tli.methodA());
        Thread thread2 = new Thread(() -> tli.methodA());

        thread1.start();
        Thread.sleep(1000);
        thread2.start();
        thread2.interrupt();
    }
}
