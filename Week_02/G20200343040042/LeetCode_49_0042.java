package com.yequan.leetcode.map.groupAnagrams;


import java.util.*;

/**
 * @author : Administrator
 * @date : 2020/3/22
 */
public class GroupAnagrams {

    /**
     * 暴力法
     * 1.遍历字符串数组,对每一个字符串排序
     * 2.找出相同的,将对应的字符串存入map
     * <p>
     * 复杂度:
     * 时间复杂度: O(N logK) N为字符串数组长度,K为字符串最大长度
     * 空间复杂度: O(NK)
     *
     * @param strs
     * @return
     */
    public List<List<String>> groupAnagrams1(String[] strs) {

        Map<String, List> map = new HashMap<>();
        for (int i = 0; i < strs.length; i++) {
            char[] chars = strs[i].toCharArray();
            Arrays.sort(chars);
            String s = String.valueOf(chars);
            if (!map.containsKey(s)) {
                map.put(s, new ArrayList());
            }
            map.get(s).add(strs[i]);
        }
        return new ArrayList(map.values());
    }

    /**
     * 计数法
     * 1.遍历字符串数组,计算出每一个字符串中字母出现的个数
     * 2.根据每个字符串中字母出现的个数拼接出为一个唯一的key
     * 3.用map存储结果,map的键为key,值为字符串
     *
     * @param strs
     * @return
     */
    public List<List<String>> groupAnagrams2(String[] strs) {
        Map<String, List> map = new HashMap<>();
        int[] count = new int[26];
        for (String str : strs) {
            //重新将count数组置为0的状态
            Arrays.fill(count, 0);
            str.chars().forEach(c -> ++count[c - 'a']);
            StringBuilder sb = new StringBuilder("");
            for (int i = 0; i < 26; i++) {
                sb.append("#");
                sb.append(count[i]);
            }
            String key = sb.toString();
            if (!map.containsKey(key)) {
                map.put(key, new ArrayList());
            }
            map.get(key).add(str);
        }
        return new ArrayList(map.values());
    }


}
