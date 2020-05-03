
// 64. 最小路径和
// https://leetcode-cn.com/problems/minimum-path-sum/

// 解法1: 动态规划
// 时间： O(N^2)
// 空间： O(1)
// 在原来二维数组上进行计算

class Solution {
public:
	int minPathSum(vector<vector<int>>& grid) {
		int n = grid.size();
		if(n==0) return 0;
		int m = grid[0].size();
		if(m==0) return 0;
		for(int i=1; i<m; i++) {
			grid[0][i] += grid[0][i-1];
		}
		for(int i=1; i<n; i++) {
			grid[i][0] += grid[i-1][0];
		}
		for(int i=1; i<n; i++) {
			for(int j=1; j<m; j++) {
				grid[i][j] += min(grid[i-1][j], grid[i][j-1]);
			}
		}
		return grid[n-1][m-1];
	}
};
