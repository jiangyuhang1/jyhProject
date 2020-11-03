package com.jyh.multiThread.Timer;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

/**
 * 测试多个TimerTask同时运行
 * 同一个timer可以同时执行多个定时任务
 */
public class TestTimerScheduleTwo extends TimerTask {

    /**
     * 启动一个新线程，定时任务执行完毕后，线程不会销毁，可以设置为守护进程，任务执行完会销毁
     */
    private static Timer timer = new Timer();

    @Override
    public void run() {
        System.out.println("运行了!时间为: " + new Date());
        try {
            Thread.sleep(5000);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws Exception{
        TestTimerScheduleTwo testTimerScheduleTwo1 = new TestTimerScheduleTwo();
        TestTimerScheduleTwo testTimerScheduleTwo2 = new TestTimerScheduleTwo();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String dateString1 = "2020-11-03 16:06:00";

        /**
         * Task是以队列的形式一个个被执行的，如果前面一个任务执行时间过长，超出了后面的定时任务执行时间
         * 那么后面的定时任务真的执行时间要晚于计划时间
         */
        String dateString2 = "2020-11-03 16:06:02";
        Date date1 = simpleDateFormat.parse(dateString1);
        Date date2 = simpleDateFormat.parse(dateString2);
        System.out.println("字符串时间: " + date1.toLocaleString() + "当前时间: " + new Date().toLocaleString());
        System.out.println("字符串时间: " + date2.toLocaleString() + "当前时间: " + new Date().toLocaleString());

        timer.schedule(testTimerScheduleTwo1,date1);
        timer.schedule(testTimerScheduleTwo2,date2);
    }
}
