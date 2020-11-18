package com.jyh.pattern.structType.composite.security;

import java.util.ArrayList;
import java.util.List;

/**
 * 叶子角色
 */
public class Leaf implements Component{

    private String name;

    public Leaf(String name){
        this.name = name;
    }

    @Override
    public void printStruct(String preStr) {
        System.out.println(preStr + "-" + name);
    }
}
