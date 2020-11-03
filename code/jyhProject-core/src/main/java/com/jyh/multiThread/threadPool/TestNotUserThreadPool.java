package com.jyh.multiThread.threadPool;

import java.util.LinkedList;
import java.util.List;
import java.util.Random;

/**
 * 测试使用非线程池执行多个线程所需要的时间
 */
public class TestNotUserThreadPool {

    public static void main(String[] args){
        final List<Integer> list = new LinkedList<>();
        final Random random = new Random();

        long startTime = System.currentTimeMillis();

        for(int i = 0; i < 2000; i++){
            Thread thread = new Thread(
                    new Runnable() {
                        @Override
                        public void run() {
                            list.add(random.nextInt());
                        }
                    }
            );

            thread.start();

            try{
                thread.join();
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }

        long endTime = System.currentTimeMillis();

        System.out.println(endTime - startTime);
    }
}
