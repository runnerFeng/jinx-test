package com.pattern.demo4_factory.abstractFactory;

/**
 * Desc:
 * Created by jinx on 2017/8/9.
 */
public abstract class AbstractHumanFactory implements HumanFactory {

    protected Human createHuman(HumanEnum humanEnum) {
        Human human = null;
        if (!"".equals(humanEnum.getValue())) {
            try {
                human = (Human) Class.forName(humanEnum.getValue()).newInstance();
            } catch (InstantiationException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
        return human;
    }

}
