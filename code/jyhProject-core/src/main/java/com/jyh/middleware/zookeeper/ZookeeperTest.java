package com.jyh.middleware.zookeeper;

import org.apache.curator.RetryPolicy;
import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.retry.ExponentialBackoffRetry;
import org.apache.zookeeper.*;
import org.apache.zookeeper.data.Stat;

import java.io.IOException;
import java.util.concurrent.CountDownLatch;

/**
 * zk应用基本案例
 * 1.zk连接
 * 2.zk增删改查
 */
public class ZookeeperTest {

    public static void main(String[] args) {

        try {
            /**
             * 计数器同步工具类，为了保证连接到服务器之后在进行增删改成的动作
             */
            final CountDownLatch countDownLatch = new CountDownLatch(1);

            ZooKeeper zooKeeper = new ZooKeeper("192.168.11.153:2181,192.168.11.154:2181,192.168.11.155:2181",4000, new Watcher() {

                /**
                 * zk自带的监听机制
                 * @param event
                 */
                @Override
                public void process(WatchedEvent event) {
                if(Event.KeeperState.SyncConnected == event.getState()){//如果收到了服务端的响应事件，连接成功
                    countDownLatch.countDown();
                }
            }});

            countDownLatch.await();
            /**
             * 使用上述的方式这里打印的状态将确保是CONNECTED
             */
            System.out.println(zooKeeper.getState());//CONNECTING

            /**
             * 创建节点
             * 可以指定节点的value,特性,权限
             */
            zooKeeper.create("/zk-persis-mic","0".getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT);
            Thread.sleep(1000);
            Stat stat=new Stat();//节点特性

            /**
             * 查询节点的value值
             */
            byte[] bytes=zooKeeper.getData("/zk-persis-mic",null,stat);
            System.out.println(new String(bytes));

            /**
             * 修改节点的值，要在同一版本号下面
             */
            zooKeeper.setData("/zk-persis-mic","1".getBytes(),stat.getVersion());

            /**
             * 删除节点
             */
            zooKeeper.delete("/zk-persis-mic",stat.getVersion());

            zooKeeper.close();


            /**
             * 下面使用Curator客户端来操作ZooKeeper
             * 建立连接和增删改查
             */
            RetryPolicy retryPolicy = new ExponentialBackoffRetry(1000, 3);
            CuratorFramework client = CuratorFrameworkFactory.newClient("10.23.22.237:2181", retryPolicy);
            client.start();

            byte[] data = { 1, 2, 3 };
            /**
             * 创建持久化节点
             * 创建临时节点
             * 创建持久化时序节点
             * 创建临时时序节点
             * 设置节点数据
             * 获取节点数据
             */
            client.create().withMode(CreateMode.PERSISTENT).forPath("/zktest/p1", data);
            client.create().withMode(CreateMode.EPHEMERAL).forPath("/zktest/e1", data);
            client.create().withMode(CreateMode.PERSISTENT_SEQUENTIAL).forPath("/zktest/ps1", data);
            client.create().withMode(CreateMode.EPHEMERAL_SEQUENTIAL).forPath("/zktest/es1", data);
            client.setData().forPath("/zktest/ps1", data);
            byte[] data2 = client.getData().forPath("/zktest/ps1");

        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch(KeeperException e){
            e.printStackTrace();
        } catch (Exception e){
            e.printStackTrace();
        }
    }

}
