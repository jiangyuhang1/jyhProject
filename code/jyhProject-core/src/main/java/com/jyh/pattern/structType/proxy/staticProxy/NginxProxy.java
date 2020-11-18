package com.jyh.pattern.structType.proxy.staticProxy;

import com.google.common.collect.Lists;
import java.util.List;
import java.util.UUID;

/**
 * 代理角色，持有目标对象的引用，通过代理角色处理目标对象的方法,还可以增加一些目标角色不具备的功能
 * 一般大型网站都是分布式系统，很多台服务器都部署了应用，然后部署了nginx，可以随机的指向不同的服务器应用工作
 * 一般都是客户端直接访问的代理服务器，然后在代理服务器在到真正的服务器工作
 */
public class NginxProxy implements Server{
    private List<String> baiduIP = Lists.newArrayList("192.168.1.1", "192.168.1.2");

    private Server server;

    public NginxProxy(Server server){
        this.server = server;
    }

    @Override
    public String getTitle(String url) {
        /**
         * 简单的UUID取模，随机找一个设定的ip，模拟nginx路由算法
         */
        String removeIpId = UUID.randomUUID().toString();
        int index = Math.abs(removeIpId.hashCode()) % baiduIP.size();
        String ip = baiduIP.get(index);

        return "标题: " + server.getTitle(url) + "Ip: " + ip;
    }
}
