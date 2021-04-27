package com.pattern.demo10_command.demo2;

/**
 * Desc:
 * Created by jinx on 2017/8/27.
 */
public class AddRequirementCommand extends Command {
    @Override
    public void execute() {
        super.rg.find();
        super.rg.add();
        super.rg.plan();
    }
}
