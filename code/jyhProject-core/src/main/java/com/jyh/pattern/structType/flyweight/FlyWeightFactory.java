package com.jyh.pattern.structType.flyweight;

import java.util.HashMap;
import java.util.Map;

public class FlyWeightFactory {

    /**
     * 工厂类定义一个键值对，保存内蕴状态和享元角色的对应关系
     */
    private static Map<String,FlyWeight> map = new HashMap<>();

    /**
     * 创建享元角色对象的工厂方法，传入的外蕴标识如果存在于键值对中，则取，不在新建对象
     * 如果传入的外蕴标识存在于内蕴标识中，则直接返回
     * @param state
     * @return
     */
    public static FlyWeight factory(String state){
        FlyWeight flyWeight = map.get(state);

        if(flyWeight == null){
            flyWeight = new ConcreteFlyWeight(state);
            map.put(state,flyWeight);
        }

        return flyWeight;
    }
}
