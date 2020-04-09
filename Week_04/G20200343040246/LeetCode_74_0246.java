package Week_04.G20200343040246;

class LeetCode_74_0246 {
    public static void main(String[] args) {
        int[][] matrix = new int[][]{
            {1,   3,  5,  7},
            {10, 11, 16, 20},
            {23, 30, 34, 50},
        };
        int target = 3;
        System.out.println(new LeetCode_74_0246().searchMatrix(matrix, target));
    }

    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        if (m == 0) return false;
        int n = matrix[0].length;
        int left = 0, right = m * n - 1;

        int pivotIdx, pivotElement;
        while (left <= right) {
            pivotIdx = (left + right) >>> 1;
            pivotElement = matrix[pivotIdx / n][pivotIdx % n];
            if (target == pivotElement) {
                return true;
            } else if (target < pivotElement) {
                right = pivotIdx - 1;
            } else {
                left = pivotIdx + 1;
            }
        }
        return false;
    }
}