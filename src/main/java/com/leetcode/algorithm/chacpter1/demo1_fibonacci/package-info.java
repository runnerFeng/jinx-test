/**
 * @Author: Aug
 * @Date: 2020-12-03 19:42
 * @Desc:
 */
package com.leetcode.algorithm.chacpter1.demo1_fibonacci;
/**
 * 递归的时间复杂度和空间复杂度
 * 1.时间复杂度:计算递归调用节点的个数;如果递归方程中有m个调用,则时间复杂度大概率是O(Math.pow(m,n)).
 * 2.空间复杂度:与递归调用时栈的开销有关,一般空间复杂度=O(n),其中n=每一层操作占用的栈空间,随着堆栈的不断增长，如果没有足够的内存则会导致
 * StackOverFlowError.
 */