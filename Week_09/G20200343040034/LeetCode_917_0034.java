package com.alang.learn.week9;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 给定一个字符串 S，返回 “反转后的” 字符串，其中不是字母的字符都保留在原地，而所有字母的位置发生反转。
 *
 *  
 *
 * 示例 1：
 *
 * 输入："ab-cd"
 * 输出："dc-ba"
 * 示例 2：
 *
 * 输入："a-bC-dEf-ghIj"
 * 输出："j-Ih-gfE-dCba"
 * 示例 3：
 *
 * 输入："Test1ng-Leet=code-Q!"
 * 输出："Qedo1ct-eeLg=ntse-T!"
 *  
 *
 * 提示：
 *
 * S.length <= 100
 * 33 <= S[i].ASCIIcode <= 122 
 * S 中不包含 \ or "
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/reverse-only-letters
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LeetCode_917_0034 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.reverseOnlyLetters("ab-cd"));
        System.out.println(solution.reverseOnlyLetters("a-bC-dEf-ghIj"));
        System.out.println(solution.reverseOnlyLetters("Test1ng-Leet=code-Q!"));
    }

    static class Solution {
        public String reverseOnlyLetters(String S) {
            StringBuilder answer = new StringBuilder();
            int length  = S.length();
            int letterFindIndex = length-1;
            for(int i = 0;i<length;i++){
                if (Character.isLetter(S.charAt(i))) {
                    while (!Character.isLetter(S.charAt(letterFindIndex)))
                        letterFindIndex--;
                    answer.append(S.charAt(letterFindIndex--));
                } else {
                    answer.append(S.charAt(i));
                }
            }
            return answer.toString();
        }
    }
}
