/*
 * @Author: mingxing.huang
 * @Date: 2020-04-18 16:52:46
 */
/**
 * 最小路径和
 * @param {number[][]} grid
 * @return {number}
 */
var minPathSum = function (grid) {
    /**
     * dp[i][j]：从（i, j）出发，到右下角路径和的最小值
     * 因为只能向右或向下走一步，
     * 所以，（i, j）的路径和等于从右边和下边两个位置出发的路径和较小者加上本身的值，即：
     * dp[i][j] = min(dp[i+1][j], dp[i][j+1]) + grid[i][j]
     * 本题，从右下角开始倒推，方便计算，先计算最后一行和最后一列，到右下角的路径
     */
    let row = grid.length;
    let col = grid[0].length;
    let dp = Array.from(Array(row), () => Array(col).fill(0));
    for (let i = row - 1; i >= 0; i--) {
        for (let j = col - 1; j >= 0; j--) {
            if (i === row - 1 && j !== col - 1) {
                dp[i][j] = dp[i][j + 1] + grid[i][j];
            } else if (j === col - 1 && i !== row - 1) {
                dp[i][j] = dp[i + 1][j] + grid[i][j];
            } else if (i !== row - 1 && j !== col - 1) {
                dp[i][j] = Math.min(dp[i + 1][j], dp[i][j + 1]) + grid[i][j];
            } else {
                dp[i][j] = grid[i][j];
            }
        }
    }
    return dp[0][0];
}