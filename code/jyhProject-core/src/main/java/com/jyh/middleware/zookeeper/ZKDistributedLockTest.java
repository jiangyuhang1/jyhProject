package com.jyh.middleware.zookeeper;

import java.io.IOException;
import java.util.concurrent.CountDownLatch;

/**
 * 测试分布式锁
 * 第一次：建立连接，新建根节点/locks003,当前节点/locks003/0001,最小节点是/locks003/0001，获得锁；打印thread-i -> /locks003/0001 -> get lock success
 * 第二次：当前节点/locks003/0002，最小节点是/locks003/0001，获取不到锁，需要等待锁释放；打印thread-i -> wait lock -> /locks003/0001 -> 释放
 * 第三次：当前节点/locks003/0003，最小节点是/locks003/0001，获取不到锁，需要等待锁释放；打印thread-i -> wait lock -> /locks003/0002 -> 释放
 * 第四次：.....
 *
 */
public class ZKDistributedLockTest {

    public static void main(String[] args) throws IOException {
        /**
         * 这里的CountDownLatch的作用是为了模拟十个客户端同时到zk上建立连接获取锁
         */
        final CountDownLatch countDownLatch = new CountDownLatch(10);
        for (int i = 0; i < 10; i++) {
            Thread thread =new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        countDownLatch.await();
                        ZKDistributedLock distributedLock = new ZKDistributedLock();
                        distributedLock.lock();
                        //....业务代码
                        distributedLock.unlock();

                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            },"Thread-" + i);
            thread.start();
            countDownLatch.countDown();
        }

        System.in.read();
    }
}
