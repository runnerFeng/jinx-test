package com.common.test.demo22_reflection;

/**
 * @author jinx
 * @date 2018/2/27 15:29
 * Desc:
 */
public class ParentModel {
    private String p_privateField;
    public String p_publicField;
    protected String p_protectedField;

    public String getP_privateField() {
        return p_privateField;
    }

    public void setP_privateField(String p_privateField) {
        this.p_privateField = p_privateField;
    }

    public String getP_publicField() {
        return p_publicField;
    }

    public void setP_publicField(String p_publicField) {
        this.p_publicField = p_publicField;
    }

    public String getP_protectedField() {
        return p_protectedField;
    }

    public void setP_protectedField(String p_protectedField) {
        this.p_protectedField = p_protectedField;
    }
}
