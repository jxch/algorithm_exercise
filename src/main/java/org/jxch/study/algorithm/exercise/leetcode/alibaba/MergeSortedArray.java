package org.jxch.study.algorithm.exercise.leetcode.alibaba;

/**
 * 给你两个有序整数数组 nums1 和 nums2，请你将 nums2 合并到nums1中，使 nums1 成为一个有序数组。
 * 初始化 nums1 和 nums2 的元素数量分别为 m 和 n 。你可以假设 nums1 的空间大小等于 m + n，这样它就有足够的空间保存来自 nums2 的元素。
 *
 * @author jxch
 * @since 1.8
 */
public class MergeSortedArray {

    /**
     * 双指针法，从后往前
     *
     * @param nums1 合并到此数组中
     * @param m     nums1 中源数据的长度，超过该长度的为 0
     * @param nums2 把它合并到 nums1 中
     * @param n     nums2 的长度
     */
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        for (int i = 0, j = 0, index = nums1.length - 1; index >= 0; index--) {
            int nums1Index = m - i - 1, nums2Index = nums2.length - j - 1;
            if (nums2Index < 0 || (nums1Index >= 0 && nums1[nums1Index] > nums2[nums2Index])) {
                nums1[index] = nums1[nums1Index];
                i++;
            } else {
                nums1[index] = nums2[nums2Index];
                j++;
            }
        }
    }
}
