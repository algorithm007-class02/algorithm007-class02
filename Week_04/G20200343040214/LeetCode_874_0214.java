package level1;

import java.util.HashSet;
import java.util.Set;

public class Solution874 {
    public static void main(String[] args) {
        int[] commands = new int[] { 4, -1, 4, -2, 4 };
        int[][] obstacles = new int[][] { { 2, 4 } };
        System.out.println(robotSim(commands, obstacles));
    }

    // 模拟行走机器人
    public static int robotSim(int[] commands, int[][] obstacles) {
        if (commands == null || commands.length <= 0)
            return 0;
        // 北 西 南 东
        int[][] dir = new int[][] { { 0, 1 }, { -1, 0 }, { 0, -1 }, { 1, 0 } };
        // -2 左 90 0-> 1 3->0 (dir+1)%4
        // -1 右 90 0-> 3 1->0 2->1 3-> 2 (dir+3)%4
        // 记录有障碍物的位置标记
        Set<String> flag = new HashSet<>();
        for (int[] obstacle : obstacles) {
            flag.add(obstacle[0] + "," + obstacle[1]);
        }
        int x = 0;
        int y = 0;
        int dir_index = 0;
        int res = 0;
        for (int c : commands) {
            if (c == -1) {
                dir_index = (dir_index + 3) % 4;
            }
            if (c == -2) {
                dir_index = (dir_index + 1) % 4;
            }

            if (c > 0) {
                int offsetX = dir[dir_index][0];
                int offsetY = dir[dir_index][1];
                for (int i = 1; i <= c; i++) {
                    int nextX = x + offsetX;
                    int nextY = y + offsetY;
                    if (flag.contains(nextX + "," + nextY)) {
                        break;
                    } else {
                        x = nextX;
                        y = nextY;
                        res = Math.max(res, x * x + y * y);
                    }
                }
            }

        }
        return res;
    }
}
