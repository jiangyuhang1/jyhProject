package com.jyh.pattern.actionType.command;

/**
 * 宏命令接口，继承命令接口
 */
public interface MacroCommand extends Command{

    void add(Command command);

    void remove(Command command);
}
