package org.jxch.study.algorithm.exercise.leetcode.alibaba;

import org.junit.Assert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * LongestCommonPrefix 的测试用例。
 *
 * @author jxch
 * @see LongestCommonPrefix
 * @since 1.8
 */
class LongestCommonPrefixTest {
    public static final LongestCommonPrefix longestCommonPrefix = new LongestCommonPrefix();

    @Test
    void longestCommonPrefix() {
        assertEquals("fl", longestCommonPrefix.longestCommonPrefix(new String[]{"flower","flow","flight"}));
    }
}