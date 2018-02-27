package com.common.test.demo22_reflection;

/**
 * @author jinx
 * @date 2018/2/27 15:30
 * Desc:
 */
public class Model extends ParentModel {
    private String privateField;
    public String publicField;
    protected String protectedField;

    public String getPrivateField() {
        return privateField;
    }

    public void setPrivateField(String privateField) {
        this.privateField = privateField;
    }

    public String getPublicField() {
        return publicField;
    }

    public void setPublicField(String publicField) {
        this.publicField = publicField;
    }

    public String getProtectedField() {
        return protectedField;
    }

    public void setProtectedField(String protectedField) {
        this.protectedField = protectedField;
    }
}
