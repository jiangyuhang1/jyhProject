package com.jyh.pattern.actionType.command;

/**
 * 具体命令者角色
 */
public class ConcreteCommand implements Command{

    /**
     * 持有接收者引用，可以直接命令接收者
     */
    private Receiver receiver;

    public ConcreteCommand(Receiver receiver){
        this.receiver = receiver;
    }

    @Override
    public void command() {
        receiver.play();
        receiver.back();
        receiver.stop();
    }
}
