package com.wxs.algorithm1.week06;

/**
 * 类描述  ：
 * 创建人  : 吴绪森
 * 创建时间：2020-04-16
 * 修改人  ：
 * 修改时间：
 * 修改备注：
 * 版    本： V1.0
 */

public class LeetCode_63_0316 {


    public static void main(String[] args) {

        int[][] arr = {
                {0, 0, 0},
                {0, 1, 0},
                {0, 0, 0}
        };


        int[][] arr1 = {

                {0, 0}
        };

        LeetCode_63_0316 uniquePathsWithObstacles63 = new LeetCode_63_0316();


        int i = uniquePathsWithObstacles63.uniquePathsWithObstacles(arr1);
        System.out.println(i);

    }

    public int uniquePathsWithObstacles(int[][] obstacleGrid) {

        // 最外层表示几条数据
        int row = obstacleGrid.length;

        // 内层表示几列
        int col = obstacleGrid[0].length;


        if (obstacleGrid[0][0] == 1) {
            return 0;
        }

        obstacleGrid[0][0] = 1;

        for (int i = 1; i < row; i++) {
            obstacleGrid[i][0] = obstacleGrid[i][0] == 0 && obstacleGrid[i-1][0] == 1 ? 1 : 0;
        }

        for (int i = 1; i < col; i++) {
            obstacleGrid[0][i] = obstacleGrid[0][i] == 0 && obstacleGrid[0][i-1] == 1 ? 1 : 0;
        }


        for (int i = 1; i < row; i++) {
            for (int j = 1; j < col; j++) {

                if (obstacleGrid[i][j] == 1) {
                    obstacleGrid[i][j] = 0;
                } else {
                    obstacleGrid[i][j] = obstacleGrid[i - 1][j] + obstacleGrid[i][j - 1];
                }

            }

        }


        return obstacleGrid[row - 1][col - 1];

    }




}
