package com.imooc.pattern.demo4_protoType;

import java.io.*;

/**
 * Desc:原型模式
 * 原型模式虽然是创建型的模式，但是与工程模式没有关系，从名字即可看出，该模式的思想就是将一个对象作为原型，对其进行复制、克隆，产生一个和原对象类似的新对象
 * Created by jinx on 2017/6/8.
 */
public class ProtoType implements Cloneable, Serializable {


    private static final long serialVersionUID = 4969688069579960601L;
    private String string;
    private Serializable obj;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    //浅复制
    public Object clone() throws CloneNotSupportedException {
        ProtoType protoType = (ProtoType) super.clone();
        return protoType;
    }

    //深度复制
    public Object deepClone() throws IOException, ClassNotFoundException {
         /* 写入当前对象的二进制流 */
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        ObjectOutputStream oos = new ObjectOutputStream(bos);
        oos.writeObject(this);

        /* 读出二进制流产生的新对象 */
        ByteArrayInputStream bis = new ByteArrayInputStream(bos.toByteArray());
        ObjectInputStream ois = new ObjectInputStream(bis);
        return ois.readObject();
    }

    public String getString() {
        return string;
    }

    public void setString(String string) {
        this.string = string;
    }

    public Serializable getObj() {
        return obj;
    }

    public void setObj(Serializable obj) {
        this.obj = obj;
    }
}
