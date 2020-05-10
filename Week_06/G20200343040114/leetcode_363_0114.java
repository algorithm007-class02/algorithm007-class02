// 附上完整代码
public int maxSumSubmatrix(int[][] matrix, int k) {
    int rows = matrix.length, cols = matrix[0].length, max = Integer.MIN_VALUE;
    // O(cols ^ 2 * rows)
    for (int l = 0; l < cols; l++) { // 枚举左边界
        int[] rowSum = new int[rows]; // 左边界改变才算区域的重新开始
        for (int r = l; r < cols; r++) { // 枚举右边界
            for (int i = 0; i < rows; i++) { // 按每一行累计到 dp
                rowSum[i] += matrix[i][r];
            }
            max = Math.max(max, dpmax(rowSum, k));
            if (max == k) return k; // 尽量提前
        }
    }
    return max;
}
// 在数组 arr 中，求不超过 k 的最大值
private int dpmax(int[] arr, int k) {
    int rollSum = arr[0], rollMax = rollSum;
    // O(rows)
    for (int i = 1; i < arr.length; i++) {
        if (rollSum > 0) rollSum += arr[i];
        else rollSum = arr[i];
        if (rollSum > rollMax) rollMax = rollSum;
    }
    if (rollMax <= k) return rollMax;
    // O(rows ^ 2)
    int max = Integer.MIN_VALUE;
    for (int l = 0; l < arr.length; l++) {
        int sum = 0;
        for (int r = l; r < arr.length; r++) {
            sum += arr[r];
            if (sum > max && sum <= k) max = sum;
            if (max == k) return k; // 尽量提前
        }
    }
    return max;
}