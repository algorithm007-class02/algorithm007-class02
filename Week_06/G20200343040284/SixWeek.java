package com.cactus.cyc.leetcode.sixweek;

/**
 * @author: lengyue
 * @decription:
 * @time: 2020/4/19
 */
public class SixWeek {

    /**
     * 最小路径和
     * @param grid
     * @return
     */
    public int minPathSum(int[][] grid) {
        int m = grid.length;// 行
        int n = grid[0].length; // 列
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 && j != 0) {
                    grid[i][j] = grid[i][j] + grid[i][j - 1];
                } else if (i != 0 && j == 0) {
                    grid[i][j] = grid[i][j] + grid[i - 1][j];
                } else if (i == 0 && j == 0) {
                    grid[i][j] = grid[i][j];
                } else {
                    grid[i][j] = Math.min(grid[i][j - 1], grid[i - 1][j])
                            + grid[i][j];
                }
            }
        }
        return grid[m - 1][n - 1];
    }

    /**
     * 解码方法
     * @param s
     * @return
     */
    public int numDecodings(String s) {
        int n = s.length();
        if (n == 0) return 0;
        int[] memo = new int[n+1];
        memo[n]  = 1;
        memo[n-1] = s.charAt(n-1) != '0' ? 1 : 0;
        for (int i = n - 2; i >= 0; i--) {
            if (s.charAt(i) == '0') continue;
            else memo[i] = (Integer.parseInt(s.substring(i,i+2))<=26) ? memo[i+1]+memo[i+2] : memo[i+1];
        }
        return memo[0];
    }

    /**
     * 戳气球
     * @param nums
     * @return
     */
    public int maxCoins(int[] nums) {
        int[] res = new int[nums.length + 2];
        int n = 1;
        for (int x : nums) if (x > 0) res[n++] = x;
        res[0] = res[n++] = 1;
        int[][] dp = new int[n][n];
        for (int k = 2; k < n; ++k)
            for (int left = 0; left < n - k; ++left) {
                int right = left + k;
                for (int i = left + 1; i < right; ++i)
                    dp[left][right] = Math.max(dp[left][right],
                            res[left] * res[i] * res[right] + dp[left][i] + dp[i][right]);
            }
        return dp[0][n - 1];
    }

    /**
     * 青蛙过河
     * @param stones
     * @return
     */
    public boolean canCross(int[] stones) {
        int len = stones.length;
        boolean[][] dp = new boolean[len][len + 1];
        dp[0][1] = true;
        for(int i = 1; i < len; ++i){
            for(int j = 0; j < i; ++j){
                int diff = stones[i] - stones[j];
                if(diff < 0 || diff > len || !dp[j][diff]) continue;
                dp[i][diff] = true;
                if(diff - 1 >= 0) dp[i][diff - 1] = true;
                if(diff + 1 <= len) dp[i][diff + 1] = true;
                if(i == len - 1) return true;
            }
        }
        return false;
    }

    /**
     * 分隔数组的最大值
     * @param nums
     * @param m
     * @return
     */
    public int splitArray(int[] nums, int m) {
        int max = 0; long sum = 0;
        for (int num : nums) {
            max = Math.max(num, max);
            sum += num;
        }
        if (m == 1) return (int)sum;
        //binary search
        long l = max; long r = sum;
        while (l <= r) {
            long mid = (l + r)/ 2;
            if (valid(mid, nums, m)) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return (int)l;
    }
    private boolean valid(long target, int[] nums, int m) {
        int count = 1;
        long total = 0;
        for(int num : nums) {
            total += num;
            if (total > target) {
                total = num;
                count++;
                if (count > m) {
                    return false;
                }
            }
        }
        return true;
    }

}
