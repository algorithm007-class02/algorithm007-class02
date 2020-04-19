//dp[i][j] = min(dp[i - 1][j] + grid[i][j], dp[i][j - 1] + grid[i][j])
//一维DP
class Solution {
public:
    int minPathSum(vector<vector<int>>& grid) {
        if (grid.size() == 0 || grid[0].size() == 0) return 0;
        int m = grid.size();
        int n = grid[0].size();
        vector<int> pre(m, grid[0][0]);//存储i行j - 1列
        vector<int> cur(m, 0);//存储i行j列
        for (int i = 1; i < m; ++i) {
            pre[i] = pre[i - 1] + grid[i][0];//第0列
        }
        for (int j = 1; j < n; ++j) {
            cur[0] = pre[0] + grid[0][j];//初始化第0行
            for (int i = 1; i < m; ++i) {
                cur[i] = min(cur[i - 1], pre[i]) + grid[i][j];//第i行第j列
            }
            swap(pre, cur);//更新pre列
        }
        return pre[m - 1];
    }
};