package com.jyh.pattern.actionType.command;

/**
 * 命令模式客户端
 * 模拟一个人按不同的按键使录音机可以做出不同的动作
 * 优点:解耦，将调用者和接收者隔离开来，将一组动作封装在命令角色中
 */
public class CommandClient {

    public static void main(String[] args) {
        Receiver receiver = new Receiver();
        Command command = new ConcreteCommand(receiver);
        Invoker invoker = new Invoker(command);

        invoker.invoke();
    }
}
