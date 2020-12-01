package com.jyh.pattern.actionType.command;

import java.util.ArrayList;
import java.util.List;

/**
 * 维护一组命令角色，具体宏命令角色
 */
public class ConcreteMacroCommand implements MacroCommand{

    private List<Command> commandList = new ArrayList<>();

    @Override
    public void add(Command command) {
        commandList.add(command);
    }

    @Override
    public void remove(Command command) {
       commandList.remove(command);
    }

    @Override
    public void command() {
        for(Command command : commandList){
            command.command();
        }
    }
}
