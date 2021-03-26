package org.jxch.study.algorithm.exercise.leetcode.alibaba;

/**
 * 给你一个整数 x ，如果 x 是一个回文整数，返回 true ；否则，返回 false 。
 * 回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。例如，121 是回文，而 123 不是。
 *
 * @author jxch
 * @since 1.8
 */
public class PalindromeNumber {
    /**
     * 倒过来相等就是回文
     *
     * @param x 判断该入参是否是回文
     * @return 是否是回文
     */
    public boolean isPalindrome(int x) {
        return x >= 0 && x == new ReverseInteger().reverse(x);
    }
}
