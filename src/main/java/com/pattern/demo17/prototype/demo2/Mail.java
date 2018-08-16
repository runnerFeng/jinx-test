package com.pattern.demo17.prototype.demo2;


import lombok.Data;

/**
 * Desc:
 * Created by jinx on 2017/9/3.
 */
@Data
public class Mail implements Cloneable {
    private String receiver;
    private String context;
    private String subject;
    /**
     * 名称，产品名称
     */
    private String appellation;
    private String tail;

    public Mail(AdvTemplate advTemplate) {
        this.context = advTemplate.getAdvContext();
        this.subject = advTemplate.getAdvSubject();
    }

    /**
     * 浅克隆，对基本数据类型进行了克隆，对对象的引用，数组等不会进行克隆
     */
    @Override
    protected Mail clone() {
        Mail mail = null;
        try {
            mail = (Mail) super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return mail;
    }


}
