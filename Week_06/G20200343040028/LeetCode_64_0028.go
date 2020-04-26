package G20200343040028

func minPathSum(grid [][]int) int {
	// 取纵向
	m := len(grid)
	// 取横向
	n := len(grid[0])

	if m == 0 {
		return 0
	}

	// 定义一个二维切片来存起点到该点的最小值
	dp := make([][]int,m)

	for i:=0;i<m;i++ {
		dp[i] = make([]int,n)
		for j:=0;j<n;j++ {
			var left, top int
			if i == 0 && j == 0 {
				dp[0][0] = grid[0][0]
				continue
			}
			if i == 0 {
				dp[0][j] = dp[0][j-1]+grid[i][j]
				continue
			}  else {
				left = dp[i-1][j]
			}

			if j == 0 {
				dp[i][0] = dp[i-1][0]+grid[i][j]
				continue
			} else {
				top = dp[i][j-1]
			}
			dp[i][j] = min(left,top)+grid[i][j]
		}
	}
	return dp[m-1][n-1]
}

func min(a,b int) int {
	if a < b {
		return a
	}
	return b
}

