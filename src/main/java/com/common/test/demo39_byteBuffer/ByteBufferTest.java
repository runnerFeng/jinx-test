package com.common.test.demo39_byteBuffer;


import java.nio.ByteBuffer;

/**
 * @Author: Aug
 * @Date: 2020-09-18 16:03
 * @Desc: 一种幂等手段
 */
public class ByteBufferTest {

    public static void main(String[] args) {
        test();
    }

    public static void test(){
        ByteBuffer buffer = ByteBuffer.allocate(256);
        buffer.put((byte) 'a').put((byte) 'b');
        System.out.println(buffer.toString());

        buffer.flip();
        System.out.println(buffer.toString());

        System.out.println(buffer.get());
        System.out.println(buffer.toString());

        System.out.println(buffer.get(0));
        System.out.println(buffer.toString());


    }
}
