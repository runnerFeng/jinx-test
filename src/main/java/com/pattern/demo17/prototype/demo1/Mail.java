package com.pattern.demo17.prototype.demo1;

import lombok.Data;

/**
 * Desc:
 * Created by jinx on 2017/9/3.
 */
@Data
public class Mail {
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
}
