
//给定一个字符串 s 和一个非空字符串 p，找到 s 中所有是 p 的字母异位词的子串，返回这些子串的起始索引。
//
// 字符串只包含小写英文字母，并且字符串 s 和 p 的长度都不超过 20100。
//
// 说明：
//
//
// 字母异位词指字母相同，但排列不同的字符串。
// 不考虑答案输出的顺序。
//
//
// 示例 1:
//
//
//输入:
//s: "cbaebabacd" p: "abc"
//
//输出:
//[0, 6]
//
//解释:
//起始索引等于 0 的子串是 "cba", 它是 "abc" 的字母异位词。
//起始索引等于 6 的子串是 "bac", 它是 "abc" 的字母异位词。
//
//
// 示例 2:
//
//
//输入:
//s: "abab" p: "ab"
//
//输出:
//[0, 1, 2]
//
//解释:
//起始索引等于 0 的子串是 "ab", 它是 "ab" 的字母异位词。
//起始索引等于 1 的子串是 "ba", 它是 "ab" 的字母异位词。
//起始索引等于 2 的子串是 "ab", 它是 "ab" 的字母异位词。
//
// Related Topics 哈希表


import java.util.ArrayList;
import java.util.List;

//leetcode submit region begin(Prohibit modification and deletion)
class LeetCode_438_0206 {
    //滑动窗口，双指针
    public List<Integer> findAnagrams(String s, String p) {
        if (s == null || p == null || s.length() < p.length()) {
            return new ArrayList<>();
        }
        List<Integer> pos = new ArrayList<>();

        int[] needs = new int[26];
        int[] window = new int[26];

        for (char c : p.toCharArray()) {
            needs[c-'a']++;
        }

        int left = 0, right = 0;
        int valid = p.length();
        while (right < s.length()) {
            int intC = s.charAt(right) - 'a';

            if (needs[intC] > 0) {
                window[intC]++;
                if (window[intC] <= needs[intC]) {
                    valid--;
                }
            }

            while (valid == 0) {
                if ((right - left + 1) == p.length()) {
                    pos.add(left);
                }
                int intLeft = s.charAt(left) - 'a';
                if (needs[intLeft] > 0) {
                    window[intLeft]--;
                    if (window[intLeft] < needs[intLeft]) {
                        valid++;
                    }
                }

                left++;
            }

            right++;
        }
        return pos;
    }




}
//leetcode submit region end(Prohibit modification and deletion)
