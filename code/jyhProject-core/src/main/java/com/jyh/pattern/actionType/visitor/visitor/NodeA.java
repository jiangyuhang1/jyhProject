package com.jyh.pattern.actionType.visitor.visitor;

public class NodeA extends Node{

    @Override
    public void accept(Visitor visitor) {
        visitor.visitor(this);
    }

    public String getNodeA(){
        return "NodeA";
    }
}
