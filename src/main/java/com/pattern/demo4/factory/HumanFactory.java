package com.pattern.demo4.factory;

/**
 * Desc:
 * Created by jinx on 2017/8/7.
 */
public class HumanFactory {

public static Human createHuman(Class c){
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
    return  null;
}

}
