package homework

import "math"

func minPathSum(grid [][]int) int {
	m := len(grid)
	n := len(grid[0])

	dp := make([][]int, m)
	for i:=0; i<m; i++ {
		dp[i] = make([]int, n)
	}
	dp[0][0] = grid[0][0]


	for i:=1; i<m; i++ {
		dp[i][0] = dp[i - 1][0] + grid[i][0]
	}

	for i:=1; i<n; i++ {
		dp[0][i] = dp[0][i - 1] + grid[0][i];
	}

	for i:=1; i<m; i++ {
		for j:= 1; j<n; j++{
			dp[i][j] = int(math.Min(float64(dp[i - 1][j]), float64(dp[i][j - 1]))) + grid[i][j]
		}
	}


	return dp[m-1][n-1]
}
