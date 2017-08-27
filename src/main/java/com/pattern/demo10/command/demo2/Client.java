package com.pattern.demo10.command.demo2;

/**
 * Desc:
 * Created by jinx on 2017/8/27.
 */
public class Client {
    public static void main(String[] args) {
        Invoker xiaosan = new Invoker();

//        Command command = new AddRequirementCommand();
        Command command = new DeletePageCommand();
        xiaosan.setCommand(command);
        xiaosan.action();
    }
}
