package com.jyh.multiThread.producerCustomerModel;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * 测试阻塞队列BlockingQueue:指线程在某些情况下会挂起（阻塞），在满足条件的时候，阻塞的线程会被唤醒
 * ArrayBlockingQueue:必须指定队列大小，可初始化是否公平锁，只有一个ReentrantLock对象，消费者和生产者不能并行
 *                    有两个condition,可以避免假死
 * LinkedBlockingQueue:两个ReentrantLock对象，消费者和生产者可以并行运行，可以不指定大小
 */
public class TestBlockingQueueModel {
    private BlockingQueue<String> blockingQueue = new ArrayBlockingQueue<String>(10);
    private int i = 0;

    public void producerMethod(){
        try{
            i++;
            System.out.println("生产者生产的数据： " + i);
            //把e添加到队列中，如果BlockingQueue没有空间线程将进入等待，直接BlockingQueue中有空间在继续
            blockingQueue.put(i + "");
            Thread.sleep(1000);
        }catch(InterruptedException e){
            e.printStackTrace();
        }
    }

    public void customerMethod(){
        try{
            //取走在BlockingQueue中排在首位的对象，如果BlockingQueue为空，线程会被阻塞，进入等待，直到BlockingQueue有数据，线程会被唤醒
            System.out.println("消费者消费的数据： " + blockingQueue.take());
            Thread.sleep(3000);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }

    public static void main(String[] args){
        TestBlockingQueueModel testBlockingQueueModel = new TestBlockingQueueModel();
        new Thread(() -> {while (true){testBlockingQueueModel.producerMethod();}}).start();
        new Thread(() -> {while (true){testBlockingQueueModel.customerMethod();}}).start();
    }
}
