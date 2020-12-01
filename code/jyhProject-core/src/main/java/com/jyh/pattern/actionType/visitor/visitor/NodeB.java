package com.jyh.pattern.actionType.visitor.visitor;

public class NodeB extends Node{

    @Override
    public void accept(Visitor visitor) {
        visitor.visitor(this);
    }

    public String getNodeB(){
        return "NodeB";
    }
}
