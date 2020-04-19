package week04.g20200343040172;

import java.util.HashSet;
import java.util.Set;

/**
 * https://leetcode-cn.com/problems/walking-robot-simulation/
 * LeetCode-874 Walking robot simulation  模拟行走机器人
 */

public class LeetCode_874_0172 {
    public static void main(String[] args) {
        int[] commands = {4, -1, 4, -2, 4};
        int[][] obstacles = {{2, 4}};
        System.out.println(robotSim(commands, obstacles));
    }

    /**
     * 官方题解，使用Long再加移位来保存障碍物的坐标
     * @param commands
     * @param obstacles
     * @return
     */
    public static int robotSim(int[] commands, int[][] obstacles) {
        int[] dx = new int[]{0, 1, 0, -1};
        int[] dy = new int[]{1, 0, -1, 0};
        int x = 0, y = 0, di = 0;

        // Encode obstacles (x, y) as (x+30000) * (2^16) + (y+30000)
        Set<Long> obstacleSet = new HashSet();
        for (int[] obstacle : obstacles) {
            long ox = (long) obstacle[0] + 30000;
            long oy = (long) obstacle[1] + 30000;
            obstacleSet.add((ox << 16) + oy);
        }

        int ans = 0;
        for (int cmd : commands) {
            //left
            if (cmd == -2) {
                di = (di + 3) % 4;
            }
            //right
            else if (cmd == -1) {
                di = (di + 1) % 4;
            } else {
                for (int k = 0; k < cmd; ++k) {
                    int nx = x + dx[di];
                    int ny = y + dy[di];
                    long code = (((long) nx + 30000) << 16) + ((long) ny + 30000);
                    if (!obstacleSet.contains(code)) {
                        x = nx;
                        y = ny;
                        ans = Math.max(ans, x * x + y * y);
                    }
                }
            }
        }

        return ans;
    }

    /**
     * 官方题解改编版，使用String存储障碍物坐标
     *
     * @param commands
     * @param obstacles
     * @return
     */
    public static int robotSim_2(int[] commands, int[][] obstacles) {
        int[] dx = new int[]{0, 1, 0, -1};
        int[] dy = new int[]{1, 0, -1, 0};
        int x = 0, y = 0, di = 0;

        // Encode obstacles (x, y) as (x+30000) * (2^16) + (y+30000)
        Set<String> obstacleSet = new HashSet();
        for (int[] obstacle : obstacles) {
            String str = obstacle[0] + " " + obstacle[1];
            obstacleSet.add(str);
        }

        int ans = 0;
        for (int cmd : commands) {
            //left
            if (cmd == -2) {
                di = (di + 3) % 4;
                //right
            } else if (cmd == -1) {
                di = (di + 1) % 4;
            } else {
                for (int k = 0; k < cmd; ++k) {
                    int nx = x + dx[di];
                    int ny = y + dy[di];
                    String str = nx + " " + ny;
                    if (!obstacleSet.contains(str)) {
                        x = nx;
                        y = ny;
                        ans = Math.max(ans, x * x + y * y);
                    }
                }
            }
        }
        return ans;
    }
}
