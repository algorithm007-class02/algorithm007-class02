/*
 * @lc app=leetcode.cn id=818 lang=java
 *
 * [818] 赛车
 *
 * https://leetcode-cn.com/problems/race-car/description/
 *
 * algorithms
 * Hard (33.31%)
 * Likes:    47
 * Dislikes: 0
 * Total Accepted:    1.2K
 * Total Submissions: 3.5K
 * Testcase Example:  '3'
 *
 * 你的赛车起始停留在位置 0，速度为 +1，正行驶在一个无限长的数轴上。（车也可以向负数方向行驶。）
 * 
 * 你的车会根据一系列由 A（加速）和 R（倒车）组成的指令进行自动驾驶 。
 * 
 * 当车得到指令 "A" 时, 将会做出以下操作： position += speed, speed *= 2。
 * 
 * 当车得到指令 "R" 时, 将会做出以下操作：如果当前速度是正数，则将车速调整为 speed = -1 ；否则将车速调整为 speed = 1。
 * (当前所处位置不变。)
 * 
 * 例如，当得到一系列指令 "AAR" 后, 你的车将会走过位置 0->1->3->3，并且速度变化为 1->2->4->-1。
 * 
 * 现在给定一个目标位置，请给出能够到达目标位置的最短指令列表的长度。
 * 
 * 示例 1:
 * 输入: 
 * target = 3
 * 输出: 2
 * 解释: 
 * 最短指令列表为 "AA"
 * 位置变化为 0->1->3
 * 
 * 
 * 示例 2:
 * 输入: 
 * target = 6
 * 输出: 5
 * 解释: 
 * 最短指令列表为 "AAARA"
 * 位置变化为 0->1->3->7->7->6
 * 
 * 
 * 说明: 
 * 
 * 
 * 1 <= target（目标位置） <= 10000。
 * 
 * 
 */

// @lc code=start
// DP
class Solution {
    public int racecar(int target) {
        int[] dp = new int[target + 1];
        for (int i = 1; i <= target; ++i) {
            dp[i] = Integer.MAX_VALUE;
            int acc_cnt = 1, currPos = 1;
            // AAA...RAAA...R
            while (currPos < i) {
                for (int rev_acc_cnt = 0, revPos = 0; revPos < currPos; revPos = (1 << ++rev_acc_cnt) - 1) {
                    dp[i] = Math.min(dp[i], acc_cnt + 1 + rev_acc_cnt + 1 + dp[i - (currPos - revPos)]);
                }
                currPos = (1 << ++acc_cnt) - 1;
            }
            // AAAA or AAA...RAAA...
            dp[i] = Math.min(dp[i], acc_cnt + (currPos == i ? 0 : 1 + dp[currPos - i]));
        }
        return dp[target];
    }
}

// BFS
class Solution {
    Queue<int[]> queue = new LinkedList<>();
    Set<String> visited = new HashSet<>();
    int res = 0;

    public int racecar(int target) {
        queue.add(new int[] { 0, 1 });
        visited.add("0#1");
        while (!queue.isEmpty()) {
            Queue<int[]> tmp = new LinkedList<>();
            while (!queue.isEmpty()) {
                int[] cur = queue.poll();

                // no need to Reverse
                int next = cur[0] + cur[1];
                if (next == target)
                    return res + 1;
                int speed = 2 * cur[1];
                // (2^m)-1+2^m = 2*(2^m)-1 < 2*(2^m)+2*k = 2*target, k >= 0，so 2*target is the
                // upper bound for any situation
                if (cur[0] < target * 2 && next > 0 && !visited.contains(next + "#" + speed)) {
                    tmp.add(new int[] { next, speed });
                    visited.add(next + "#" + speed);
                }

                // need to Reverse
                next = cur[0];
                speed = cur[1] > 0 ? -1 : 1;
                if (next > 0 && !visited.contains(next + "#" + speed)) {
                    tmp.add(new int[] { next, speed });
                    visited.add(next + "#" + speed);
                }
            }
            ++res;
            queue = tmp;
        }
        return res;
    }
}
// @lc code=end
