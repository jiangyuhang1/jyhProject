package com.jyh.multiThread.createThread;

public class RunnableDemo implements Runnable{
    @Override
    public void run(){
        try {
            for (int i = 0; i < 5; i++) {
                System.out.println(Thread.currentThread().getName() + "在运行");
                Thread.sleep(50);
            }
        }catch (InterruptedException e){
            System.out.println(Thread.currentThread().getName() + "中断");
        }
    }
}
