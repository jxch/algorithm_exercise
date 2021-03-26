package org.jxch.study.algorithm.exercise.leetcode.alibaba;

import org.junit.Assert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

/**
 * MergeSortedArray 的测试用例。
 *
 * @author jxch
 * @see MergeSortedArray
 * @since 1.8
 */
class MergeSortedArrayTest {
    public static final MergeSortedArray mergeSortedArray = new MergeSortedArray();

    @Test
    void merge() {
        int[] ints = {1, 2, 3, 0, 0, 0};
        mergeSortedArray.merge(ints, 3, new int[]{2, 5, 6}, 3);
        assertEquals(Arrays.toString(new int[]{1, 2, 2, 3, 5, 6}), Arrays.toString(ints));

        int[] ints2 = {2, 0};
        mergeSortedArray.merge(ints2, 1, new int[]{1}, 1);
        assertEquals(Arrays.toString(new int[]{1, 2}), Arrays.toString(ints2));
    }
}