package org.jxch.study.algorithm.exercise.enjoy;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author jxch
 * @since 1.8
 * @see CountDownLatchQ
 */
class CountDownLatchQTest {
    private static final CountDownLatchQ countDownLatchQ = new CountDownLatchQ();

    @Test
    void demo() {
        countDownLatchQ.demo();
    }
}