package org.jxch.study.algorithm.exercise.leetcode.alibaba;

import java.util.HashMap;

/**
 * 找出字符串中不含有重复字符的最长子串的长度。
 *
 * @author jxch
 * @since 1.8
 */
public class LongestSubstringWithoutRepeatingCharacters {
    public int lengthOfLongestSubstring(String s) {
        int length = 0, mapStartIndex = 0;
        HashMap<Character, Integer> map = new HashMap<>();
        char[] chars = s.toCharArray();

        for (int i = 0; i < chars.length; i++) {
            char character = chars[i];
            if (map.containsKey(character)) {
                int size = map.size();
                if (size > length) length = size;

                Integer index = map.get(character);
                for (int j = mapStartIndex; j <= index; j++) {
                    map.remove(chars[j]);
                }
                mapStartIndex = index + 1;
            }
            map.put(character, i);
        }

        int size = map.size();
        if (size > length) length = size;
        return length;
    }
}
