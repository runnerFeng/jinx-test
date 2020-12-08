package com.common.test.demo39_byteBuffer;


import java.nio.ByteBuffer;

/**
 * @Author: Aug
 * @Date: 2020-09-18 16:03
 * @Desc:
 */
public class ByteBufferTest {

    public static void main(String[] args) {
        test();
    }

    public static void test(){
        ByteBuffer buffer = ByteBuffer.allocate(256);
        buffer.put((byte) 'a').put((byte) 'b');
        System.out.println(buffer);

        buffer.flip();
        System.out.println(buffer);

        System.out.println(buffer.get());
        System.out.println(buffer);

        System.out.println(buffer.get(0));
        System.out.println(buffer);


    }
}
