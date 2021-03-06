package com.common.test.demo29_byteConvert;

import java.math.BigInteger;
import java.util.Scanner;

/**
 * @author jinx
 * @date 2018/6/13 18:23
 * Desc:int十进制到其他进制转换
 */
public class TenToOther {
    public static void main(String[] args) {
        // 测试用例
        TenToOther t = new TenToOther();
        Scanner sc = new Scanner(System.in);
        String[] str = sc.nextLine().split(" ");
        int[] a = new int[str.length];
        for (int i = 0; i < str.length; i++) {
            a[i] = Integer.parseInt(str[i]);
        }
        t.transform(a[0], a[1]);

        BigInteger s = new BigInteger("1");
    }

    public void transform(int num, int n) {
        //参数num为输入的十进制数，参数n为要转换的进制
        int array[] = new int[100];
        int count = 0;
        int location = 0;
        while (num != 0) {//当输入的数不为0时循环执行求余和赋值
            int remainder = num % n;
            num = num / n;
            array[location] = remainder;//将结果加入到数组中去
            location++;
            count++;
        }
        show(array, location - 1, count);
    }

    private void show(int[] arr, int n, int count) {
        for (int i = n; i >= 0; i--) {
            if (arr[i] < 0) {
                for (int j = 0; j < count - 1; j++) {
                    arr[j] = Math.abs(arr[j]);
                }
            }
            if (arr[i] > 9 || arr[i] < -9) {
                System.out.print((char) (arr[i] + 55));
            } else {
                System.out.print(arr[i] + "");
            }
        }
    }

}
