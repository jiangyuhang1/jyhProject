package com.jyh.pattern.structType.composite.transparent;

import java.util.ArrayList;
import java.util.List;

public class TransparentComposite extends TransparentCompent{

    private List<TransparentCompent> childList = new ArrayList<>();

    private String name;

    public TransparentComposite(String name){
        this.name = name;
    }

    @Override
    public void addChild(TransparentCompent tc) {
        childList.add(tc);
    }

    @Override
    public List<TransparentCompent> getChild() {
        return childList;
    }

    @Override
    public void removeChild(int index) {
        childList.remove(index);
    }

    @Override
    public void print(String preStr) {
        System.out.println(preStr + "+" + this.name);
        if(this.childList != null){
            preStr += "  ";
            for(TransparentCompent tc : this.childList){
                tc.print(preStr);
            }
        }

    }
}
