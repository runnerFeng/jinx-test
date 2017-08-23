package com.alogrithm.sort;

/**
 * Desc:冒泡排序
 * Created by lf on 2017/2/7
 */
public class BubbleSort {
    public static void main(String[] args) {
        int score[] = {101, 69, 75, 87, 82, 90, 99, 100};
        for (int i = 0; i < score.length - 1; i++) {//控制趟数
            for (int j = 0; j < score.length - (i + 1); j++) {//控制次数
                if (score[j] < score[j + 1]) {
                    int temp = score[j];
                    score[j] = score[j + 1];
                    score[j + 1] = temp;
                }
            }

            System.out.println("第" + (i + 1) + "次排序结果：");
            for (int a = 0; a < score.length; a++) {
                System.out.print(score[a] + "\t");
            }
            System.out.println("");
        }
        System.out.println("最终排序结果：");
        for (int a = 0; a < score.length; a++) {
            System.out.print(score[a] + "\t");
        }
    }
}
