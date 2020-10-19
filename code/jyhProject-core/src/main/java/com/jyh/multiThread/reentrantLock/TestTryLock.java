package com.jyh.multiThread.reentrantLock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 测试tryLock获取锁的方法，立即返回true or false，避免自锁
 */
public class TestTryLock {
    private Lock lock = new ReentrantLock();

    public void methodA(){
        try{
            if(lock.tryLock()){
                System.out.println("method A" + Thread.currentThread().getName() + " 获得锁");
            }else {
                System.out.println("method A" + Thread.currentThread().getName() + " 未获得锁");
            }
            Thread.sleep(5000);
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }

    public void methodB(){
        try{
            if(lock.tryLock()){
                System.out.println("method B" + Thread.currentThread().getName() + " 获得锁");
            }else {
                System.out.println("method B" + Thread.currentThread().getName() + " 未获得锁");
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            //未获取到对象锁，此处会报java.lang.IllegalMonitorStateException
            //标明当前线程未获取到对象监视器，不可以使用该方法，该方法需要获取到对象锁才能执行
            lock.unlock();
        }
    }

    public static void main(String[] args){
        TestTryLock ttl = new TestTryLock();
        new Thread(() -> ttl.methodA()).start();
        new Thread(() -> ttl.methodB()).start();
    }
}
