package level2;

import java.util.Arrays;

public class Solution74 {
    public static void main(String[] args) {
        System.out.println();
        int[][] matrix = new int[][] { { 1, 3 } };
        boolean g = searchMatrix(matrix, 3);
        System.out.println(g);

    }

    // 先找到符合的行再执行二分查找
    public static boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null)
            return false;
        if (matrix.length == 1 && (matrix[0] == null || matrix[0].length <= 0))
            return false;
        int m = matrix.length;
        int n = matrix[0].length;
        if (target > matrix[m - 1][n - 1] || target < matrix[0][0])
            return false;
        int fitRow = -1;
        for (int row = 0; row < m; row++) {
            int min = matrix[row][0];
            int max = matrix[row][n - 1];
            if (target >= min && target <= max) {
                fitRow = row;
                break;
            }
        }
        if (fitRow >= 0) {
            int left = 0;
            int right = n - 1;
            while (left <= right) {
                int mid = (left + right) / 2;
                if (matrix[fitRow][mid] == target)
                    return true;
                if (matrix[fitRow][mid] > target) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }
        }
        return false;
    }

    // 直接二分查找
    public boolean searchMatrix2(int[][] matrix, int target) {
        if (matrix == null)
            return false;
        if (matrix.length == 1 && (matrix[0] == null || matrix[0].length <= 0))
            return false;
        int m = matrix.length;
        int n = matrix[0].length;
        int count = m * n;
        int left = 0;
        int right = count - 1;
        int middle;
        int middleVale;
        while (left <= right) {
            middle = (left + right) / 2;
            // 每行放 n 个 所以要除以 n；余下的为在所在行的 列
            middleVale = matrix[middle / n][middle % n];
            if (target == middleVale)
                return true;
            else {
                if (target < middleVale) {
                    right = middle - 1;
                } else {
                    left = middle + 1;
                }
            }
        }
        return false;
    }
}
