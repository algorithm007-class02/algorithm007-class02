import java.util.HashMap;
import java.util.Map;

/*
 * @lc app=leetcode.cn id=242 lang=java
 *
 * [242] 有效的字母异位词
 *
 * https://leetcode-cn.com/problems/valid-anagram/description/
 *
 * algorithms
 * Easy (58.81%)
 * Likes:    167
 * Dislikes: 0
 * Total Accepted:    82.3K
 * Total Submissions: 139.7K
 * Testcase Example:  '"anagram"\n"nagaram"'
 *
 * 给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的字母异位词。
 * 
 * 示例 1:
 * 
 * 输入: s = "anagram", t = "nagaram"
 * 输出: true
 * 
 * 
 * 示例 2:
 * 
 * 输入: s = "rat", t = "car"
 * 输出: false
 * 
 * 说明:
 * 你可以假设字符串只包含小写字母。
 * 
 * 进阶:
 * 如果输入字符串包含 unicode 字符怎么办？你能否调整你的解法来应对这种情况？
 * 
 */

// @lc code=start
class Solution {
    public boolean isAnagram(String s, String t) {
        int[] dict = new int[26]; 
        if (s.length() != t.length()) {
            return false;
        }
        for (int i = 0; i < s.length(); i++) {
            dict[s.charAt(i) - 'a'] += 1;
        }
        for (int i = 0; i < t.length(); i++) {
            dict[t.charAt(i) - 'a'] -= 1;
            //if (dict[t.charAt(i) - 'a'] < 0) return false;
        }

        for (int i = 0; i < dict.length; i++) {
            if (dict[i] != 0) return false;
        }
        return true;
    }
    // 通用解
    // public boolean isAnagram(String s, String t) {
    //     Map<Character, Integer> dict = new HashMap<Character, Integer>();
    //     if (s.length() != t.length()) {
    //         return false;
    //     }
    //     for (int i = 0; i < s.length(); i++) {
    //         char c = s.charAt(i);
    //         if (dict.containsKey(c)) {
    //             dict.put(c, dict.get(c) + 1);
    //         } else {
    //             dict.put(c, 1);
    //         }
    //     }
    //     for (int i = 0; i < t.length(); i++) {
    //         char c = t.charAt(i);
    //         if (dict.containsKey(c)) {
    //             dict.put(c, dict.get(c) - 1);
    //             if (dict.get(c) < 0) {
    //                 return false;
    //             }
    //         } else {
    //             return false;
    //         }
    //     }

    //     for (int value : dict.values()) {
    //         if (value != 0) return false;
    //     }
    //     return true;
    // }
}
// @lc code=end

