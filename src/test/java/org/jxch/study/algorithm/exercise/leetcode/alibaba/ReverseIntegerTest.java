package org.jxch.study.algorithm.exercise.leetcode.alibaba;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * ReverseInteger 的测试用例
 *
 * @author jxch
 * @see ReverseInteger
 * @since 1.8
 */
class ReverseIntegerTest {
    public static final ReverseInteger reverseInteger = new ReverseInteger();

    @Test
    void reverse() {
        assertEquals(reverseInteger.reverse(123), 321);
        assertEquals(reverseInteger.reverse(-123), -321);
        assertEquals(reverseInteger.reverse(0), 0);
    }
}