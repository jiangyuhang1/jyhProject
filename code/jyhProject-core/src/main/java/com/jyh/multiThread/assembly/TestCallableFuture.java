package com.jyh.multiThread.assembly;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * 测试callable和Future(异步计算的结果)使用案例
 * 概要: 1.实现callable接口创建线程优势在于可以获得返回值
 *      2.call()方法的返回值用Future的get()方法获取，还有cancel(),isCancel()中断任务，isDone()判断任务是否完成
 *      3.配合线程池使用时用submit()方法，submit()可以获取Future对象，用于获取线程返回值
 *      4.如果不使用线程池执行线程，需要用Callable对象创建FutureTask对象，用FutureTask对象创建Thread的对象
 *        用Thread的对象start线程，在用FutureTask对象get返回值
 */
public class TestCallableFuture implements Callable<String> {

    @Override
    public String call(){
        try {
            System.out.println(Thread.currentThread().getName() + " 开始工作!时间: " + System.currentTimeMillis());
            Thread.sleep(5000);
            return "123";
        }catch (InterruptedException e){
            e.printStackTrace();
            return "InterruptedException";
        }
    }

    public static void main(String[] args) throws Exception{

        /**
         * 创建无界线程池
         */
        ExecutorService es = Executors.newCachedThreadPool();

        /**
         * 实现Callable创建一个线程
         */
        TestCallableFuture testCallableFuture = new TestCallableFuture();

        /**
         * 1.submit与execute的区别在于是否有返回值，前者返回Future，可用于获取call()方法的返回值
         * 后者void,适合执行用继承Thread,和实现Runnable的线程
         * 2.submit的原理是调用excute方法执行线程池，并new一个FutureTask对象返回
         */
        Future<String> future =  es.submit(testCallableFuture);
        es.shutdown();
        System.out.println(future.get());
        System.out.println("获取到返回值，当前时间为: " + System.currentTimeMillis());
    }
}
