class Solution {
    int getSum(int[][] sum, int row, int col) {
        return (row < sum.length && col < sum[0].length) ?
                sum[row][col] : Integer.MAX_VALUE;
    }

    public int minPathSum(int[][] dp) {
        assert dp != null;
        if (dp.length == 0 || dp[0].length == 0) {
            return 0;
        }

        for (int i = dp.length - 1; i >= 0; i--) {
            for (int j = dp[0].length - 1; j >= 0; j--) {
                if (i == dp.length - 1 && j == dp[0].length -1 ) {
                    continue;
                }

                dp[i][j] += Math.min(
                        getSum(dp, i + 1, j), getSum(dp, i, j + 1));
            }
        }
        return dp[0][0];
    }
}
