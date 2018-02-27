package com.common.test.alibabaDeveloperAggrement.demo1;

/**
 * @author jinx
 * @date 2018/02/08 21:56
 * Desc:npe exception分析
 * 1. Calling the instance method of a null object.
 * 2. Accessing or modifying the field of a null object.
 * 3. Taking the length of null as if it were an array.
 * 4. Accessing or modifying the slots of null as if it were an array.
 * 5. Throwing null as if it were a Throwable value.
 */
public class NPEException {
    public static void main(String[] args) {
        String s1 = null;
        String s2 = "";

        if (s1.equals(s2)) {
            /*如上第一种情况*/
            System.out.println(true);
        }
        if (s2.equals(s1)) {
            System.out.println(false);
        }

        /*如上第一种情况，即null不能调用任何方法，否则npe*/
        System.out.println(s1.length());
    }
}
