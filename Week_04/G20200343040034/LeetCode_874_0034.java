package com.alang.learn.week4;

import java.util.HashSet;

/***
 机器人在一个无限大小的网格上行走，从点 (0, 0) 处开始出发，面向北方。该机器人可以接收以下三种类型的命令：

 -2：向左转 90 度
 -1：向右转 90 度
 1 <= x <= 9：向前移动 x 个单位长度
 在网格上有一些格子被视为障碍物。

 第 i 个障碍物位于网格点  (obstacles[i][0], obstacles[i][1])

 如果机器人试图走到障碍物上方，那么它将停留在障碍物的前一个网格方块上，但仍然可以继续该路线的其余部分。

 返回从原点到机器人的最大欧式距离的平方。

  

 示例 1：

 输入: commands = [4,-1,3], obstacles = []
 输出: 25
 解释: 机器人将会到达 (3, 4)
 示例 2：

 输入: commands = [4,-1,4,-2,4], obstacles = [[2,4]]
 输出: 65
 解释: 机器人在左转走到 (1, 8) 之前将被困在 (1, 4) 处
  

 提示：

 0 <= commands.length <= 10000
 0 <= obstacles.length <= 10000
 -30000 <= obstacle[i][0] <= 30000
 -30000 <= obstacle[i][1] <= 30000
 答案保证小于 2 ^ 31

 来源：力扣（LeetCode）
 链接：https://leetcode-cn.com/problems/walking-robot-simulation
 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LeetCode_874_0034 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] commands = new int[]{4, -1, 3};
        int[][] obstacles = new int[][]{};
        System.out.println(solution.robotSim(commands, obstacles));
        System.out.println(solution.robotSim1(commands, obstacles));
        assert solution.robotSim(commands, obstacles) == 25;
        assert solution.robotSim1(commands, obstacles) == 25;

        commands = new int[]{4, -1, 4, -2, 4};
        obstacles = new int[][]{{2, 4}};
        System.out.println(solution.robotSim(commands, obstacles));
        System.out.println(solution.robotSim1(commands, obstacles));
        assert solution.robotSim(commands, obstacles) == 65;
        assert solution.robotSim1(commands, obstacles) == 65;

        commands = new int[]{7, -2, -2, 7, 5};
        obstacles = new int[][]{{-3, 2}, {-2, 1}, {0, 1}, {-2, 4}, {-1, 0}, {-2, -3}, {0, -3}, {4, 4}, {-3, 3}, {2, 2}};

        System.out.println(solution.robotSim(commands, obstacles));
        System.out.println(solution.robotSim1(commands, obstacles));
        assert solution.robotSim(commands, obstacles) == 4;
        assert solution.robotSim1(commands, obstacles) == 4;

    }

    static class Solution {
        public int robotSim(int[] commands, int[][] obstacles) {
            int[][] dir = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
            int x = 0, y = 0, di = 0, result = 0;
            HashSet<String> obstacleSet = new HashSet<>();
            for (int[] obstacle : obstacles) {
                obstacleSet.add(obstacle[0] + "," + obstacle[1]);
            }
            for (int cmd : commands) {
                if (cmd == -1) {
                    di = (di + 1) % 4;
                } else if (cmd == -2) {
                    di = (di + 4 - 1) % 4;
                } else {
                    for (int i = 1; i <= cmd; i++) {
                        int newX = x + dir[di][0];
                        int newY = y + dir[di][1];
                        if (obstacleSet.contains(newX + "," + newY)) break;
                        x = newX;
                        y = newY;
                        result = Math.max(result, x * x + y * y);
                    }
                }
            }
            return result;
        }

        /**
         * 根据题意 其实可以用 int 来标识障碍 ((obstacles[i][0]+30000) << 16 ) + obstacles[i][1]+30000
         */
        public int robotSim1(int[] commands, int[][] obstacles) {
            int[][] dir = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
            int x = 0, y = 0, di = 0, result = 0;
            HashSet<Integer> obstacleSet = new HashSet<>();
            for (int[] obstacle : obstacles) {
                obstacleSet.add(((obstacle[0] + 30000) << 16) + obstacle[1] + 30000);
            }
            for (int cmd : commands) {
                if (cmd == -1) {
                    di = (di + 1) % 4;
                } else if (cmd == -2) {
                    di = (di + 4 - 1) % 4;
                } else {
                    for (int i = 1; i <= cmd; i++) {
                        int newX = x + dir[di][0];
                        int newY = y + dir[di][1];
                        if (obstacleSet.contains(((newX + 30000) << 16) + newY + 30000)) break;
                        x = newX;
                        y = newY;
                        result = Math.max(result, x * x + y * y);
                    }
                }
            }
            return result;
        }
    }
}
