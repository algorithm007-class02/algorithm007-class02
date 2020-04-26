/*
动态规划
时间复杂度：O(M*N)
空间复杂度：O(1)
*/
class Solution {
public:
	int minPathSum(vector<vector<int>>& grid) {
		for (int i = grid.size() - 1; i >= 0; i--) {
			for (int j = grid[0].size() - 1; j >= 0; j--) {
				if (i == grid.size() - 1 && j != grid[0].size() - 1) {
					grid[i][j] = grid[i][j] + grid[i][j+1];
				} 
				else if (i != grid.size() - 1 && j == grid[0].size() - 1) {
					grid[i][j] = grid[i+1][j] + grid[i][j];
				}
				else if (i != grid.size() - 1 && j != grid[0].size() - 1) {
					grid[i][j] = min(grid[i + 1][j], grid[i][j + 1]) + grid[i][j];
				}
			}
		}
		return grid[0][0];
	}
};