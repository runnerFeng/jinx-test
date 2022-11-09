package com.audition.demo9;

import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * @Author jinx
 * @Date 2022/7/5
 * @Desc 队列实现栈功能:两个队列实现，一个做临时队列
 */
public class Test {
    static Queue<Integer> queue1 = new LinkedBlockingQueue();
    static Queue<Integer> queue2 = new LinkedBlockingQueue();
    static Queue<Integer> queue3 = new LinkedBlockingQueue();

    public static void main(String[] args) throws InterruptedException {
        push(1);
        push(2);
        push(3);
        System.out.println(queue1);
        System.out.println(queue2);
        System.out.println(queue1.poll());

        push2(1);
        push2(2);
        push2(3);
        System.out.println(queue3);

        int i = 0;
        while (true) {
            System.out.println(i++);
        }
    }

    /**
     * 两个队列实现，一个做临时队列
     */
    public static void push(int x) {
        // 1.入列临时队列二
        queue2.offer(x);
        // 2.将队列一的所有元素移动到队列二
        while (!queue1.isEmpty()) {
            queue2.offer(queue1.poll());
        }
        // 3.队列一和队列二互换
        Queue<Integer> temp = queue1;
        queue1 = queue2;
        queue2 = temp;
    }

    /**
     * 单个队列实现，除队尾的所有元素重新入队列
     *
     * @return
     */
    public static void push2(int x) {
        int count = queue3.size();
        queue3.offer(x);
        for (int i = 0; i < count; i++) {
            queue3.offer(queue3.poll());
        }
    }


    public int pop() {
        return queue1.poll();
    }
}
