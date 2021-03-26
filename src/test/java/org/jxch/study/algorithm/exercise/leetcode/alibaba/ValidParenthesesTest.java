package org.jxch.study.algorithm.exercise.leetcode.alibaba;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * ValidParentheses 的测试用例。
 *
 * @author jxch
 * @see ValidParentheses
 * @since 1.8
 */
class ValidParenthesesTest {
    public static final ValidParentheses validParentheses = new ValidParentheses();

    @Test
    void isValid() {
        assertTrue(validParentheses.isValid("{}()"));
        assertFalse(validParentheses.isValid("{})"));
    }
}