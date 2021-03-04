package org.jxch.study.algorithm.exercise.leetcode.alibaba;

import lombok.Data;

/**
 * 在链表中按逆序的方式存储两个数字，相加并以相同方式返回结果的链表。
 *
 * @author jxch
 * @since 1.8
 */
public class AddTwoNumbers {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        // 设置 l3 的头节点，便于添加节点。
        ListNode l3 = new ListNode();
        ListNode index1 = l1, index2 = l2, index3 = l3;
        int carry = 0;

        do {
            int n1 = 0, n2 = 0;
            if (index1 != null) n1 = index1.val;
            if (index2 != null) n2 = index2.val;

            int num = n1 + n2 + carry;
            index3.next = new ListNode(num % 10);
            index3 = index3.next;
            carry = num / 10;

            if (index1 != null) index1 = index1.next;
            if (index2 != null) index2 = index2.next;
        } while (index1 != null || index2 != null || carry != 0);

        // 去除 l3 的头节点。
        index3 = l3;
        l3 = l3.next;
        index3.next = null;

        return l3;
    }

    @Data
    public static class ListNode {
        private int val;
        private ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
}
