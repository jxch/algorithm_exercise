package org.jxch.study.algorithm.exercise.leetcode.alibaba;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * PalindromeNumber 的测试用例。
 *
 * @author jxch
 * @see PalindromeNumber
 * @since 1.8
 */
class PalindromeNumberTest {
    public static final PalindromeNumber palindromeNumber = new PalindromeNumber();

    @Test
    void isPalindrome() {
        assertTrue(palindromeNumber.isPalindrome(121));
        assertFalse(palindromeNumber.isPalindrome(123));
    }
}