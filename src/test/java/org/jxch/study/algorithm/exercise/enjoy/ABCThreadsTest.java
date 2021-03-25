package org.jxch.study.algorithm.exercise.enjoy;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author jxch
 * @since 1.8
 * @see ABCThreads
 */
class ABCThreadsTest {
    public static final ABCThreads abcThreads = new ABCThreads();

    @Test
    void start() {
        abcThreads.start();
    }
}