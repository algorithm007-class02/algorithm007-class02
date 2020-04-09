class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix.length == 0 || matrix == null) {
            return false;
        }

        int height = matrix.length;
        int width = matrix[0].length;

        int head = 0, tail = height*width-1;

        while (head <= tail) {
            int mid = head + (tail-head) / 2;
            if (matrix[mid/width][mid%width] == target) {
                return true;
            }
            if (matrix[mid/width][mid%width] > target) {
                tail = mid - 1;
            } else {
                head = mid + 1;
            }
        }
        return false;
    }
}