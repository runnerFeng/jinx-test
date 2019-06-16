package com.common.test.demo34_enum;

/**
 * @Author: jinx
 * @Date: 2019-05-30 14:17
 * @Desc:
 */
public class Color1 {
    public static final Color1 RED = new Color1(1){
        public void test(){

        }
    };
    public static final Color1 GREEN = new Color1(1);
    public static final Color1 BLUE = new Color1(1);
    public static final Color1 YELLOW = new Color1(1);
    private int state;

    public Color1(int state) {
        this.state = state;
    }
}
