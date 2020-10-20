package com.jyh.multiThread.producerCustomerModel;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 使用await和signal来实现生产者和消费者模型
 */
public class TestAwaitSignalModel {
    public static String value = "";

    public static void main(String[] args){

        ProducerCustomer producerCustomer = new ProducerCustomer();

        new Thread(() -> {while (true) producerCustomer.setValue();}).start();
        new Thread(() -> {while (true) producerCustomer.getValue();}).start();

    }
}

class ProducerCustomer extends ReentrantLock{

    private Condition condition = newCondition();

    public void setValue(){
        try{
            lock();
            if(!"".equals(TestAwaitSignalModel.value)){
                condition.await();
            }
            String value = System.currentTimeMillis() + "_" + System.nanoTime();
            System.out.println("生产者设置的value: " + value);
            TestAwaitSignalModel.value = value;
            condition.signal();
        }catch(InterruptedException e){
            e.printStackTrace();
        }finally {
            unlock();
        }
    }

    public void getValue(){
        try{
            lock();
            if("".equals(TestAwaitSignalModel.value)){
                condition.await();
            }
            System.out.println("消费者消费的value: " + TestAwaitSignalModel.value);
            TestAwaitSignalModel.value = "";
            condition.signal();
        }catch(InterruptedException e){
            e.printStackTrace();
        }finally {
            unlock();
        }
    }
}
