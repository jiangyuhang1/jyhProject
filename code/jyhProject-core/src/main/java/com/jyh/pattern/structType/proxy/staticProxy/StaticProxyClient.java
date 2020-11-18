package com.jyh.pattern.structType.proxy.staticProxy;

/**
 * 静态代理模式客户端
 * 缺陷:1.该代理模式代理角色只持有了server接口的引用，在需要代理的对象变得越来越多，就需要不断扩展代理角色
 *      必定会造成代码越来越多，维护越来越麻烦
 * 优点:2.简单易理解
 */
public class StaticProxyClient {

    public static void main(String[] args) {
        Server server = new BaiduServer();
        Server nginxProxy = new NginxProxy(server);

        System.out.println(nginxProxy.getTitle("http://news.baidu.com"));
    }

}
