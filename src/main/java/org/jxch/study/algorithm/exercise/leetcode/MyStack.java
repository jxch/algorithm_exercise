package org.jxch.study.algorithm.exercise.leetcode;

import com.alibaba.fastjson.JSON;

import java.util.LinkedList;
import java.util.Objects;
import java.util.Queue;

/**
 * 请你仅使用两个队列实现一个后入先出（LIFO）的栈，并支持普通队列的全部四种操作（push、top、pop 和 empty）。
 *
 * 实现 MyStack 类：
 * void push(int x) 将元素 x 压入栈顶。
 * int pop() 移除并返回栈顶元素。
 * int top() 返回栈顶元素。
 * boolean empty() 如果栈是空的，返回 true ；否则，返回 false。
 *
 * 注意：
 * 你只能使用队列的基本操作 —— 也就是push to back、peek/pop from front、size 和is empty这些操作。
 * 你所使用的语言也许不支持队列。你可以使用 list （列表）或者 deque（双端队列）来模拟一个队列, 只要是标准的队列操作即可。
 *
 * @author jxch
 * @since 1.8
 * @see <a href="https://leetcode-cn.com/problems/implement-stack-using-queues/">力扣：225. 用队列实现栈</a>
 */
public class MyStack {
    private Queue<Integer> pushQueue;
    private Queue<Integer> popQueue;

    /** Initialize your data structure here. */
    public MyStack() {
        pushQueue = new LinkedList<>();
        popQueue = new LinkedList<>();
    }

    /** 将元素 x 压入栈顶 */
    public void push(int x) {
        pushQueue.offer(x);
        while (!popQueue.isEmpty()) {
            pushQueue.offer(popQueue.poll());
        }
        Queue<Integer> temp;
        temp = pushQueue;
        pushQueue = popQueue;
        popQueue = temp;
    }

    /** 移除并返回栈顶元素。 */
    public int pop() {
        return Objects.requireNonNull(popQueue.poll());
    }

    /** 返回栈顶元素。 */
    public int top() {
        return Objects.requireNonNull(popQueue.peek());
    }

    /** 如果栈是空的，返回 true ；否则，返回 false。 */
    public boolean empty() {
        return popQueue.isEmpty();
    }

    @Override
    public String toString() {
        return JSON.toJSONString(popQueue);
    }
}
