package com.common.test.demo19_generic;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

/**
 * @author jinx
 * @date 2018/2/5 17:30
 * Desc:getGenericSuperclass
 */
public class BaseHibernateDao<T,ID extends Serializable>{
    private Class<T> clazz;

    public BaseHibernateDao() {
        //获取带有泛型的父类
        System.out.println(getClass());
        Type genericSuperclass = getClass().getGenericSuperclass();
        //是否是参数化类型，即泛型
        if (genericSuperclass instanceof ParameterizedType){
            //获取泛型的参数列表中的第一个
            this.clazz = (Class<T>) ((ParameterizedType) genericSuperclass).getActualTypeArguments()[0];
        }else {
            this.clazz = (Class<T>) genericSuperclass;
        }
    }

    public Class<T> getClazz(){
        return this.clazz;
    }

//    Iterable
//    DirectoryStream
//    Collection
//    List
//    Set
//    Reader
}
