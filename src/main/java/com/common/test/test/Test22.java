package com.common.test.test;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;

import java.util.*;

/**
 * @Author jinx
 * @Date 2023/10/31
 * @Desc
 */
@Slf4j
public class Test22 {
    public static void main(String[] args) {
        // 冒泡
//        int[] array = new int[]{1, 16, 3, 20, 5};
//        bubble(array);
//        for (int i = 0; i < array.length; i++) {
//            System.out.println(array[i]);
//        }

        // 快速排序
//        int[] array = new int[]{23, 12, 45, 56, 11, 45};
//        fastSort(array, 0, array.length - 1);
//        for (int i = 0; i < array.length; i++) {
//            System.out.println(array[i]);
//        }

        // 插入排序
//        int[] array = new int[]{23, 14, 45, 56, 11, 45};
//        insertSort(array);
//        for (int i = 0; i < array.length; i++) {
//            System.out.println(array[i]);
//        }


        // 删除list中指定元素
//        List<Integer> list = new ArrayList();
//        list.add(1);
//        list.add(2);
//        list.add(2);
//        list.add(3);
//        removeList(list, 2);
//        System.out.println(list);

        // 删除map中指定元素
//        Map<String, Integer> map = new HashMap<>(16);
//        map.put("1", 1);
//        map.put("2", 2);
//        map.put("2", 2);
//        map.put("3", 3);
//        removeMap(map, "2");
//        System.out.println(map);

        // 删除链表指定元素
//        Node node1 = new Node(1);
//        Node node2 = new Node(2);
//        Node node3 = new Node(3);
//        Node node4 = new Node(2);
//        node1.next = node2;
//        node2.next = node3;
//        node3.next = node4;
//        Node node = removeNode(node1, 1);
//        System.out.println(node);

        // 反转链表
//        Node node1 = new Node(1);
//        Node node2 = new Node(2);
//        Node node3 = new Node(3);
//        node1.next = node2;
//        node2.next = node3;
//        log.info("node:{}", node1);
//        Node node = reverseNode(node1);
//        log.info("node:{}", node);

        // 合并有序链表
//        Node node1 = new Node(1);
//        Node node2 = new Node(3);
//        Node node3 = new Node(5);
//        node1.next = node2;
//        node2.next = node3;
//
//        Node node4 = new Node(2);
//        Node node5 = new Node(5);
//        Node node6 = new Node(6);
//        node4.next = node5;
//        node5.next = node6;
//        Node resultNode = mergeNode(node1, node4);
//        System.out.println(resultNode);


        // 合并两列有序数组
//        int[] array1 = new int[]{1, 3, 5};
//        int[] array2 = new int[]{2, 3, 6};
//        int[] resultArray = mergeArray(array1, array2);
//        for (int i = 0; i < resultArray.length; i++) {
//            System.out.println(result[i]);
//        }

        // 滑动窗口最大值
//        int[] array = new int[]{1, 3, 6, 2, 9, 0, 12, 4, 7};
//        int[] result = maxSlidingWindow(array, 4);
//        log.info("result:{}", result);

        // 无重复子串的最长字符串长度
//        String s = "abcdabcbb";
//        Integer length = lengthOfLongestSubString(s);
//        System.out.println(length);

        // 无重复子串的最长字符串(可能是数组)
//        String s1 = "abcdabcbb";
//        String subString = longestSubString(s1);
//        System.out.println(subString);

        // leetcode 49 字母异位词分组
        // 输入: strs = ["eat", "tea", "tan", "ate", "nat", "bat"]
        // 输出: [["bat"],["nat","tan"],["ate","eat","tea"]]
//        String[] strs = new String[]{"eat", "tea", "tan", "ate", "nat", "bat"};
//        List<List<String>> result = groupAnagrams(strs);
//        System.out.println(result);

        // leetcode 30 串联所有单词子串 hard

        // leetcode 86 分割链表 middle
        // 输入：head = [1,4,3,2,5,2], x = 3
        // 输出：[1,2,2,4,3,5]
//        Node node1 = new Node(1);
//        Node node2 = new Node(4);
//        Node node3 = new Node(3);
//        Node node4 = new Node(2);
//        Node node5 = new Node(5);
//        Node node6 = new Node(2);
//        node1.next = node2;
//        node2.next = node3;
//        node3.next = node4;
//        node4.next = node5;
//        node5.next = node6;
//        int x = 3;
//        Node result = partition(node1, x);
//        log.info("result:{}",result);

        // leetcode 16 最接近的三数之和 middle
        // 输入：nums = [-1,2,1,-4], target = 1
        // 输出：2
//        int[] nums = new int[]{-1, 2, 1, -4};
//        int target = 1;
//        int result = threeSumClosest(nums, target);
//        System.out.println(result);

        // leetcode 27 移除元素 easy
//        输入：nums = [3,2,2,3], val = 3
//        输出：2, nums = [2,2]
//        int[] nums = new int[]{3, 2, 2, 3};
//        int val = 3;
//        int result = removeElement(nums, val);
//        log.info("result:{},nums:{}", result, nums);


        // leetcode 732 我的日程安排表 III hard

        // leetcode 406 根据身高重建队列 middle
//        输入：people = [[7,0],[4,4],[7,1],[5,0],[6,1],[5,2]]
//        输出：[[5,0],[7,0],[5,2],[6,1],[4,4],[7,1]]
//        int[][] people = {{7, 0}, {4, 4}, {7, 1}, {5, 0}, {6, 1}, {5, 2}};
//        System.out.println(Arrays.deepToString(people));
//        System.out.println(people.length);
//        people = reconstructQueue(people);
//        System.out.println(Arrays.deepToString(people));


        // leetcode 899 有序队列 hard
//        输入：s = "cba", k = 1
//        输出："acb"
//        解释：
//        在第一步中，我们将第一个字符（“c”）移动到最后，获得字符串 “bac”。
//        在第二步中,我们将第一个字符（“b”）移动到最后，获得最终结果 “acb”。

//        输入 s = "baaca", k = 3
//        输出："aaabc"
//        String str = "baaca";
//        int k = 3;
//        String result = orderlyQueue(str, k);
//        System.out.println(result);


        // leetcode 946. 验证栈序列 middle
//        输入：pushed = [1,2,3,4,5], popped = [4,5,3,2,1]
//        输出：true
//        解释：我们可以按以下顺序执行：
//        push(1), push(2), push(3), push(4), pop() -> 4,
//                push(5), pop() -> 5, pop() -> 3, pop() -> 2, pop() -> 1
//        int[] pushed = new int[]{1, 2, 3, 4, 5};
//        int[] popped = new int[]{4, 5, 3, 2, 1};
//        boolean result = validateStackSequences(pushed, popped);
//        System.out.println(result);

        // leetcode 116. 填充每个节点的下一个右侧节点指针 middle
        // https://leetcode.cn/problems/populating-next-right-pointers-in-each-node/solutions/214548/java-san-xing-he-xin-dai-ma-chao-jian-ji-yi-yu-li-/
//        输入：root = [1,2,3,4,5,6,7]
//        输出：[1,#,2,3,#,4,5,6,7,#]
//        解题思路
//        每个 node 左子树的 next , 就是 node 的右子树
//        每个 node 右子树的 next, 就是 node next 的 左子树

//        NodeTree nodeTree1 = new NodeTree(1);
//        NodeTree nodeTree2 = new NodeTree(2);
//        NodeTree nodeTree3 = new NodeTree(3);
//        NodeTree nodeTree4 = new NodeTree(4);
//        NodeTree nodeTree5 = new NodeTree(5);
//        NodeTree nodeTree6 = new NodeTree(6);
//        NodeTree nodeTree7 = new NodeTree(7);
//        nodeTree1.left = nodeTree2;
//        nodeTree1.right = nodeTree3;
//        nodeTree2.left = nodeTree4;
//        nodeTree2.right = nodeTree5;
//        nodeTree3.left = nodeTree6;
//        nodeTree3.right = nodeTree7;
//        log.info("nodeTree1:{}", nodeTree1);
//        NodeTree nodeTree = connect(nodeTree1);
//        log.info("nodeTree:{}", nodeTree);


        // leetcode 117. 填充每个节点的下一个右侧节点指针2 middle
        NodeTree nodeTree1 = new NodeTree(1);
        NodeTree nodeTree2 = new NodeTree(2);
        NodeTree nodeTree3 = new NodeTree(3);
        NodeTree nodeTree4 = new NodeTree(4);
//        NodeTree nodeTree5 = new NodeTree(5);
//        NodeTree nodeTree6 = new NodeTree(6);
        NodeTree nodeTree7 = new NodeTree(7);
        nodeTree1.left = nodeTree2;
        nodeTree1.right = nodeTree3;
        nodeTree2.left = nodeTree4;
//        nodeTree2.right = nodeTree5;
//        nodeTree3.left = nodeTree6;
        nodeTree3.right = nodeTree7;
        log.info("nodeTree1:{}", nodeTree1);
        NodeTree nodeTree = connect2(nodeTree1);
        log.info("nodeTree:{}", nodeTree);
    }

    private static NodeTree connect2(NodeTree root) {
        dfs2(root, null);
        return root;
    }

    private static void dfs2(NodeTree root, NodeTree next) {
        if (root != null) {
            root.next = next;
//            if (root.left != null) {
                dfs2(root.left, root.right != null ? root.right : (root.next!=null?(root.next.left != null ? root.next.left : root.next.right):null));
//            }
//            if (root.right != null) {
                dfs2(root.right, root.next != null ? root.next.left != null ? root.next.left : root.next.right : null);
//            }
        }
    }

    private static NodeTree connect(NodeTree root) {
        dfs(root, null);
        return root;
    }

    private static void dfs(NodeTree root, NodeTree next) {
        if (root != null) {
            root.next = next;
            dfs(root.left, root.right);
            dfs(root.right, root.next != null ? root.next.left : null);
        }
    }


    static class NodeTree {
        public int val;
        public NodeTree left;
        public NodeTree right;
        public NodeTree next;

        public NodeTree() {
        }

        public NodeTree(int _val) {
            val = _val;
        }

        public NodeTree(int _val, NodeTree _left, NodeTree _right, NodeTree _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }

    }

    private static boolean validateStackSequences(int[] a, int[] b) {
        Stack<Integer> stack = new Stack<>();
        int j = 0;
        for (int i = 0; i < a.length; i++) {
            stack.push(a[i]);
            while (!stack.isEmpty() && stack.peek() == a[j]) {
                stack.pop();
                j++;
            }
        }
        return stack.isEmpty();
    }

    private static String orderlyQueue(String str, int k) {
        if (k > 1) {
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            return new String(chars);
        } else {
            StringBuilder builder = new StringBuilder(str);
            for (int i = 0; i < str.length(); i++) {
                builder.append(str.charAt(0)).deleteCharAt(0);

                if (builder.toString().compareTo(str) < 0) {
                    str = builder.toString();
                }
            }
            return builder.toString();
        }
    }

    private static int[][] reconstructQueue(int[][] people) {
        Arrays.sort(people, (a, b) -> a[0] == b[0] ? a[1] - b[1] : b[0] - a[0]);
        List<int[]> list = new ArrayList<>();
        for (int[] i : people) {
            list.add(i[1], i);
        }
        return list.toArray(new int[list.size()][]);
    }

    // leetcode 641 设计循环双端队列 middle
    public static class MyCircularDeque {
        int capacity;
        LinkedList<Integer> list;

        public MyCircularDeque(int k) {
            list = new LinkedList();
            capacity = k;
        }

        public boolean insertFront(int value) {
            if (isFull()) {
                return false;
            }
            list.addFirst(value);
            return true;
        }

        public boolean insertLast(int value) {
            if (isFull()) {
                return false;
            }
            list.addLast(value);
            return true;
        }

        public boolean deleteFront() {
            if (isEmpty()) {
                return false;
            }
            list.removeFirst();
            return true;
        }

        public boolean deleteLast() {
            if (isEmpty()) {
                return false;
            }
            list.removeLast();
            return true;
        }

        public int getFront() {
            if (isEmpty()) {
                return -1;
            }
            return list.getFirst();
        }

        public int getRear() {
            if (isEmpty()) {
                return -1;
            }
            return list.getLast();
        }

        public boolean isEmpty() {
            if (list.size() == 0) {
                return true;
            }
            return false;
        }

        public boolean isFull() {
            if (list.size() == capacity) {
                return true;
            }
            return false;
        }
    }

//    private static int removeElement(int[] nums, int val) {
//        int left = 0;
//        for (int right = 0; right < nums.length; right++) {
//            if (nums[right] != val) {
//                nums[left++] = nums[right];
//            }
//        }
//        return left;
//    }

//    private static int threeSumClosest(int[] nums, int target) {
//        Arrays.sort(nums);
//        int length = nums.length, best = 1000_0000;
//        for (int i = 0; i < length; i++) {
//            // 判断a是否重复
//            if (i > 0 && nums[i] == nums[i - 1]) {
//                continue;
//            }
//            // 定义b,c双指针位置j，k，开始枚举b,c
//            int j = i + 1, k = length - 1;
//            while (j < k) {
//                int sum = nums[i] + nums[j] + nums[k];
//                // 相等直接返回
//                if (sum == target) {
//                    return sum;
//                }
//                // 更新best
//                if (Math.abs(sum - target) < Math.abs(best - target)) {
//                    best = sum;
//                }
//
//                // 判断sum和target大小
//                if (sum > target) {
//                    int k0= k-1;
//                    while (k0>j&&nums[k0] == nums[k]){
//                        k0--;
//                    }
//                    k = k0;
//                } else {
//                    int j0 = j+1;
//                    while (j0<k&&nums[j0] == nums[j]) {
//                        j++;
//                    }
//                    j = j0;
//                }
//            }
//
//        }
//        return best;
//    }

    private static Node partition(Node head, int x) {
        Node small = new Node(0);
        // 持有开始指针位置，为最后续接做好准备
        Node smallHead = small;
        Node large = new Node(0);
        Node largeHead = large;

        while (head != null) {
            if (head.value < x) {
                small.next = head;
                small = small.next;
            } else {
                large.next = head;
                large = large.next;
            }
            head = head.next;
        }
        large.next = null;
        small.next = largeHead.next;
        return smallHead.next;
    }

    private static List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for (String str : strs) {
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            String key = new String(chars);
            List<String> orDefault = map.getOrDefault(key, new ArrayList<>());
            orDefault.add(str);
            map.put(key, orDefault);
        }
        return new ArrayList<>(map.values());

    }

    private static String longestSubString(String s1) {
        int start = 0, length = s1.length(), maxLength = 0;
        Map<Character, Integer> map = new HashMap<>(16);
        Set<String> set = new TreeSet<>();
        for (int end = 0; end < length; end++) {
            char c = s1.charAt(end);
            if (map.containsKey(c) && map.get(c) >= start) {
                start = map.get(c) + 1;
            }
            map.put(c, end);

            if (end >= start) {
                set.add(s1.substring(start, end + 1));
            }

            maxLength = Math.max(maxLength, end - start + 1);
        }

        Set<String> newSet = new HashSet<>();

        Iterator<String> iterator = set.iterator();
        while (iterator.hasNext()) {
            String next = iterator.next();
            if (next.length() == maxLength) {
                newSet.add(next);
            }
        }

        return newSet.toString();
    }

    private static Integer lengthOfLongestSubString(String s) {
        int start = 0, length = s.length(), maxLength = 0;
        Map<Character, Integer> map = new HashMap<>();
        for (int end = 0; end < length; end++) {
            char c = s.charAt(end);
            // 更新start
            if (map.containsKey(c) && map.get(c) >= start) {
                start = map.get(c) + 1;
            }
            map.put(c, end);
            maxLength = Math.max(maxLength, end - start + 1);
        }
        return maxLength;
    }

    private static int[] maxSlidingWindow(int[] array, int k) {
        if (array.length == 0) {
            return array;
        }
        int maxCount = array.length - k + 1;
        int[] result = new int[maxCount];
        for (int i = 0; i < maxCount; i++) {
            int max = Integer.MIN_VALUE;
            for (int j = i; j < k + i; j++) {
                if (array[j] > max) {
                    max = array[j];
                }
            }
            result[i] = max;
        }
        return result;
    }

//    public static void insertSort(int[] array) {
//        for (int i = 1; i < array.length; i++) {
//            int temp = array[i];
//            int j;
//            for (j = i; j > 0 && temp < array[j - 1]; j--) {
//                array[j] = array[j - 1];
//            }
//            array[j] = temp;
//        }
//    }

    public static void insertSort(int[] array) {
        for (int i = 1; i < array.length; i++) {
            int temp = array[i];
            int j;
            for (j = i; j > 0 && array[j - 1] > temp; j--) {
                array[j] = array[j - 1];
            }
            array[j] = temp;
        }
    }

//    public static void fastSort(int[] a, int low, int height) {
//        if (low >= height) {
//            return;
//        }
//        int i = low, j = height, index = a[i];
//        while (i < j) {
//            while (i < j && a[j] >= index) {
//                j--;
//            }
//            if (i < j) {
//                a[i++] = a[j];
//            }
//            while (i < j && a[i] < index) {
//                i++;
//            }
//            if (i < j) {
//                a[j--] = a[i];
//            }
//            a[i] = index;
//            fastSort(a, low, i - 1);
//            fastSort(a, i + 1, height);
//        }
//    }


//    private static Node mergeNode(Node node1, Node node2) {
//        if (node1 == null) {
//            return node2;
//        }
//        if (node2 == null) {
//            return node1;
//        }
//        if (node1.value < node2.value) {
//            node1.next = mergeNode(node1.next, node2);
//            return node1;
//        } else {
//            node2.next = mergeNode(node2.next, node1);
//            return node2;
//        }
//
//    }

    public static Node mergeNode(Node node1, Node node2) {
        if (node1 == null) {
            return node2;
        }
        if (node2 == null) {
            return node1;
        }
        if (node1.value < node2.value) {
            node1.next = mergeNode(node1.next, node2);
            return node1;
        } else {
            return node2;
        }

    }

//    private static int[] mergeArray(int[] array1, int[] array2) {
//        int i = 0, j = 0, k = 0;
//        int[] result = new int[array1.length + array2.length];
//        while (i < array1.length && j < array2.length) {
//            result[k++] = array1[i] <= array2[j] ? array1[i++] : array2[j++];
//        }
//        while (i < array1.length) {
//            result[k++] = array1[i++];
//        }
//        while (j < array2.length) {
//            result[k++] = array2[j++];
//        }
//        return result;
//    }

    public static int[] mergeArray(int[] array1, int[] array2) {
        int i = 0, j = 0, k = 0;
        int[] result = new int[array1.length + array2.length];
        while (i < array1.length && j < array2.length) {
            result[k++] = array1[i] <= array2[k] ? array1[i] : array2[j];
        }
        while (i < array1.length) {
            result[k++] = array1[i];
        }
        while (j < array2.length) {
            result[i] = array2[j];
        }
        return result;
    }

//    private static Node reverseNode(Node node) {
//        Node pre = null, current = node, next;
//        while (current != null) {
//            // 下一轮的起始节点
//            next = current.next;
//            // 给current构造新的next 为null;
//            current.next = pre;
//            // 下一轮的pre
//            pre = current;
//            // 移动current的指针
//            current = next;
//        }
//        return pre;
//
//    }


//    private static Node removeNode(Node node1, int i) {
//        if (node1 == null) {
//            return node1;
//        }
//        while (node1 != null) {
//            if (node1.value != i) {
//                break;
//            }
//            // 第一个元素满足
//            node1 = node1.next;
//        }
//
//        Node pre = node1;
//        Node curr = node1;
//
//        while (curr != null) {
//            if (curr.value == i) {
//                pre.next = curr.next;
//            } else {
//                // 更新指针位置
//                pre = curr;
//            }
//            curr = curr.next;
//        }
//        return node1;
//    }


    @Data
    public static class Node {
        int value;
        Node next;

        public Node(int value) {
            this.value = value;
        }

        public int getValue() {
            return value;
        }

        public void setValue(int value) {
            this.value = value;
        }

        public Node getNext() {
            return next;
        }

        public void setNext(Node next) {
            this.next = next;
        }

    }

    private static void removeMap(Map<String, Integer> map, String s) {
        Iterator<Map.Entry<String, Integer>> iterator = map.entrySet().iterator();
        while (iterator.hasNext()) {
            if (iterator.next().getKey().equals(s)) {
                iterator.remove();
            }
        }
    }

    private static void removeList(List<Integer> list, int i) {
        Iterator<Integer> iterator = list.iterator();
        while (iterator.hasNext()) {
            if (iterator.next().equals(i)) {
                iterator.remove();
            }
        }
    }

    private static void bubble(int[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            for (int j = 0; j < array.length - 1 - i; j++) {
                if (array[j] > array[j + 1]) {
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }
    }


}
