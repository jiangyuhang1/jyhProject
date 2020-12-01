package com.jyh.pattern.actionType.command;

/**
 * 宏命令模式下客户端
 */
public class MacroCommandClient {

    public static void main(String[] args) {

        Receiver receiver = new Receiver();
        Command command = new ConcreteCommand(receiver);

        /**
         * 通过一个新接口来管理命令角色
         */
        MacroCommand macroCommand = new ConcreteMacroCommand();
        macroCommand.add(command);

        Invoker invoker = new Invoker(macroCommand);

        invoker.invoke();
    }
}
