package com.leetcode.algorithm.chacpter2.demo6_lruCache.method2;
import cn.hutool.json.JSONUtil;
import lombok.extern.slf4j.Slf4j;

/**
 * @Author: Aug
 * @Date: 2021-02-05 18:22
 * @Desc:
 */
@Slf4j
public class Test {

    public static void main(String[] args) {
        LruCache lruCache = new LruCache(2);
        lruCache.put(1, 1);
        lruCache.put(2, 2);
        log.info(JSONUtil.toJsonStr(lruCache));

        int value = lruCache.get(1);
        log.info("value:{}", value);

        int value2 = lruCache.get(2);
        log.info("value2:{}", value2);

        int value3 = lruCache.get(3);
        log.info("value3:{}", value3);

        // 这步操作会将链表头部元素挤掉
        lruCache.put(3,3);
        log.info(JSONUtil.toJsonStr(lruCache));

        int value4 = lruCache.get(2);
        log.info("value4:{}", value4);
    }

}
