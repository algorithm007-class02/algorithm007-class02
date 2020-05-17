package com.alang.learn.week9;

/**
 * 给定一个字符串，找到它的第一个不重复的字符，并返回它的索引。如果不存在，则返回 -1。
 * <p>
 * 案例:
 * <p>
 * s = "leetcode"
 * 返回 0.
 * <p>
 * s = "loveleetcode",
 * 返回 2.
 *  
 * <p>
 * 注意事项：您可以假定该字符串只包含小写字母。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/first-unique-character-in-a-string
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LeetCode_387_0034 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.firstUniqChar("leetcode"));
        System.out.println(solution.firstUniqChar("loveleetcode"));
    }

    static class Solution {
        public int firstUniqChar(String s) {
            int len = s == null ? 0 : s.length();
            if (len == 0) return -1;
            char[] chars = s.toCharArray();
            int[] charCount = new int[26];
            for (int i = 0; i < len; i++) {
                charCount[chars[i] - 'a']++;
            }
            for (int i = 0; i < len; i++) {
                if (charCount[chars[i] - 'a'] == 1) return i;
            }
            return -1;
        }
    }
}
