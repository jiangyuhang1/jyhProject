package com.jyh.pattern.actionType.iterator;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/**
 * map遍历方法测试
 */
public class IteratorMap {

    public static void main(String[] args) {
        Map<Integer,String> map = new HashMap<Integer, String>();
        map.put(1,"a");
        map.put(2,"b");
        map.put(3,"c");

        /**
         * 遍历key值
         */
        for(Integer i : map.keySet()){
            System.out.println(i);

            /**
             * 通过key在获取value
             */
            System.out.println(map.get(i));
        }

        /**
         * 遍历value值
         */
        for(String s : map.values()){
            System.out.println(s);
        }

        /**
         * 遍历键值对，entrySet
         */
        for(Map.Entry<Integer,String> entry : map.entrySet()){
            System.out.println(entry.getKey() + ":" +entry.getValue());
        }

        /**
         * 使用迭代器
         */
        Set set = map.entrySet();
        Iterator iterator = set.iterator();

        while (iterator.hasNext()){
            Map.Entry<Integer,String> entry = (Map.Entry<Integer,String>)iterator.next();
            System.out.println(entry.getKey() + ":" + entry.getValue());
        }


        /**
         * 使用java8新特性实现
         */
        map.entrySet().forEach(entry -> System.out.println(entry.getKey() + ":" + entry.getValue()));
        map.keySet().forEach(k -> System.out.println(k + ":" + map.get(k)));
        map.values().forEach(System.out::println);
        map.forEach((k,v) -> System.out.println(k + ":" + v));
    }
}
