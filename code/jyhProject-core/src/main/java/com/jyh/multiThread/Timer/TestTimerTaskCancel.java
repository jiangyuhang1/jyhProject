package com.jyh.multiThread.Timer;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

/**
 * 测试TimerTask的cancel()方法: 调用的任务后续不会执行
 * 测试Timer的cancel()方法: 会使通过timer启动的定时任务全部停止
 */
public class TestTimerTaskCancel {

    private static Timer timer = new Timer();

    public static class MyTask1 extends TimerTask{
        @Override
        public void run() {
            System.out.println("定时任务1运行时间: " + new Date());
            this.cancel();
            //timer.cancel();
        }
    }

    public static class MyTask2 extends TimerTask{
        @Override
        public void run() {
            System.out.println("定时任务2运行时间: " + new Date());
        }
    }

    public static void main(String[] args){
        MyTask1 myTask1 = new MyTask1();
        MyTask2 myTask2 = new MyTask2();

        /**
         * 由于myTask1中调用了TimerTask cancel()方法，只会执行一次，后面任务就会取消
         * myTask2不受影响
         *
         * 使用了timer的cancel方法myTask1只会执行一次，myTask2也将被取消
         */
        timer.schedule(myTask1,0,2000);
        timer.schedule(myTask2,0,2000);
    }
}