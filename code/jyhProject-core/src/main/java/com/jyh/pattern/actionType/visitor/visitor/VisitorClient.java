package com.jyh.pattern.actionType.visitor.visitor;

/**
 * 访问者模式
 */
public class VisitorClient {

    public static void main(String[] args) {

        NodeStructure ns = new NodeStructure();
        Node nodeA = new NodeA();
        Node nodeB = new NodeB();
        ns.setNodeList(nodeA);
        ns.setNodeList(nodeB);

        Visitor visitorA = new VisitorA();
        Visitor visitorB = new VisitorB();
        ns.action(visitorA);
        ns.action(visitorB);
    }
}
