package org.jxch.study.algorithm.exercise.leetcode.alibaba;

import org.junit.Assert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * RomanToInteger 的测试用例。
 *
 * @author jxch
 * @see RomanToInteger
 * @since 1.8
 */
class RomanToIntegerTest {
    public static final RomanToInteger romanToInteger = new RomanToInteger();

    @Test
    void romanToInt() {
        assertEquals(romanToInteger.romanToInt("III"), 3);
        assertEquals(romanToInteger.romanToInt("IV"), 4);
        assertEquals(romanToInteger.romanToInt("LVIII"), 58);
    }
}