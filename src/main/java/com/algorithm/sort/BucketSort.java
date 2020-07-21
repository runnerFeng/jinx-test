package com.algorithm.sort;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

/**
 * @author jinx
 * @date 2019/2/18 14:16
 * Desc:桶排序.基本思想：把数组划分为几个大小相同的子区间(第一次简单排序)，每个子区间各自排序(第二次排序)最后合并。
 */
public class BucketSort {

    public static void main(String[] args) {
        float[] arr = new float[]{0.12f, 2.2f, 8.8f, 7.6f, 7.2f, 6.3f, 9.0f, 1.6f, 5.6f, 2.4f};
        bucketSort(arr);
        for (float v : arr) {
            System.out.println(v);
        }
    }

    private static void bucketSort(float[] a) {
        // 定义桶的数量
        int bucketCount = 10;
        // 新建桶集合
        List<LinkedList<Float>> buckets = new ArrayList<>();
        for (int i = 0; i < bucketCount; i++) {
            // 新建桶并将其加到桶集合中
            buckets.add(new LinkedList<>());
        }

        // 将输入数据全部放入桶中并完成排序
        for (float v : a) {
            int index = getBucketIndex(v);
            insertSort(buckets.get(index), v);
        }

        int index = 0;
        for (LinkedList<Float> bucket : buckets) {
            for (Float aFloat : bucket) {
                a[index++] = aFloat;
            }
        }
    }

    /**
     * 计算输入元素应该放在哪个桶中
     *
     * @param v 待计算元素
     * @return 该元素在具体哪个桶中
     */
    private static int getBucketIndex(float v) {
        // 此处已经进行了一次排序，即：0.12f只能在第一个桶中，1.6，只能在第二个桶中，2.2,2.4只能在第三个桶中...
        // 此处简单处理，实际中需根据具体情况设计
        return (int) v;
    }

    /**
     * 我们选择插入排序作为桶内元素排序的方法 每当有一个新元素到来时，我们都调用该方法将其插入到恰当的位置
     *
     * @param bucket 桶
     * @param v      待插入元素
     */
    private static void insertSort(List<Float> bucket, float v) {
        ListIterator<Float> it = bucket.listIterator();
        boolean insertFlag = true;
        while (it.hasNext()) {
            if (v <= it.next()) {
                // 把迭代器的位置偏移回上一个位置
                it.previous();
                // 把数据插入到迭代器的当前位置
                it.add(v);
                insertFlag = false;
                break;
            }
        }
        if (insertFlag) {
            bucket.add(v);
        }
    }

}
