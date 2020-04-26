import java.util.HashSet;
import java.util.Set;

/*
 * @lc app=leetcode.cn id=874 lang=java
 *
 * [874] 模拟行走机器人
 *
 * https://leetcode-cn.com/problems/walking-robot-simulation/description/
 *
 * algorithms
 * Easy (33.12%)
 * Likes:    83
 * Dislikes: 0
 * Total Accepted:    7.1K
 * Total Submissions: 20.9K
 * Testcase Example:  '[4,-1,3]\n[]'
 *
 * 机器人在一个无限大小的网格上行走，从点 (0, 0) 处开始出发，面向北方。该机器人可以接收以下三种类型的命令：
 * 
 * 
 * -2：向左转 90 度
 * -1：向右转 90 度
 * 1 <= x <= 9：向前移动 x 个单位长度
 * 
 * 
 * 在网格上有一些格子被视为障碍物。
 * 
 * 第 i 个障碍物位于网格点  (obstacles[i][0], obstacles[i][1])
 * 
 * 如果机器人试图走到障碍物上方，那么它将停留在障碍物的前一个网格方块上，但仍然可以继续该路线的其余部分。
 * 
 * 返回从原点到机器人的最大欧式距离的平方。
 * 
 * 
 * 
 * 示例 1：
 * 
 * 输入: commands = [4,-1,3], obstacles = []
 * 输出: 25
 * 解释: 机器人将会到达 (3, 4)
 * 
 * 
 * 示例 2：
 * 
 * 输入: commands = [4,-1,4,-2,4], obstacles = [[2,4]]
 * 输出: 65
 * 解释: 机器人在左转走到 (1, 8) 之前将被困在 (1, 4) 处
 * 
 * 
 * 
 * 
 * 提示：
 * 
 * 
 * 0 <= commands.length <= 10000
 * 0 <= obstacles.length <= 10000
 * -30000 <= obstacle[i][0] <= 30000
 * -30000 <= obstacle[i][1] <= 30000
 * 答案保证小于 2 ^ 31
 * 
 * 
 */

// @lc code=start
class Solution {
    public int robotSim(int[] commands, int[][] obstacles) {
        // 数组的排列，可以按象限顺时针，或者逆时针排列，题目一开始朝北，也就是 dx = 0, dy = 1;
        int[] dx = new int[] { 0, -1, 0, 1 };
        int[] dy = new int[] { 1, 0, -1, 0 };
        int x = 0, y = 0, ans = 0, di = 0;
        Set<Long> obstacleSet = new HashSet<>();
        for (int i = 0; i < obstacles.length; i++) {
            long ox = (long) obstacles[i][0] + 20000;
            long oy = (long) obstacles[i][1] + 20000;
            obstacleSet.add((ox << 16) + oy);
        }
        for (int i = 0; i < commands.length; i++) {
            int cmd = commands[i];
            if (cmd == -2) {
                // 假设 di == 0, 那么 dx[0] = 0, dy[0] = 1，左转后应该向左走，也就是
                // dx = -1, dy = 0,那么 di = 1;
                di = (di + 1) % 4;
            } else if (cmd == -1) {
                // 向右，同上面一样的假设，向右转后，应该往右走，那么 dx = 1, dy = 0;
                // 即 di = 1;
                di = (di + 3) % 4;
            } else {
                for (int j = 0; j < cmd; j++) {
                    int newX = x + dx[di];
                    int newY = y + dy[di];
                    long code = (((long) newX + 20000) << 16) + ((long) newY + 20000);
                    if (!obstacleSet.contains(code)) {
                        x = newX;
                        y = newY;
                        ans = Math.max(ans, x * x + y * y);
                    }
                }
            }
        }
        return ans;
    }
}
// @lc code=end
