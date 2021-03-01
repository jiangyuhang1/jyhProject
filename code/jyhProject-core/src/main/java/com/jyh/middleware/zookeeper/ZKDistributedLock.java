package com.jyh.middleware.zookeeper;

import org.apache.zookeeper.*;
import org.apache.zookeeper.data.Stat;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.SortedSet;
import java.util.TreeSet;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

/**
 * 使用zk api来实现分布式锁
 */
public class ZKDistributedLock implements Lock, Watcher {

    /**
     * 定义锁变量，其中ROOT_LOCK、WAIT_LOCK、CURRENT_LOCK都是zk的节点
     */
    private ZooKeeper zk = null;
    private String ROOT_LOCK = "/locks003";//定义根节点
    private String WAIT_LOCK;//等待前一个锁
    private String CURRENT_LOCK;//表示当前的锁
    private CountDownLatch countDownLatch;

    /**
     * 构造函数
     * 1.建立zk集群连接
     * 2.新建一个持久化根节点
     */
    public ZKDistributedLock() {
        try {
            zk = new ZooKeeper("192.168.1.102:2181,192.168.1.102:2182,192.168.1.102:2183",4000,this);
            // 判断根节点是否存在
            Stat stat = zk.exists(ROOT_LOCK, false);
            if(stat == null) {
                /**
                 * 创建一个持久化的根节点
                 */
                zk.create(ROOT_LOCK, "0".getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT);
            }

        } catch (IOException e) {
            e.printStackTrace();
        } catch (KeeperException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    /**
     * 尝试获得锁方法
     * 1.新建临时有序节点
     * 2.临时有序节点与所有的节点进行比较，如果是最小获得锁
     * 3.如果不是锁，将当前节点相邻的最小节点置为等待锁节点
     * @return
     */
    @Override
    public boolean tryLock() {
        try {
            // 创建临时有序节点
            CURRENT_LOCK = zk.create(ROOT_LOCK + "/" , "0".getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT_SEQUENTIAL);
            System.out.println(Thread.currentThread().getName() + "->" + CURRENT_LOCK + " try lock ");

            List<String> childrens = zk.getChildren(ROOT_LOCK, false);
            SortedSet<String> sortedSet =  new TreeSet();//定义一个集合进行排序
            for(String children : childrens) {
                sortedSet.add(ROOT_LOCK + "/" + children);
            }

            String firstNode = sortedSet.first();//获得当前所有子节点中最小的节点
            /**
             * 获取比当前节点所有更小的节点
             */
            SortedSet<String> lessThenMe = ((TreeSet<String>)sortedSet).headSet(CURRENT_LOCK);
            // 如果当前节点和集合中的最小节点相同，表示获得锁
            if(CURRENT_LOCK.equals(firstNode)) {
                return true;
            }

            if(!lessThenMe.isEmpty()) {
                // 获得比当前节点更小的所有节点中最后一个节点，即与当前节点相邻的最小节点设置给WAIT_LOCK
                WAIT_LOCK = lessThenMe.last();
            }


        } catch (KeeperException | InterruptedException e) {
            e.printStackTrace();
        }
        return false;
    }

    public static void main(String[] args) {
        String CURRENT_LOCK = "/locks003/00003";
        SortedSet<String> sortedSet =  new TreeSet();//定义一个集合进行排序
        List<String> childrens = new ArrayList<>();
        childrens.add("00002");
        childrens.add("00001");
        childrens.add("00003");
        childrens.add("00004");
        for(String children : childrens) {
            sortedSet.add("/locks003" + "/" + children);
        }

        String firstNode = sortedSet.first();//获得当前所有子节点中最小的节点
        System.out.println(firstNode);
        SortedSet<String> lessThenMe = ((TreeSet<String>)sortedSet).headSet(CURRENT_LOCK);
        for(String less : lessThenMe){
            System.out.println(less);
        }
        System.out.println(lessThenMe.last());
    }

    /**
     * 释放锁会关闭客户端连接，此时监听事件触发，计数器置为空，等待锁将获取到锁
     * @param event
     */
    @Override
    public void process(WatchedEvent event) {
        if(this.countDownLatch != null) {
            this.countDownLatch.countDown();
        }
    }

    @Override
    public void lock() {
        if(this.tryLock()) {
            System.out.println(Thread.currentThread().getName() + "->" + CURRENT_LOCK + "->" + " get lock success " );
            return;
        }
        try {
            waitForLock(WAIT_LOCK);//没有获得锁，继续等待获得锁

        } catch (KeeperException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private boolean waitForLock(String prev) throws KeeperException, InterruptedException {
        Stat stat = zk.exists(prev, true);//监听当前节点的上一个节点
        if(stat != null) {
            System.out.println(Thread.currentThread().getName() + " -> wait lock " + prev + " 释放 ");
            countDownLatch = new CountDownLatch(1);
            countDownLatch.await();
            System.out.println(Thread.currentThread().getName() + " -> get lock success -- / -- ");
        }
        return true;
    }

    @Override
    public void lockInterruptibly() throws InterruptedException {

    }

    @Override
    public boolean tryLock(long time, TimeUnit unit) throws InterruptedException {
        return false;
    }

    @Override
    public void unlock() {
        System.out.println(Thread.currentThread().getName() + " 释放锁 " + CURRENT_LOCK);
        try {
            zk.delete(CURRENT_LOCK, -1);
            CURRENT_LOCK = null;
            zk.close();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (KeeperException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Condition newCondition() {
        return null;
    }
}
