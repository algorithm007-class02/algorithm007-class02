import java.util.HashMap;
import java.util.Map;

/*
 * @lc app=leetcode.cn id=438 lang=java
 *
 * [438] 找到字符串中所有字母异位词
 *
 * https://leetcode-cn.com/problems/find-all-anagrams-in-a-string/description/
 *
 * algorithms
 * Medium (43.07%)
 * Likes:    266
 * Dislikes: 0
 * Total Accepted:    25.5K
 * Total Submissions: 58.5K
 * Testcase Example:  '"cbaebabacd"\n"abc"'
 *
 * 给定一个字符串 s 和一个非空字符串 p，找到 s 中所有是 p 的字母异位词的子串，返回这些子串的起始索引。
 * 
 * 字符串只包含小写英文字母，并且字符串 s 和 p 的长度都不超过 20100。
 * 
 * 说明：
 * 
 * 
 * 字母异位词指字母相同，但排列不同的字符串。
 * 不考虑答案输出的顺序。
 * 
 * 
 * 示例 1:
 * 
 * 
 * 输入:
 * s: "cbaebabacd" p: "abc"
 * 
 * 输出:
 * [0, 6]
 * 
 * 解释:
 * 起始索引等于 0 的子串是 "cba", 它是 "abc" 的字母异位词。
 * 起始索引等于 6 的子串是 "bac", 它是 "abc" 的字母异位词。
 * 
 * 
 * 示例 2:
 * 
 * 
 * 输入:
 * s: "abab" p: "ab"
 * 
 * 输出:
 * [0, 1, 2]
 * 
 * 解释:
 * 起始索引等于 0 的子串是 "ab", 它是 "ab" 的字母异位词。
 * 起始索引等于 1 的子串是 "ba", 它是 "ab" 的字母异位词。
 * 起始索引等于 2 的子串是 "ab", 它是 "ab" 的字母异位词。
 * 
 * 
 */

// @lc code=start
class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> res = new ArrayList<>();
        Map<Character, Integer> need = new HashMap<>();
        Map<Character, Integer> window = new HashMap<>();
        int left = 0, right = 0;
        int validCnt = 0;
        for (char c : p.toCharArray()) need.put(c, need.getOrDefault(c, 0) + 1); // 初始化要求
        while (right < s.length()) {
            char rChar = s.charAt(right++); // 窗口右滑
            if (need.containsKey(rChar)) {
                window.put(rChar, window.getOrDefault(rChar, 0) + 1);
                if (window.get(rChar) <= need.get(rChar)) validCnt++; // <= 为了处理重复字符如"baa""aa"的cases
            }
            while (validCnt == p.length()) {
                if (right - left == p.length()) res.add(left); // 满足某种条件时更新 res
                char lChar = s.charAt(left++); // 窗口左滑
                if (need.containsKey(lChar)) {
                    window.put(lChar, window.get(lChar) - 1);
                    if (window.get(lChar) < need.get(lChar)) validCnt--; // 窗口不满足要求
                }
            }
        }
        return res;
    }
}
// @lc code=end

