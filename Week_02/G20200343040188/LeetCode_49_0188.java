package com.leetcode.hash;

import java.util.*;

/**
 * 49. 字母异位词分组
 * 给定一个字符串数组，将字母异位词组合在一起。字母异位词指字母相同，但排列不同的字符串。
 *
 * 示例:
 * 输入: ["eat", "tea", "tan", "ate", "nat", "bat"],
 * 输出:
 * [
 *   ["ate","eat","tea"],
 *   ["nat","tan"],
 *   ["bat"]
 * ]
 *
 * 说明：
 * 所有输入均为小写字母。
 * 不考虑答案输出的顺序。
 */
public class L49AnagramGroup {

    /**
     * 使用一个hashmap作为hashmap的key
     *
     * @param strs
     * @return
     */
    public List<List<String>> groupAnagrams1(String[] strs) {
        assert strs != null;

        Map<Map<Character, Integer>, List<String>> tableMap = new HashMap<>();
        for (String s : strs) {
            Map<Character, Integer> table = computeHashMap(s);
            if (tableMap.containsKey(table)) {
                tableMap.get(table).add(s);
            } else {
                List<String> list = new ArrayList<>();
                list.add(s);
                tableMap.put(table, list);
            }
        }

        return new ArrayList<>(tableMap.values());
    }

    public Map<Character, Integer> computeHashMap(String str) {
        Map<Character, Integer> map = new HashMap<>();
        for (char c : str.toCharArray()) {
            if (map.containsKey(c)) {
                map.put(c, map.get(c) + 1);
            } else {
                map.put(c, 1);
            }
        }
        return map;
    }

    /**
     * 使用string作为hashmap的key
     * 时间复杂度 O(N*M), N为strs数组长度，M为每个str的平均长度
     * 空间复杂度O(N*M)
     * @param strs
     * @return
     */
    public List<List<String>> groupAnagrams(String[] strs) {
        assert strs != null;

        Map<String, List<String>> ansMap = new HashMap<>();
        for (String s : strs) {
            String ans = computeAns(s);
            if (!ansMap.containsKey(ans)) {
                ansMap.put(ans, new ArrayList<>());
            }
            ansMap.get(ans).add(s);
        }
        return new ArrayList<>(ansMap.values());
    }

    private String computeAns(String s) {
        int[] table = new int[26];
        for (char c : s.toCharArray()) {
            table[c - 'a']++;
        }
        StringBuilder builder = new StringBuilder();
        for (int i : table) {
            builder.append(i).append("#");
        }
        return builder.toString();
    }
}
