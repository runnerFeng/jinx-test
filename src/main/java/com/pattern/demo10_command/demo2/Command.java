package com.pattern.demo10_command.demo2;

import com.pattern.demo10_command.demo1.CodeGroup;
import com.pattern.demo10_command.demo1.PageGroup;
import com.pattern.demo10_command.demo1.RequirementGroup;

/**
 * Desc:
 * Created by jinx on 2017/8/27.
 */
public abstract class Command {
    protected RequirementGroup rg = new RequirementGroup();
    protected PageGroup pg = new PageGroup();
    protected CodeGroup cg = new CodeGroup();

    public abstract void execute();
}
