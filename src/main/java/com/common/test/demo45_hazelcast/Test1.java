package com.common.test.demo45_hazelcast;

import com.hazelcast.client.HazelcastClient;
import com.hazelcast.core.HazelcastInstance;
import com.hazelcast.map.IMap;
import lombok.extern.slf4j.Slf4j;

/**
 * @Author: fans
 * @Date: 2021/5/27 00:33
 * @Desc:
 */
@Slf4j
public class Test1 {
    public static void main(String[] args) {
        HazelcastInstance hz = HazelcastClient.newHazelcastClient();
        IMap<String, String> map = hz.getMap("my-distributed-map");

        long t1 =System.currentTimeMillis()*1000;
        log.info("t1:{}",t1);

        map.put("key", "value");
        map.get("key");
        long t2 = System.currentTimeMillis()*1000-t1;
        log.info("t2:{}",t2);
    }
}
