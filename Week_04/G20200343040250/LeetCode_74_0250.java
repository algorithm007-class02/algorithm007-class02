class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int totalRow = matrix.length;
        if (totalRow == 0) return false;
        int totalCol = matrix[0].length;

        int start = 0, end = totalRow * totalCol - 1;
        int mid, midValue;

        while (start <= end) {
            mid = (start + end) / 2;
            midValue = matrix[mid / totalCol][mid % totalCol];

            if (midValue == target) {
                return true;
            } else if (midValue > target) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return false;
    }
}