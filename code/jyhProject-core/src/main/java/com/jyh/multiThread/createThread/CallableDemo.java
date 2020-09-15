package com.jyh.multiThread.createThread;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

//这种线程方式有返回值
public class CallableDemo implements Callable<Integer> {

    @Override
    public Integer call() throws Exception {
        int i = 0;
        for(; i < 10; i++){
            System.out.println(Thread.currentThread().getName() + i);
        }
        return i;
    }

    public static void main(String[] args){
        CallableDemo cd = new CallableDemo();
        FutureTask<Integer> ft = new FutureTask<>(cd);

        //main主线程
        for(int i = 0; i < 10; i++){
            System.out.println(Thread.currentThread().getName()+" 的循环变量i的值"+i);
            if(i == 2){
                //子线程
                new Thread(ft,"有返回值的线程").start();
            }
        }

        try{
            //get()方法会阻塞，直到子线程执行结束才返回
            System.out.println("子线程的返回值:" + ft.get());
        }catch (ExecutionException e){
            e.printStackTrace();
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }
}
