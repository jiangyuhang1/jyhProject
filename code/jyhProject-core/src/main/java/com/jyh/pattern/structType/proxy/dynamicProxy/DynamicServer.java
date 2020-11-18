package com.jyh.pattern.structType.proxy.dynamicProxy;

/**
 * 这个一种动态代理，抽象目标角色，被代理对象的抽象接口
 */
public interface DynamicServer {

    /**
     * 根据不同url得到不同的网页标题
     * @param url
     * @return
     */
    String getTitle(String url);
}
