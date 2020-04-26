func minPathSum(grid [][]int) int {
    if len(grid) == 0 {
        return 0
    }
    m := len(grid)
    n := len(grid[0])
    dp := make([][]int, m)
    for i := 0; i < m; i++ {
        dp[i] = make([]int, n)
    }
    dp[0][0] = grid[0][0]
    for i := 1; i < m; i++ {
        dp[i][0] = grid[i][0] + dp[i-1][0]
    }
    for j := 1; j < n; j++ {
        dp[0][j] = grid[0][j] + dp[0][j-1]
    }
    for i := 1; i < m; i++ {
        for j := 1; j < n; j++ {
            dp[i][j] = min(dp[i-1][j], dp[i][j-1]) + grid[i][j]
        }
    }
    return dp[m-1][n-1]
}

func min(i, j int) int {
    if i > j {
        return j
    }
    return i
}
