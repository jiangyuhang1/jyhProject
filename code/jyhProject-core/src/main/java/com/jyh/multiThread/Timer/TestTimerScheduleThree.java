package com.jyh.multiThread.Timer;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

/**
 * 测试Timer和TimerTask实现定时任务
 * 测试schedule(TimerTask task, Date firstTime, long period)
 * firstTime: 初始执行时间，当晚于当前时间，未来执行，早于当前时间，立即执行
 * period: 间隔时间，毫秒级别
 *
 *
 */
public class TestTimerScheduleThree extends TimerTask {

    private static Timer timer = new Timer();

    @Override
    public void run() {
        System.out.println("当前定时任务运行时间: " + new Date());
    }

    public static void main(String[] args) throws Exception{

        TestTimerScheduleThree testTimerScheduleThree = new TestTimerScheduleThree();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String dateString = "2020-11-03 16:25:00";
        Date date = simpleDateFormat.parse(dateString);
        System.out.println("字符创时间: " + date.toLocaleString() + "当前时间: " + new Date().toLocaleString());

        //timer.schedule(testTimerScheduleThree,date,2000);

        /**
         * delay: 距离当前时间多少毫秒后执行
         */
        timer.schedule(testTimerScheduleThree,2000,2000);
    }
}
