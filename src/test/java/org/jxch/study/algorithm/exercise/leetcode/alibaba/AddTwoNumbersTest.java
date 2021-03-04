package org.jxch.study.algorithm.exercise.leetcode.alibaba;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * AddTwoNumbers 的测试用例。
 * L_1 = [9 9 9 9 9 9 9]
 * L_1 = [9 9 9 9]
 * 预测 l3 = [8 9 9 9 0 0 0 1]
 *
 * @author jxch
 * @since 1.8
 * @see AddTwoNumbers
 */
@Slf4j
class AddTwoNumbersTest {
    private static final AddTwoNumbers ADD_TWO_NUMBERS = new AddTwoNumbers();
    private static final AddTwoNumbers.ListNode L_1;
    private static final AddTwoNumbers.ListNode L_2;

    static {
        L_1 = new AddTwoNumbers.ListNode(9);
        AddTwoNumbers.ListNode index1 = L_1;
        for (int i = 0; i < 6; i++) {
            index1.setNext(new AddTwoNumbers.ListNode(9));
            index1 = index1.getNext();
        }

        L_2 = new AddTwoNumbers.ListNode(9);
        AddTwoNumbers.ListNode index2 = L_2;
        for (int i = 0; i < 3; i++) {
            index2.setNext(new AddTwoNumbers.ListNode(9));
            index2 = index2.getNext();
        }
    }

    @Test
    void addTwoNumbers() {
        AddTwoNumbers.ListNode l3 = ADD_TWO_NUMBERS.addTwoNumbers(L_1, L_2);

        StringBuilder builder = new StringBuilder();
        AddTwoNumbers.ListNode index3 = l3;
        while (index3 != null) {
            builder.append(index3.getVal()).append(" ");
            index3 = index3.getNext();
        }

        String l3String = builder.toString();
        log.info(l3String);
        Assertions.assertEquals("8 9 9 9 0 0 0 1 ", l3String);
    }
}