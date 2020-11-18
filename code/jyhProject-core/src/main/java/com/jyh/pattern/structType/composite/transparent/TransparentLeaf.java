package com.jyh.pattern.structType.composite.transparent;

public class TransparentLeaf extends TransparentCompent{

    private String name;

    public TransparentLeaf(String name){
        this.name = name;
    }

    @Override
    public void print(String preStr) {
        System.out.println(preStr + "+" + name);
    }
}
