package org.jxch.study.algorithm.exercise.leetcode.alibaba;

/**
 * 给你一个 32 位的有符号整数 x ，返回将 x 中的数字部分反转后的结果。
 * 如果反转后整数超过 32 位的有符号整数的范围 [−2^31,  2^31 − 1] ，就返回 0。
 *
 * @author jxch
 * @since 1.8
 */
public class ReverseInteger {

    public int reverse(int x) {
        long reverseInt = 0;
        while (x != 0) {
            int num = x % 10;
            x /= 10;
            reverseInt = reverseInt * 10 + num;
        }

        if (reverseInt > Integer.MAX_VALUE || reverseInt < Integer.MIN_VALUE) {
            return 0;
        }

        return (int) reverseInt;
    }

}
