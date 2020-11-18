package com.jyh.pattern.structType.composite.security;

/**
 * 安全式组合模式
 * 1.树枝类包括有addChild,removeChild,getChild,树叶没有这些方法，是种安全的做法
 * 2.这种做法为了保证叶子角色类不包含上述方法，所以实现的接口不能定义这三个方法，在客户端调用的时候
 *   不能够使用Component去new树枝和叶子对象,new出来的对象，调用上述三个方法会编译错误
 */
public class Client {

    public static void main(String[] args) {
        Composite root = new Composite("服装");
        Composite c1 = new Composite("男装");
        Composite c2 = new Composite("女装");

        Leaf leaf1 = new Leaf("衬衫");
        Leaf leaf2 = new Leaf("夹克");
        Leaf leaf3 = new Leaf("裙子");
        Leaf leaf4 = new Leaf("套装");

        root.addChild(c1);
        root.addChild(c2);
        c1.addChild(leaf1);
        c1.addChild(leaf2);
        c2.addChild(leaf3);
        c2.addChild(leaf4);

        root.printStruct("");
    }
}
