package com.jyh.pattern.actionType.visitor.visitor;

public class VisitorB extends Visitor{

    @Override
    public void visitor(NodeA nodeA) {
        System.out.println("VisitorB + " + nodeA.getNodeA());
    }

    @Override
    public void visitor(NodeB nodeB) {
        System.out.println("VisitorB + " + nodeB.getNodeB());
    }
}
