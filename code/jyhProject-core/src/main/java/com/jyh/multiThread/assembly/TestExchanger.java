package com.jyh.multiThread.assembly;

import java.util.concurrent.Exchanger;

/**
 * 测试Exchanger组件使用案例
 * 概要: 用于两个线程之间交换数据，线程会在exchange方法处阻塞，快的线程要等待慢的线程
 */
public class TestExchanger {

    static class ExchangerThread extends Thread{
        private Exchanger<String> exchanger;
        private String name;
        private int sleepParam;
        private String str;

        public ExchangerThread(String name, Exchanger<String> exchanger, int sleepParam, String str){
            super(name);
            this.exchanger = exchanger;
            this.sleepParam = sleepParam;
            this.str = str;
        }

        @Override
        public void run() {
            try {
                System.out.println(this.getName() + " 交换前数据: " + this.str + " 交换前时间: " + System.currentTimeMillis());
                Thread.sleep(sleepParam * 1000);
                str = exchanger.exchange(str);
                System.out.println(this.getName() + " 交换后数据: " + this.str + " 交换后时间: " + System.currentTimeMillis());
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        Exchanger<String> exchanger = new Exchanger<>();
        ExchangerThread exchangerThread1 = new ExchangerThread("线程1", exchanger, 2, "线程1数据");
        ExchangerThread exchangerThread2 = new ExchangerThread("线程2", exchanger, 3, "线程2数据");

        exchangerThread1.start();
        exchangerThread2.start();
    }
}
