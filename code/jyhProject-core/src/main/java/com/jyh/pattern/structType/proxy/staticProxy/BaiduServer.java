package com.jyh.pattern.structType.proxy.staticProxy;

/**
 * 具体目标角色，被代理的具体目标对象
 */
public class BaiduServer implements Server{

    @Override
    public String getTitle(String url) {

        if("http://news.baidu.com".equals(url)){
            return "百度新闻";
        }else if("https://tieba.baidu.com".equals(url)){
            return "百度贴吧";
        }

        return "404 Not Found!";
    }
}
