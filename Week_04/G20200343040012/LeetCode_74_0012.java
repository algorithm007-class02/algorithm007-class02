class Solution {

    /**
     * 标准二分查找
     *
     * @param matrix
     * @param target
     * @return
     */
    public boolean searchMatrix(int[][] matrix, int target) {
        int row = matrix.length;
        if (row == 0) {
            return false;
        }

        int column = matrix[0].length;
        int mid = 0;
        int midItem = 0;
        int left = 0;
        int right = column * row - 1;

        while (left <= right) {
            mid = (right + left) / 2;
            midItem = matrix[mid / column][mid % column];
            if (midItem == target) {
                return true;
            }
            if (midItem > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return false;
    }
}