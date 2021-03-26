package org.jxch.study.algorithm.exercise.leetcode.alibaba;

import java.util.Arrays;

/**
 * 编写一个函数来查找字符串数组中的最长公共前缀。如果不存在公共前缀，返回空字符串 ""。
 *
 * @author jxch
 * @since 1.8
 */
public class LongestCommonPrefix {

    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) {
            return "";
        } else if (strs.length == 1) {
            return strs[0];
        } else {
            String commonPrefix = strs[0];
            for (String str : strs) {
                while (!str.startsWith(commonPrefix)) {
                    commonPrefix = commonPrefix.substring(0, commonPrefix.length() - 1);
                }
            }
            return commonPrefix;
        }
    }
}
