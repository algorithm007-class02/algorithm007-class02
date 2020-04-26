func numDecodings(s string) int {
    n := len(s)
    if n == 0 {
        return 0
    }
    if s[0] == '0' {
        return 0
    }

    var si, si1 int
    dp := make([]int, n+1)
    dp[0] = 1
    dp[1] = 1
    for i := 2; i <= n; i++ {
        si, _ = strconv.Atoi(string(s[i-1])) // 1
        si1, _ = strconv.Atoi(string(s[i-2])) // 1
        if si == 0 {
            if si1 == 1 || si1 == 2 {
                dp[i] = dp[i-2]
            } else {
                return 0
            }
        } else {
            if si1 == 1 || ( si1 == 2 && si <= 6) {
                dp[i] = dp[i-1] + dp[i-2]
            } else {
                dp[i] = dp[i-1]
            }
        }
    }

    return dp[n]
}
