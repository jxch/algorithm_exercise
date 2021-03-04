package org.jxch.study.algorithm.exercise.leetcode.alibaba;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

/**
 * TwoSum 的测试用例。
 *
 * @author jxch
 * @see TwoSum
 * @since 1.8
 */
@Slf4j
class TwoSumTest {
    private static final TwoSum TWO_SUM = new TwoSum();
    private static final int[] NUMS = new int[]{2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 18};
    private static final int TARGET = 23;

    @Test
    void twoSum() {
        int[] ints = TWO_SUM.twoSum(NUMS, TARGET);
        log.info(Arrays.toString(ints));
        assertEquals(TARGET, Arrays.stream(ints).map(operand -> NUMS[operand]).sum());
    }

    @Test
    void twoSumByHashMap() {
        int[] ints = TWO_SUM.twoSumByHashMap(NUMS, TARGET);
        log.info(Arrays.toString(ints));
        assertEquals(TARGET, Arrays.stream(ints).map(operand -> NUMS[operand]).sum());
    }
}