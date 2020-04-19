//给定一个由 0 和 1 组成的矩阵，找出每个元素到最近的 0 的距离。 
//
// 两个相邻元素间的距离为 1 。 
//
// 示例 1: 
//输入: 
//
// 
//0 0 0
//0 1 0
//0 0 0
// 
//
// 输出: 
//
// 
//0 0 0
//0 1 0
//0 0 0
// 
//
// 示例 2: 
//输入: 
//
// 
//0 0 0
//0 1 0
//1 1 1
// 
//
// 输出: 
//
// 
//0 0 0
//0 1 0
//1 2 1
// 
//
// 注意: 
//
// 
// 给定矩阵的元素个数不超过 10000。 
// 给定矩阵中至少有一个元素是 0。 
// 矩阵中的元素只在四个方向上相邻: 上、下、左、右。 
// 
// Related Topics 深度优先搜索 广度优先搜索


import java.util.LinkedList;
import java.util.Optional;
import java.util.Queue;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[][] updateMatrix(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        int[][] dp = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                dp[i][j] = matrix[i][j] == 0 ? 0 : 10000;
            }
        }
        //左上角
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i - 1 >= 0)
                    dp[i][j] = Math.min(dp[i][j],dp[i - 1][j] + 1);
                if (j - 1 >= 0)
                    dp[i][j] = Math.min(dp[i][j],dp[i][j - 1] + 1);
            }
        }
        //右上角
        for (int i = m - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                if (i + 1 < m)
                    dp[i][j] = Math.min(dp[i][j],dp[i + 1][j] + 1);
                if (j + 1 < n)
                    dp[i][j] = Math.min(dp[i][j],dp[i][j + 1] + 1);
            }
        }
        return dp;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
/**
 * public int[][] updateMatrix(int[][] matrix) {
 *         Queue<int[]> queue = new LinkedList<>();
 *         int m = matrix.length, n = matrix[0].length;
 *         for (int i = 0; i < m; i++) {
 *             for (int j = 0; j < n; j++) {
 *                 if (matrix[i][j] == 0)
 *                     queue.offer(new int[]{i,j});
 *                 else matrix[i][j] = -1;
 *             }
 *         }
 *         int[] dx = {-1,1,0,0};
 *         int[] dy = {0,0,-1,1};
 *         while (!queue.isEmpty()) {
 *             int[] point = queue.poll();
 *             int x = point[0], y = point[1];
 *             for (int i = 0; i < 4; i++) {
 *                 int newX = x + dx[i];
 *                 int newY = y + dy[i];
 *                 if (newX >= 0 && newX < m && newY >= 0 && newY < n && matrix[newX][newY] == -1) {
 *                     matrix[newX][newY] = matrix[x][y] + 1;
 *                     queue.offer(new int[]{newX,newY});
 *                 }
 *             }
 *         }
 *         return matrix;
 *     }
 */
/**
 * public int[][] updateMatrix(int[][] matrix) {
 *         int[] dx = {-1,1,0,0};
 *         int[] dy = {0,0,-1,1};
 *         Queue<int[]> queue = new LinkedList<>();
 *         int m = matrix.length, n = matrix[0].length;
 *         int[][] res = new int[m][n];
 *         for (int i = 0; i < m; i++) {
 *             for (int j = 0; j < n; j++) {
 *                 if (matrix[i][j] == 0) {
 *                     for (int k = 0; k < 4; k++) {
 *                         int x = i + dx[k];
 *                         int y = j + dy[k];
 *                         if (x >= 0 && x < m && y >= 0 && y < n && matrix[x][y] == 1 && res[x][y] == 0 ) {
 *                             res[x][y] = 1;
 *                             queue.offer(new int[]{x,y});
 *                         }
 *                     }
 *                 }
 *             }
 *         }
 *         while (!queue.isEmpty()) {
 *             int[] point = queue.poll();
 *             int x = point[0], y = point[1];
 *             for (int i = 0; i < 4; i++) {
 *                 int newX = x + dx[i];
 *                 int newY = y + dy[i];
 *                 if (newX >= 0 && newX < m && newY >= 0 && newY < n && matrix[newX][newY] == 1 && res[newX][newY] == 0) {
 *                     res[newX][newY] = res[x][y] + 1;
 *                     queue.offer(new int[]{newX,newY});
 *                 }
 *             }
 *         }
 *         return res;
 *     }
 */
