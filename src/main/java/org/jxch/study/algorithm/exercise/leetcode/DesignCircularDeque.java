package org.jxch.study.algorithm.exercise.leetcode;

import lombok.Getter;

import java.util.Arrays;

/**
 * 设计实现双端队列。
 * 你的实现需要支持以下操作：
 * <p>
 * MyCircularDeque(k)：构造函数,双端队列的大小为k。
 * insertFront()：将一个元素添加到双端队列头部。 如果操作成功返回 true。
 * insertLast()：将一个元素添加到双端队列尾部。如果操作成功返回 true。
 * deleteFront()：从双端队列头部删除一个元素。 如果操作成功返回 true。
 * deleteLast()：从双端队列尾部删除一个元素。如果操作成功返回 true。
 * getFront()：从双端队列头部获得一个元素。如果双端队列为空，返回 -1。
 * getRear()：获得双端队列的最后一个元素。如果双端队列为空，返回 -1。
 * isEmpty()：检查双端队列是否为空。
 * isFull()：检查双端队列是否满了。
 *
 * @author jxch
 * @since 1.8
 */
public class DesignCircularDeque {
    private final int[] data;
    private int head = 0, tail = 0;

    /**
     * 构造函数,双端队列的大小为k。
     */
    public DesignCircularDeque(int k) {
        if (k <= 0) {
            throw new IllegalArgumentException("初始化队列大小为：" + k + "，需 > 0。");
        }
        data = new int[k + 1];
    }

    /**
     * 将一个元素添加到双端队列头部。 如果操作成功返回 true。
     */
    public boolean insertFront(int value) {
        if (isFull()) {
            return false;
        } else {
            head = head - 1 < 0 ? head - 1 + data.length : head - 1;
            data[head] = value;
            return true;
        }
    }

    /**
     * 将一个元素添加到双端队列尾部。如果操作成功返回 true。
     */
    public boolean insertLast(int value) {
        if (isFull()) {
            return false;
        } else {
            data[tail] = value;
            tail = (tail + 1) % data.length;
            return true;
        }
    }

    /**
     * 从双端队列头部删除一个元素。 如果操作成功返回 true。
     */
    public boolean deleteFront() {
        if (isEmpty()) {
            return false;
        } else {
            head = (head + 1) % data.length;
            return true;
        }
    }

    /**
     * 从双端队列尾部删除一个元素。如果操作成功返回 true。
     */
    public boolean deleteLast() {
        if (isEmpty()) {
            return false;
        } else {
            tail = tail - 1 < 0 ? tail - 1 + data.length : tail - 1;
            return true;
        }
    }

    /**
     * 从双端队列头部获得一个元素。如果双端队列为空，返回 -1。
     */
    public int getFront() {
        if (isEmpty()) {
            return -1;
        } else {
            return data[head];
        }
    }

    /**
     * 获得双端队列的最后一个元素。如果双端队列为空，返回 -1。
     */
    public int getRear() {
        if (isEmpty()) {
            return -1;
        } else {
            return data[tail - 1 < 0 ? tail - 1 + data.length : tail - 1];
        }
    }

    /**
     * 检查双端队列是否为空。
     */
    public boolean isEmpty() {
        return head == tail;
    }

    /**
     * 检查双端队列是否满了。
     */
    public boolean isFull() {
        return (tail + 1) % data.length == head;
    }

    @Override
    public String toString() {
        return Arrays.toString(data);
    }
}
