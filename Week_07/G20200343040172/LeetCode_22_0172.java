package week07.g20200343040172;

import java.util.ArrayList;
import java.util.List;

public class LeetCode_22_0172 {
    /**
     * 使用递归并剪枝
     */
    class Solution1 {
        public List<String> generateParenthesis(int n) {
            List<String> ans = new ArrayList<>();
            recursion(n, ans, "", 0, 0);
            return ans;
        }

        // 递归该怎么写？
        public void recursion(int n, List<String> ans, String str, int left, int right) {
            if (left == n && right == n) {
                ans.add(str);
                return;
            }
            // 如何判断生成的括号是否合法？
            // 1.左括号的数量 = 右括号的数量 = 3
            // 2.第一个括号只能为左括号
            // 3.无论什么时候，当前字符串中的左括号的数量一定要>=右括号的数量
            if (left < n) {
                recursion(n, ans, str + "(", left + 1, right);
            }

            if (right < left && right < n) {
                recursion(n, ans, str + ")", left, right + 1);
            }
        }
    }

    /**
     * 使用动态规划
     * https://leetcode-cn.com/problems/generate-parentheses/solution/zui-jian-dan-yi-dong-de-dong-tai-gui-hua-bu-lun-da/
     */
    
}
