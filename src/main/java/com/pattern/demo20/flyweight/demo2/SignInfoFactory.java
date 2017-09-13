package com.pattern.demo20.flyweight.demo2;

import java.util.HashMap;

/**
 * Desc:
 * Created by jinx on 2017/9/7.
 */
public class SignInfoFactory {
    private static HashMap<String, SignInfo> pool = new HashMap<>();

    @Deprecated
    public static SignInfo getSignInfo() {
        return new SignInfo();
    }

    public static SignInfo getSignInfo(String key) {
        SignInfo signInfo = null;
        if (!pool.containsKey(key)) {
//            signInfo = new SignInfo();
            //搞不懂这行代码作用是什么，为什么不用上面实例化方式
            signInfo = new SignInfo4Poll(key);
            pool.put(key, signInfo);
            System.out.println("放入池中：" + key);
        } else {
            signInfo = pool.get(key);
            System.out.println("从池中获取：" + key);
        }
        return signInfo;
    }
}
