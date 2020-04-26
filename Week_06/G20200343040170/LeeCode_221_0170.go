func maximalSquare(matrix [][]byte) int {
    m := len(matrix)
    if m == 0 {
        return 0
    }
    n := len(matrix[0])
    dp := make([][]int, m+1)
    for i := 0; i <= m; i++ {
        dp[i] = make([]int, n+1)
    }

    ret := 0
    for i := 1; i <= m; i++ {
        for j := 1; j <= n; j++ {
            if matrix[i-1][j-1] == '0' {
                continue
            }
            dp[i][j] = 1 + min(
                dp[i-1][j-1],
                dp[i-1][j],
                dp[i][j-1],
            )
            if dp[i][j] > ret {
                ret = dp[i][j]
            }
        }
    }
    
    if ret == 0 {
        return 0
    }
    return ret * ret
}

func min (i, j, k int) int {
    if i > j {
        if j > k {
            return k
        }
        return j
    }
    if i > k {
        return k
    }
    return i
}
