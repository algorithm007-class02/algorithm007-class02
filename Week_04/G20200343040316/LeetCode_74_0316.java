package com.wxs.algorithm1.week04;

/**
 * 类描述  ：
 * 创建人  : 吴绪森
 * 创建时间：2020-04-05
 * 修改人  ：
 * 修改时间：
 * 修改备注：
 * 版    本： V1.0
 */

public class LeetCode_74_0316 {


    /**
     * 二分查找
     * <p>
     * index / n = low
     * index % n = col
     *
     * @param matrix
     * @param target
     * @return
     */

    public boolean searchMatrix(int[][] matrix, int target) {



        if(matrix == null){
            return false;
        }

        // 找出m n

        int m = matrix.length;
        int n = matrix[0].length;


        int high = m * n - 1;
        int low = 0;
        int mid, midVlaue;

        while (low <= high) {
            mid = low + (high - low) / 2;

            midVlaue = matrix[mid / n][mid % n];

            if (midVlaue == target) {
                return true;
            } else if (midVlaue > target) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return false;

    }


}
