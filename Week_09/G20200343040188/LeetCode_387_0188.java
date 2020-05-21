package com.leetcode.string;

import static org.assertj.core.api.Assertions.assertThat;

public class L387FindFirstChar {

    /* 387. 字符串中的第一个唯一字符
        给定一个字符串，找到它的第一个不重复的字符，并返回它的索引。如果不存在，则返回 -1。
        案例:
        s = "leetcode"
        返回 0.
        s = "loveleetcode",
        返回 2.
        
        注意事项：您可以假定该字符串只包含小写字母。
    */
    public int firstUniqChar(String s) {
        assert s != null;

        char[] charMap = new char[26];

        for (int i = 0; i < s.length(); i++) {
            int index = s.charAt(i) - 'a';
            charMap[index]++;
        }

        for (int i = 0; i < s.length(); i++) {
            int index = s.charAt(i) - 'a';
            if (charMap[index] == 1) {
                return i;
            }
        }


        return -1;
    }

    public static void main(String[] args) {
        System.out.println("hello!");
        L387FindFirstChar test = new L387FindFirstChar();

        assertThat(test.firstUniqChar("leetcode")).isEqualTo(0);
        assertThat(test.firstUniqChar("loveleetcode")).isEqualTo(2);
        
        // System.out.println(test.firstUniqChar("leetcode"));
        // System.out.println(test.firstUniqChar("loveleetcode"));
    }
}