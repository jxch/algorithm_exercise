package org.jxch.study.algorithm.exercise.leetcode.alibaba;

import java.util.HashMap;

/**
 * 找到 nums 数组中，两数之和 = target，返回对应两数的坐标。
 * 两种方案：
 * 1. 暴力枚举
 * 2. 使用 HashMap
 *
 * @author jxch
 * @since 1.8
 */
public class TwoSum {
    public int[] twoSum(int[] nums, int target) {
        int[] indexes = new int[2];
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    indexes[0] = i;
                    indexes[1] = j;
                    break;
                }
            }
        }

        return indexes;
    }

    public int[] twoSumByHashMap(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int num1 = nums[i];
            int num2 = target - num1;
            if (map.containsKey(num2)) {
                return new int[]{i, map.get(num2)};
            } else {
                map.put(num1, i);
            }
        }
        return null;
    }
}
