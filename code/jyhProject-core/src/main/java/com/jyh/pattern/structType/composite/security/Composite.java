package com.jyh.pattern.structType.composite.security;

import java.util.ArrayList;
import java.util.List;

/**
 * 树枝构件角色
 */
public class Composite implements Component{

    private List<Component> childList = new ArrayList<Component>();

    private String name;

    public Composite(String name){
        this.name = name;
    }

    public void addChild(Component component){
        childList.add(component);
    }

    public void removeChild(int index){
        childList.remove(index);
    }

    public List<Component> getChild(){
        return childList;
    }

    @Override
    public void printStruct(String preStr) {
        System.out.println(preStr + "+" + this.name);
        if(this.childList != null){
            preStr += "  ";
            for(Component component : childList){
                component.printStruct(preStr);
            }
        }
    }
}
