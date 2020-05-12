/*
 * @lc app=leetcode.cn id=1091 lang=cpp
 *
 * [1091] 二进制矩阵中的最短路径
 */

// @lc code=start
class Solution {
public:
    int shortestPathBinaryMatrix(vector<vector<int>> &grid) {
        int n = grid.size();
        if (grid[0][0] == 1 || grid[n - 1][n - 1] == 1) {
            return -1;
        }
        if (n == 1)
            return 1;
        int dir[8][2] = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}, {-1, -1}, {-1, 1}, {1, -1}, {1, 1}};
        queue<pair<int, int>> q;
        q.push(make_pair(0, 0));
        int length = 1;
        grid[0][0] = 2;
        while (!q.empty()) {
            int l = q.size();
            for (int i = 0; i < l; i++) {
                int x = q.front().first;
                int y = q.front().second;
                q.pop();
                if (x == n - 1 && y == n - 1) {
                    return length;
                }
                for (int j = 0; j < 8; j++) {
                    int x1 = x + dir[j][0];
                    int y1 = y + dir[j][1];
                    if (x1 < 0 || y1 < 0 || x1 >= n || y1 >= n || grid[x1][y1]) {
                        continue;
                    }
                    grid[x1][y1] = 2;
                    q.push(make_pair(x1, y1));
                }
            }

            length++;
        }
        return -1;
    }
};
// @lc code=end
