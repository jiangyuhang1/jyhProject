package com.jyh.pattern.structType.composite.transparent;


import java.util.List;

/**
 * 透明式组合模式，使用抽象类来定义抽象构件角色
 */
public abstract class TransparentCompent {

    public void addChild(TransparentCompent tc){}

    public void removeChild(int index){}

    public List<TransparentCompent> getChild(){
        return null;
    }

    public abstract void print(String preStr);
}
