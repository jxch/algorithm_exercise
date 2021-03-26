package org.jxch.study.algorithm.exercise.leetcode;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * RecentCounter 的测试用例。
 *
 * @author jxch
 * @see RecentCounter
 * @since 1.8
 */
class RecentCounterTest {
    public static final RecentCounter recentCounter = new RecentCounter();

    @Test
    void ping() {
        assertEquals(1, recentCounter.ping(1));
        assertEquals(2, recentCounter.ping(2000));
        assertEquals(2, recentCounter.ping(3010));
    }
}