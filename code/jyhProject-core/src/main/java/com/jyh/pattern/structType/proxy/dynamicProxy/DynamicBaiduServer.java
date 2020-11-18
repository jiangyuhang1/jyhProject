package com.jyh.pattern.structType.proxy.dynamicProxy;

/**
 * 动态代理，具体目标角色
 */
public class DynamicBaiduServer implements DynamicServer{

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
