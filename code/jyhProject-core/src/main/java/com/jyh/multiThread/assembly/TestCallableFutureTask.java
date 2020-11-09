package com.jyh.multiThread.assembly;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;

/**
 * 使用Callable和FutureTask案例
 * 与Callable和Future使用差异:
 *      1.FutureTask需要Callable对象去实例，生产的FutureTask对象作为线程池的submit方法参数
 *        是走的Runnable参数，不需要接受返回值，只要FutureTask的get方法就可以获取到
 *      2.Future案例，是用Callable对象作为线程池的submit参数，用Future去接受submit返回值，然后在调用
 *        get方法获取到线程结果
 */
public class TestCallableFutureTask implements Callable<String> {

    @Override
    public String call() throws Exception {

        System.out.println(Thread.currentThread().getName() + " 开始工作!时间为: " + System.currentTimeMillis());
        Thread.sleep(2000);
        return "123";
    }

    public static void main(String[] args) throws Exception{
        ExecutorService es = Executors.newCachedThreadPool();
        TestCallableFutureTask testCallableFutureTask  = new TestCallableFutureTask();
        FutureTask<String> futureTask = new FutureTask<String>(testCallableFutureTask);

        es.submit(futureTask);
        es.shutdown();

        Thread.sleep(1000);

        /**
         * Future表示一种异步计算
         * 如果call中的方法直接在main执行，main方法将执行3秒，现在采用submit的方式，可以异步执行
         * call中代码可以和main中其他方法同时执行
         * 好处: 可以节省时间，对于一个方法B,把依赖A方法中的内容放在call中，用submit提交
         */
        System.out.println(futureTask.get());
        System.out.println("工作结束!时间结束: " + System.currentTimeMillis());

    }
}
