package com.pattern.demo10.command.demo2;

/**
 * Desc:
 * Created by jinx on 2017/8/27.
 */
public class Invoker {
    private Command command;

    public void setCommand(Command command) {
        this.command = command;
    }

    public void action() {
        this.command.execute();
    }
}
