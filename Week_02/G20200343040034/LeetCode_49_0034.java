package com.alang.learn;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

/***
 * 给定一个字符串数组，将字母异位词组合在一起。字母异位词指字母相同，但排列不同的字符串。
 * \输入: ["eat", "tea", "tan", "ate", "nat", "bat"],
 * 输出:
 * [
 *   ["ate","eat","tea"],
 *   ["nat","tan"],
 *   ["bat"]
 * ]
 * 说明：
 *
 * 所有输入均为小写字母。
 * 不考虑答案输出的顺序。
 *
 * 这个题目很不严谨 按照题意相同的字符串应该不是异位词 但是实际上 输入一样的字符串居然也叫异位词。
 */
public class LeetCode_49_0034 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};
        System.out.println(solution.groupAnagrams(strs));
        solution.groupAnagrams(new String[]{"",""});
    }

    static class Solution {
        public List<List<String>> groupAnagrams(String[] strs) {
            HashMap<String, ArrayList<String>> memo = new HashMap<>();
            if (strs == null || strs.length == 0) {
                return new ArrayList<>();
            }
            for (String str : strs) {
                String key = makeKey(str);
                ArrayList<String> list = memo.computeIfAbsent(key, k -> new ArrayList<>());
                list.add(str);
            }
            return new ArrayList<>(memo.values());
        }

        public String makeKey(String str) {
            int[] chars = new int[26];
            for (int i = 0, length = str.length(); i < length; i++) {
                chars[str.charAt(i) - 'a']++;
            }
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < 26; i++) {
                if (chars[i] > 0) {
                    sb.append((char)('a' + i)).append(chars[i]);
                }
            }
            return sb.toString();
        }
    }

}
