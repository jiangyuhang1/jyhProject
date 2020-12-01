package com.jyh.pattern.actionType.visitor.visitor;

import java.util.ArrayList;
import java.util.List;

public class NodeStructure {

    List<Node> nodeList = new ArrayList<>();

    public void setNodeList(Node node){
        nodeList.add(node);
    }

    public void action(Visitor visitor){
        for(Node node : nodeList){
            node.accept(visitor);
        }
    }
}
