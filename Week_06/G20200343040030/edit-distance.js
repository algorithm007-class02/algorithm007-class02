/**
 * @param {string} word1
 * @param {string} word2
 * @return {number}
 */
let minDistance = (word1, word2) => {
  //1.初始化
  let n = word1.length,
    m = word2.length;
  let dp = new Array(n + 1).fill(0).map(() => new Array(m + 1).fill(0));
  for (let i = 0; i <= n; i++) {
    dp[i][0] = i;
  }
  for (let j = 0; j <= m; j++) {
    dp[0][j] = j;
  }
  //2.dp
  for (let i = 0; i <= n; i++) {
    for (let j = 0; j <= m; j++) {
      if (i * j) {
        dp[i][j] =
          word1[i - 1] == word2[j - 1]
            ? dp[i - 1][j - 1]
            : Math.min(dp[i - 1][j], dp[i][j - 1], dp[i - 1][j - 1]) + 1;
      } else {
        dp[i][j] = i + j;
      }
    }
  }
  return dp[n][m];
};
