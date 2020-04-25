package com.yequan.leetcode.algorithm.search.BinarySearch.searchMatrix_74;

/**
 * //编写一个高效的算法来判断 m x n 矩阵中，是否存在一个目标值。该矩阵具有如下特性：
 * //
 * //
 * // 每行中的整数从左到右按升序排列。
 * // 每行的第一个整数大于前一行的最后一个整数。
 * //
 * //
 * // 示例 1:
 * //
 * // 输入:
 * //matrix = [
 * //  [1,   3,  5,  7],
 * //  [10, 11, 16, 20],
 * //  [23, 30, 34, 50]
 * //]
 * //target = 3
 * //输出: true
 * //
 * //
 * // 示例 2:
 * //
 * // 输入:
 * //matrix = [
 * //  [1,   3,  5,  7],
 * //  [10, 11, 16, 20],
 * //  [23, 30, 34, 50]
 * //]
 * //target = 13
 * //输出: false
 * // Related Topics 数组 二分查找
 *
 * @author : Administrator
 * @date : 2020/4/5
 */
public class SearchMatrix {

    public static void main(String[] args) {
        int[][] matrix = {
                {1, 3, 5, 7},
                {10, 11, 16, 20},
                {23, 30, 34, 50}
        };
        int[][] matrix2 = {{}};
        SearchMatrix searchMatrix = new SearchMatrix();
        boolean res = searchMatrix.searchMatrix1(matrix2, 3);
        System.out.println(res);
    }

    /**
     * 二分法查找
     * 1.先对列进行二分法查找
     * 2.再队行二分查找
     *
     * @param matrix
     * @param target
     * @return
     */
    public boolean searchMatrix1(int[][] matrix, int target) {
        if (null == matrix || matrix.length == 0) {
            return false;
        }
        int row = matrix.length;
        if (matrix[0] == null || matrix[0].length == 0) {
            return false;
        }
        if (target < matrix[0][0]) {
            return false;
        }
        int column = matrix[0].length;
        if (target > matrix[row - 1][column - 1]) {
            return false;
        }
        //第一步先确定所在行
        int rowLow = 0;
        int rowHigh = row - 1;
        while (rowLow <= rowHigh) {
            int rowMid = rowLow + ((rowHigh - rowLow) >> 1);
            if (matrix[rowMid][0] == target) {
                return true;
            } else if (matrix[rowMid][0] > target) {
                rowHigh = rowMid - 1;
            } else {
                rowLow = rowMid + 1;
            }
        }
        //第二部确定列
        int rowIndex = rowHigh;
        int columnLeft = 0;
        int columnRight = column - 1;
        while (columnLeft <= columnRight) {
            int columnMid = columnLeft + ((columnRight - columnLeft) >> 1);
            if (matrix[rowIndex][columnMid] == target) {
                return true;
            } else if (matrix[rowIndex][columnMid] > target) {
                columnRight = columnMid - 1;
            } else {
                columnLeft = columnMid + 1;
            }
        }
        return false;
    }

    /**
     * 二分法
     * 将矩阵视作一个row*column的数组
     * 则mid = left+((right-left)>>1)落在矩阵中的位置为
     * 行: mid/column
     * 列: mid%column
     *
     * @param matrix
     * @param target
     * @return
     */
    public boolean searchMatrix2(int[][] matrix, int target) {
        int m = matrix.length;
        if (m == 0) {
            return false;
        }
        int n = matrix[0].length;
        // 二分查找
        int left = 0, right = m * n - 1;
        int pivotIdx, pivotElement;
        while (left <= right) {
            pivotIdx = left + ((right - left) >> 1);
            pivotElement = matrix[pivotIdx / n][pivotIdx % n];
            if (target == pivotElement) {
                return true;
            } else {
                if (target < pivotElement) {
                    right = pivotIdx - 1;
                } else {
                    left = pivotIdx + 1;
                }
            }
        }
        return false;
    }


}
