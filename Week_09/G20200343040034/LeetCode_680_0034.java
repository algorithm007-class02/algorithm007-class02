package com.alang.learn.week9;

/**
 *给定一个非空字符串 s，最多删除一个字符。判断是否能成为回文字符串。
 *
 * 示例 1:
 *
 * 输入: "aba"
 * 输出: True
 * 示例 2:
 *
 * 输入: "abca"
 * 输出: True
 * 解释: 你可以删除c字符。
 * 注意:
 *
 * 字符串只包含从 a-z 的小写字母。字符串的最大长度是50000。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/valid-palindrome-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LeetCode_680_0034 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.validPalindrome("aba"));
        System.out.println(solution.validPalindrome("abca"));
    }

    static class Solution {
        public boolean validPalindrome(String s) {
            int len = s == null?0:s.length();
            int left = 0,right = len-1;
            while(left<right){
                if(s.charAt(left) != s.charAt(right))
                    return isValid(s,left+1,right) || isValid(s,left,right-1);
                left++;
                right--;
            }
            return true;
        }

        private boolean isValid(String s,int start,int end){
            while(start < end){
                if(s.charAt(start) != s.charAt(end))return false;
                start++;
                end--;
            }
            return true;
        }
    }
}
