import java.util.ArrayList;
import java.util.List;

/*
 * @lc app=leetcode.cn id=22 lang=java
 *
 * [22] 括号生成
 *
 * https://leetcode-cn.com/problems/generate-parentheses/description/
 *
 * algorithms
 * Medium (73.67%)
 * Likes:    818
 * Dislikes: 0
 * Total Accepted:    90.2K
 * Total Submissions: 122.3K
 * Testcase Example:  '3'
 *
 * 给出 n 代表生成括号的对数，请你写出一个函数，使其能够生成所有可能的并且有效的括号组合。
 * 
 * 例如，给出 n = 3，生成结果为：
 * 
 * [
 * ⁠ "((()))",
 * ⁠ "(()())",
 * ⁠ "(())()",
 * ⁠ "()(())",
 * ⁠ "()()()"
 * ]
 * 
 * 
 */

// @lc code=start
class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        gen("", n, 0, res);
        return res;
    }

    private void gen(String s, int l, int r, List<String> res) {
        if (l == 0 && r == 0) {
            res.add(s);
        }
        if (l > 0) {
            gen(s + "(", l - 1, r + 1, res);
        }
        if (r > 0) {
            gen(s + ")", l, r - 1, res);
        }
    }
}
// @lc code=end

