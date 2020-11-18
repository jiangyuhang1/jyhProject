package com.jyh.pattern.structType.proxy.staticProxy;

/**
 * 抽象目标角色，被代理对象的抽象接口
 */
public interface Server {

    /**
     * 根据不同url得到不同的网页标题
     * @param url
     * @return
     */
    String getTitle(String url);
}
