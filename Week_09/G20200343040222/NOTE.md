学习笔记

DP顺推模版

void dp() {
    
    dp[][] = new in[M + 1][N + 1];
    for (nt i = 0; i < M + 1; i++) {
        for (int j = 0; j < N + 1; j++) {
            dp[i][j] = process(dp[i`][j`]...); 
        }
    }
    return dp[M][N]; 
}