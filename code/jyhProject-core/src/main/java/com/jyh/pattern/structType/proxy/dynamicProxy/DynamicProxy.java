package com.jyh.pattern.structType.proxy.dynamicProxy;

import com.google.common.collect.Lists;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.List;
import java.util.UUID;

/**
 * 动态代理角色，实现jdk自带的角色实现动态代理模式
 */
public class DynamicProxy implements InvocationHandler {

    private List<String> remoteIp = Lists.newArrayList("192.168.1.1", "192.168.1.2");

    private Object obj;

    public DynamicProxy(Object obj){
        this.obj = obj;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        String remoteIpId = UUID.randomUUID().toString();
        int index = Math.abs(remoteIpId.hashCode()) % remoteIp.size();
        String ip = remoteIp.get(index);

        StringBuilder sb = new StringBuilder();
        sb.append("标题: ");
        sb.append(method.invoke(obj,args));
        sb.append(" Ip: ");
        sb.append(ip);
        return sb.toString();
    }
}
