package com.jyh.pattern.actionType.visitor.visitor;

public class VisitorA extends Visitor{

    @Override
    public void visitor(NodeA nodeA) {
        System.out.println("VisitorA + " + nodeA.getNodeA());
    }

    @Override
    public void visitor(NodeB nodeB) {
        System.out.println("VisitorA + " + nodeB.getNodeB());
    }
}
