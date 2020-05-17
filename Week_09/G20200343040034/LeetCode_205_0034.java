package com.alang.learn.week9;

/**
 * 给定两个字符串 s 和 t，判断它们是否是同构的。
 *
 * 如果 s 中的字符可以被替换得到 t ，那么这两个字符串是同构的。
 *
 * 所有出现的字符都必须用另一个字符替换，同时保留字符的顺序。两个字符不能映射到同一个字符上，但字符可以映射自己本身。
 *
 * 示例 1:
 *
 * 输入: s = "egg", t = "add"
 * 输出: true
 * 示例 2:
 *
 * 输入: s = "foo", t = "bar"
 * 输出: false
 * 示例 3:
 *
 * 输入: s = "paper", t = "title"
 * 输出: true
 * 说明:
 * 你可以假设 s 和 t 具有相同的长度。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/isomorphic-strings
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LeetCode_205_0034 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.isIsomorphic("egg","add"));
        System.out.println(solution.isIsomorphic("foo","bar"));
        System.out.println(solution.isIsomorphic("paper","title"));
    }

    static class Solution {
        public boolean isIsomorphic(String s, String t) {
            int length = s.length();
            int[] mapS = new int[128];
            int[] mapT = new int[128];
            for(int i = 0;i<length;i++){
                char c1 = s.charAt(i);
                char c2 = t.charAt(i);
                if(mapS[c1] != mapT[c2]){
                    return false;
                }
                if(mapS[c1] == 0){
                    mapS[c1] = i+1;
                    mapT[c2] = i+1;
                }
            }
            return true;
        }
    }
}
