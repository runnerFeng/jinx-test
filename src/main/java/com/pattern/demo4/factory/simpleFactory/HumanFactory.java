package com.pattern.demo4.factory.simpleFactory;

import java.util.List;
import java.util.Random;

/**
 * Desc:
 * Created by jinx on 2017/8/7.
 */
public class HumanFactory {

    public static Human createHuman(Class c) {
        Human human = null;
        try {
            human = (Human) Class.forName(c.getName()).newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return human;
    }

    public static Human createHuman() {
        Human human = null;
        List<Class> concreteHumanList = ClassUtils.getAllClassByInterface(Human.class);
        Random random = new Random();
        int rand = random.nextInt(concreteHumanList.size());
        human = createHuman(concreteHumanList.get(rand));
        return human;
    }
}
