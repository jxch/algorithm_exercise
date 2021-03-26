package org.jxch.study.algorithm.exercise.leetcode;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * TaskScheduler 的测试用例。
 * @author jxch
 * @since 1.8
 * @see TaskScheduler
 */
class TaskSchedulerTest {
    public static final TaskScheduler taskScheduler = new TaskScheduler();

    @Test
    void leastInterval() {
        assertEquals(8, taskScheduler.leastInterval(new char[]{'A', 'A', 'A', 'B', 'B', 'B'}, 2));
    }
}