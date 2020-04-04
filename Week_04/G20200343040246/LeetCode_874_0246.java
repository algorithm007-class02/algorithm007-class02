package Week_04.G20200343040246;

import java.util.HashSet;
import java.util.Set;

class LeetCode_874_0246 {
    public static void main(String[] args) {
        int[] commands = new int[]{4,-1,4,-2,4};
        int[][] obstacles = new int[][]{{2,4}};
        System.out.println(new LeetCode_874_0246().robotSim(commands, obstacles));
    }

    public int robotSim(int[] commands, int[][] obstacles) {
        int[] dx = new int[]{0, 1, 0, -1};
        int[] dy = new int[]{1, 0, -1, 0};
        int x = 0, y = 0, di = 0;

        Set<Long> obstacleSet = new HashSet<Long>();
        for (int[] obstacle: obstacles) {
            long ox = (long) obstacle[0] + 30000;
            long oy = (long) obstacle[1] + 30000;
            obstacleSet.add((ox << 16) + oy);
        }

        int ans = 0;
        for (int cmd : commands) {
            if (cmd == -1) {
                di = (di + 1) % 4;
            } else if (cmd == -2) {
                di = (di + 3) % 4;
            } else {
                for (int k = 0; k < cmd; ++k) {
                    int nx = x + dx[di];
                    int ny = y + dy[di];
                    long code = (((long) nx + 30000) << 16) + ((long) ny + 30000);
                    if (!obstacleSet.contains(code)) {
                        x = nx;
                        y = ny;
                        ans = Math.max(ans, x*x + y*y);
                    }
                }
            }
        }
        return ans;
    }
}