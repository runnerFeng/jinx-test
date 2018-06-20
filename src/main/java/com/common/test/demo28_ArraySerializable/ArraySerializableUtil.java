package com.common.test.demo28_ArraySerializable;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 * @author jinx
 * @date 2018/6/13 16:33
 * Desc:数组序列化，反序列化工具
 */
public class ArraySerializableUtil {
    public static String encode(int[][] array) throws Exception {
        String result ;
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        ObjectOutputStream oos = new ObjectOutputStream(bos);
        oos.writeObject(array);
        oos.flush();
        oos.close();
        byte[] b = bos.toByteArray();
        BASE64Encoder base64 = new BASE64Encoder();
        result = base64.encode(b);
        return result;
    }

    public static int[][] decode(String s) throws Exception {
        int[][] result = null;
        BASE64Decoder base64 = new BASE64Decoder();
        byte[] b = base64.decodeBuffer(s);
        ByteArrayInputStream bis = new ByteArrayInputStream(b);
        ObjectInputStream ois = new ObjectInputStream(bis);
        result = (int[][]) ois.readObject();
        ois.close();
        return result;
    }

    public static void main(String[] args) {
        int[][] array = new int[][] { { 1, 2, 3 }, { 4, 5 } };
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                if (j != 0) {
                    System.out.print(",");
                }
                System.out.print(array[i][j]);
            }
            System.out.println();
        }
        try {
            String s = encode(array);
            System.out.println(s);
            int[][] array2 = decode(s);

            for (int i = 0; i < array2.length; i++) {
                for (int j = 0; j < array2[i].length; j++) {
                    if (j != 0) {
                        System.out.print(",");
                    }
                    System.out.print(array2[i][j]);
                }
                System.out.println();
            }
        } catch (Exception e) {
        }

    }
}
