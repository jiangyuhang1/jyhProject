package com.jyh.multiThread.Timer;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

/**
 * 测试Timer和TimerTask实现定时任务
 * schedule(TimerTask task, Date time)
 * 说明:1.继承TimerTask实现run方法，里面的内容是定时任务将要执行的内容
 *     2.当time的时间晚于当前时间，将在未来执行
 *     3.当time的时间早于当前时间，将立即执行
 *
 */
public class TestTimerScheduleOne extends TimerTask {

    /**
     * 启动一个新线程，定时任务执行完毕后，线程不会销毁，可以设置为守护进程，任务执行完会销毁
     */
    private static Timer timer = new Timer(true);

    @Override
    public void run() {
        System.out.println("运行了!时间为: " + new Date());
    }

    public static void main(String[] args) throws Exception{
        TestTimerScheduleOne testTimerScheduleOne = new TestTimerScheduleOne();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String dateString = "2020-11-03 15:25:00";
        Date date = simpleDateFormat.parse(dateString);
        System.out.println("字符串时间: " + date.toLocaleString() + "当前时间: " + new Date().toLocaleString());
        timer.schedule(testTimerScheduleOne,date);

        /**
         * 使main线程暂停2s,让timer线程先执行完，不然作为守护进程的timer会随main线程销毁而销毁
         */
        Thread.sleep(2000);
    }
}
