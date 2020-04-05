package com.logic;

/**
 * @Auther: welllu
 * @Date: 2020/4/5 17:55
 * @Description:https://leetcode-cn.com/problems/search-a-2d-matrix/
 */
public class LeeCode_74_0226 {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        if(m == 0) return false;
        int n = matrix[0].length;

        //二分查找
        int left  = 0;
        int right = m * n - 1;
        while(left <= right) {
            int mid = (left + right) / 2;
            int sourceElement = matrix[mid / n][mid % n];
            if(target == sourceElement) {
                return true;
            }else {
                if(target < sourceElement) {
                    right = mid - 1;
                }else {
                    left = mid + 1;
                }
            }
        }
        return false;
    }
}
