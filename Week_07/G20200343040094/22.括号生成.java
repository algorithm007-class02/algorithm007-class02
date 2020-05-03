import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/*
 * @lc app=leetcode.cn id=22 lang=java
 *
 * [22] 括号生成
 *
 * https://leetcode-cn.com/problems/generate-parentheses/description/
 *
 * algorithms
 * Medium (73.77%)
 * Likes:    973
 * Dislikes: 0
 * Total Accepted:    118.3K
 * Total Submissions: 157.2K
 * Testcase Example:  '3'
 *
 * 数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。
 * 
 * 
 * 
 * 示例：
 * 
 * 输入：n = 3
 * 输出：[
 * ⁠      "((()))",
 * ⁠      "(()())",
 * ⁠      "(())()",
 * ⁠      "()(())",
 * ⁠      "()()()"
 * ⁠    ]
 * 
 * 
 */

// @lc code=start
// BFS
class Solution {
    class Node {
        private String str;
        private int left;
        private int right;

        public Node(String str, int left, int right) {
            this.str = str;
            this.left = left;
            this.right = right;
        }
    }

    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        if (n == 0)
            return res;
        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node("", 0, 0));

        while (!queue.isEmpty()) {
            Node curNode = queue.poll();
            if (curNode.left == n && curNode.right == n) {
                res.add(curNode.str);
            }
            if (curNode.left < n) {
                queue.add(new Node(curNode.str + "(", curNode.left + 1, curNode.right));
            }
            if (curNode.right < curNode.left) {
                queue.add(new Node(curNode.str + ")", curNode.left, curNode.right + 1));
            }
        }
        return res;
    }
}

// DP
// class Solution {
//     public List<String> generateParenthesis(int n) {
//         List<String>[] dp = new ArrayList[n + 1];
//         dp[0] = new ArrayList<>();
//         dp[0].add("");

//         for (int i = 1; i <= n; i++) {
//             dp[i] = new ArrayList<>();
//             for (int j = 0; j < i; j++) {
//                 for (String t1 : dp[j])
//                     for (String t2 : dp[i - 1 - j])
//                         dp[i].add("(" + t1 + ")" + t2);
//             }
//         }
//         return dp[n];
//     }
// }
// @lc code=end
