package org.jxch.study.algorithm.exercise.leetcode;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * DecodeString 的测试用例。
 *
 * @author jxch
 * @see DecodeString
 * @since 1.8
 */
@Slf4j
class DecodeStringTest {

    @Test
    void decodeString() {
        DecodeString decodeString = new DecodeString();
        String s = "3[z]2[2[y]pq4[2[jk]e1[f]]]ef";
        assertEquals(decodeString.decodeString(s),
                decodeString.decodeStringByStack(s));
    }
}