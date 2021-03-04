package org.jxch.study.algorithm.exercise.leetcode.alibaba;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * LongestSubstringWithoutRepeatingCharacters 的测试用例。
 *
 * @author jxch
 * @since 1.8
 * @see LongestSubstringWithoutRepeatingCharacters
 */
@Slf4j
class LongestSubstringWithoutRepeatingCharactersTest {
    private static final String STRING = "abcda";
    private static final LongestSubstringWithoutRepeatingCharacters LONGEST_SUBSTRING_WITHOUT_REPEATING_CHARACTERS
            = new LongestSubstringWithoutRepeatingCharacters();

    @Test
    void lengthOfLongestSubstring() {
        int length = LONGEST_SUBSTRING_WITHOUT_REPEATING_CHARACTERS.lengthOfLongestSubstring(STRING);
        log.info("长度：" + length);
        Assertions.assertEquals(4, length);
    }
}