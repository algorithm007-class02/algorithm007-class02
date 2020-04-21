package com.yequan.leetcode.dp.uniquePathsWithObstacles_63;

/**
 * //一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为“Start” ）。
 * //
 * // 机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为“Finish”）。
 * //
 * // 现在考虑网格中有障碍物。那么从左上角到右下角将会有多少条不同的路径？
 * //
 * //
 * //
 * // 网格中的障碍物和空位置分别用 1 和 0 来表示。
 * //
 * // 说明：m 和 n 的值均不超过 100。
 * //
 * // 示例 1:
 * //
 * // 输入:
 * //[
 * //  [0,0,0],
 * //  [0,1,0],
 * //  [0,0,0]
 * //]
 * //输出: 2
 * //解释:
 * //3x3 网格的正中间有一个障碍物。
 * //从左上角到右下角一共有 2 条不同的路径：
 * //1. 向右 -> 向右 -> 向下 -> 向下
 * //2. 向下 -> 向下 -> 向右 -> 向右
 * //
 * // Related Topics 数组 动态规划
 *
 * @author : Administrator
 * @date : 2020/4/19
 */
public class UniquePathsWithObstacles {

    /**
     * 动态规划
     * 1.如果[0][0]位置为1,则机器人无法移动
     * 2.处理第一行与第一列:
     * 第一列:第一列中有一个位置为 1,则该位置与该位置以后的都无法移动
     * 第一行:第一行中有一个位置为 1,则该位置与该位置以后的都无法移动
     * 3.其他位置
     * 动态转移方程 dp[i][j] = dp[i-1][j] + dp[i][j-1]
     * 如果该位置为 1, 则dp[i][j] = 0
     *
     * @param obstacleGrid
     * @return
     */
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if (obstacleGrid[0][0] == 1) {
            return 0;
        }
        int row = obstacleGrid.length;
        int column = obstacleGrid[0].length;
        obstacleGrid[0][0] = 1;
        //处理第一行
        for (int i = 1; i < column; i++) {
            obstacleGrid[0][i] = (obstacleGrid[0][i] == 0 && obstacleGrid[0][i - 1] == 1) ? 1 : 0;
        }
        //处理第一列
        for (int i = 1; i < row; i++) {
            obstacleGrid[i][0] = (obstacleGrid[i][0] == 0 && obstacleGrid[i - 1][0] == 1) ? 1 : 0;
        }
        for (int i = 1; i < row; i++) {
            for (int j = 1; j < column; j++) {
                obstacleGrid[i][j] = obstacleGrid[i][j] == 1
                        ? 0
                        : (obstacleGrid[i - 1][j] + obstacleGrid[i][j - 1]);
            }
        }
        return obstacleGrid[row - 1][column - 1];
    }

}
