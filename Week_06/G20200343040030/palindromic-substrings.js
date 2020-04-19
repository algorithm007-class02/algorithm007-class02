/**
 * @param {string} s
 * @return {number}
 */
var countSubstrings = function (s) {
  //动态规划
  let dp = [...new Array(s.length + 1)].map(() =>
      new Array(s.length + 1).fill(false)
    ),
    res = 0;
  for (let i = s.length - 1; i >= 0; i--) {
    for (let j = i; j < s.length; j++) {
      dp[i][j] = s[i] === s[j] && (j - i <= 2 || dp[i + 1][j - 1]);
      if (dp[i][j]) res++;
    }
  }
  return res;
};
