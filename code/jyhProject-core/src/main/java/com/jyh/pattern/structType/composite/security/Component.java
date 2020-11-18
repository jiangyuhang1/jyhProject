package com.jyh.pattern.structType.composite.security;

/**
 * 组合模式，抽象构件角色
 * 合成模式是将部分和整体的关系使用树形结构表示出来
 * 该接口的作用是抽象出树枝和叶子的公共方法
 */
public interface Component {

    void printStruct(String preStr);
}
