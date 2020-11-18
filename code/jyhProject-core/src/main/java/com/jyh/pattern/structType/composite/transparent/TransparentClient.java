package com.jyh.pattern.structType.composite.transparent;

/**
 * 透明式组合模式
 * 体现:1.所有的树枝和叶子角色均可以使用抽象化构件角色去new对象
 *       不需要具体对象具体角色去实例
 *     2.合成模式更看重的是透明性，客户端可以将树枝和叶子看成一个整体，这正是合成模式所强调的
 */
public class TransparentClient {

    public static void main(String[] args) {
        TransparentCompent root = new TransparentComposite("服装");
        TransparentCompent tc1 = new TransparentComposite("男装");
        TransparentCompent tc2 = new TransparentComposite("女装");

        TransparentCompent leaf1 = new TransparentLeaf("夹克");
        TransparentCompent leaf2 = new TransparentLeaf("衬衫");
        TransparentCompent leaf3 = new TransparentLeaf("裙子");
        TransparentCompent leaf4 = new TransparentLeaf("套装");

        root.addChild(tc1);
        root.addChild(tc2);
        tc1.addChild(leaf1);
        tc1.addChild(leaf2);
        tc2.addChild(leaf3);
        tc2.addChild(leaf4);

        root.print("");
    }
}
