package com.pattern.demo10.command.demo2;

/**
 * Desc:
 * Created by jinx on 2017/8/27.
 */
public class DeletePageCommand extends Command {
    @Override
    public void execute() {
        super.pg.find();
        super.pg.delete();
        super.pg.plan();
    }
}
