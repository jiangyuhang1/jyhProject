package com.jyh.multiThread.producerCustomerModel;

/**
 * 使用wait和notify实现生产者消费者模型
 * 生产者消费者模型需要关注以下几点
 * 一：生产者生产的时候消费者不能消费
 * 二：消费者消费的时候生产者不能生产
 * 三：缓冲区空时消费者不能消费
 * 四：缓冲区满时生产者不能生产
 *
 * 避免假死：生产者/消费者模型最终达到的目的是平衡生产者和消费者的处理能力,
 * 可以有多个生产者/一个消费者，一个生产者/多个消费者，多个生产者/多个消费者
 * 现象：生产A,生产B,消费C,此时仓库为空，消费C通知A进行生产,C处于waiting，B处于waiting，
 *      A生产后本应该通知C进行消费，但是notify随机唤醒，唤醒了B,此时B发现仓库是满的，继续waiting
 *      此时，三个线程都是waiting状态，处于假死
 * 使用synchronized使用notifyAll唤醒所有线程，ReentrantLock使用signalAll
 */
public class TestWaitNotifyModel {

    /**
     * 用value值作为缓冲区，生产者消费者的仓库
     */
    public static String value = "";

    public static void main(String[] args){
        Object lock = new Object();

        Producer producer = new Producer(lock);
        Customer customer = new Customer(lock);
        new Thread(() -> {while (true) producer.setValue();}).start();
        new Thread(() -> {while (true) producer.setValue();}).start();
        new Thread(() -> {while (true) customer.getValue();}).start();
    }
}

class Producer{
    private Object lock;

    public Producer(Object lock){
        this.lock = lock;
    }

    public void setValue(){
        try{
            synchronized (lock){

                //当value有值时，生产者进行等待，在消费者消费完之后在生产
                if(!"".equals(TestWaitNotifyModel.value)){
                    lock.wait();
                }
                String value = System.currentTimeMillis() + "_" + System.nanoTime();
                System.out.println(Thread.currentThread().getName() +" 生产者设置的value: " + value);
                TestWaitNotifyModel.value = value;
                lock.notifyAll();
            }
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }
}

class Customer{
    private Object lock;

    public Customer(Object lock){
        this.lock = lock;
    }

    public void getValue(){
        try{
            synchronized (lock){

                //当value为空时，消费者进行等待，等待生产者生产过后再消费
                if("".equals(TestWaitNotifyModel.value)){
                    lock.wait();
                }
                System.out.println("消费者消费的的value: " + TestWaitNotifyModel.value);
                TestWaitNotifyModel.value = "";
                lock.notifyAll();
            }
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }
}
