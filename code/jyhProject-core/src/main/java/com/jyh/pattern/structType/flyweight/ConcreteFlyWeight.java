package com.jyh.pattern.structType.flyweight;


/**
 * 具体享元角色
 */
public class ConcreteFlyWeight implements FlyWeight{

    /**
     * 享元角色具备的内蕴状态,当外蕴状态与内蕴状态相同，不在创建对象，返回享元工厂内存在对象
     */
    private String inState;

    public ConcreteFlyWeight(String inState){
        this.inState = inState;
    }


    @Override
    public void operation(String state) {
        System.out.println(inState);
        System.out.println(state);
    }
}
