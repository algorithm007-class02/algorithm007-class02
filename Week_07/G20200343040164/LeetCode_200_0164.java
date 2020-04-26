//给定一个由 '1'（陆地）和 '0'（水）组成的的二维网格，计算岛屿的数量。一个岛被水包围，并且它是通过水平方向或垂直方向上相邻的陆地连接而成的。你可以假设
//网格的四个边均被水包围。 
//
// 示例 1: 
//
// 输入:
//11110
//11010
//11000
//00000
//
//输出: 1
// 
//
// 示例 2: 
//
// 输入:
//11000
//11000
//00100
//00011
//
//输出: 3
// 
// Related Topics 深度优先搜索 广度优先搜索 并查集


import java.util.LinkedList;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    class UnionFind {
        int count;
        int[] parent;
        int[] rank;
        public UnionFind(char[][] grid) {
            count = 0;
            int m = grid.length, n = grid[0].length;
            parent = new int[m * n];
            rank = new int[m * n];
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (grid[i][j] == '1') {
                        parent[i * n + j] = i * n + j;
                        count++;
                    }
                    rank[i * n + j] = 0;
                }
            }
        }
        public int find(int i) {
            if (parent[i] != i) parent[i] = find(parent[i]);
            return parent[i];
        }
        public void union(int x, int y) {
            int rootx = find(x), rooty = find(y);
            if (rootx != rooty) {
                if (rank[rootx] > rank[rooty])  parent[rooty] = rootx;
                else if (rank[rootx] < rank[rooty]) parent[rootx] = rooty;
                else {
                    parent[rooty] =rootx;
                    rank[rootx]++;
                }
                count--;
            }
        }
        public int getCount() {
            return count;
        }
    }
    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0) return 0;
        int nr = grid.length, nc = grid[0].length;
        int numIslands = 0;
        UnionFind unionFind = new UnionFind(grid);
        for (int r = 0; r < nr; r++) {
            for (int c = 0; c < nc; c++) {
                if (grid[r][c] == '1') {
                    grid[r][c] = '0';
                    if (r - 1 >= 0 && grid[r - 1][c] == '1') unionFind.union(r * nc + c,(r - 1) * nc + c);
                    if (r + 1 < nr && grid[r + 1][c] == '1') unionFind.union(r * nc + c,(r + 1) * nc + c);
                    if (c - 1 >= 0 && grid[r][c - 1] == '1') unionFind.union(r * nc + c,r * nc + (c - 1));
                    if (c + 1 < nc && grid[r][c + 1] == '1') unionFind.union(r * nc + c,r * nc + (c + 1));
                }
            }
        }
        return unionFind.getCount();
    }

}
//leetcode submit region end(Prohibit modification and deletion)
/**
 * class Solution {
 *     private static final int[] dx = {-1,0,1,0};
 *     private static final int[] dy = {0,-1,0,1};
 *     private boolean[][] marked;
 *     private int rows;
 *     private int cols;
 *     private char[][] grid;
 *     public int numIslands(char[][] grid) {
 *         rows = grid.length;
 *         if (rows == 0) return 0;
 *         cols = grid[0].length;
 *         this.grid = grid;
 *         marked = new boolean[rows][cols];
 *         int count = 0;
 *         for (int i = 0; i < rows; i++) {
 *             for (int j = 0; j < cols; j++) {
 *                 if (!marked[i][j] && grid[i][j] == '1') {
 *                     count++;
 *                     dfs(i,j);
 *                 }
 *             }
 *         }
 *         return count;
 *     }
 *     void dfs(int i, int j) {
 *         marked[i][j] = true;
 *         for (int k = 0; k < 4; k++) {
 *             int newX = i + dx[k];
 *             int newY = j + dy[k];
 *             if (inArea(newX,newY) && grid[newX][newY] == '1' && !marked[newX][newY])
 *                 dfs(newX,newY);
 *         }
 *     }
 *     boolean inArea(int x,int y) {
 *         return x >= 0 && x < rows && y >= 0 && y < cols;
 *     }
 * }
 *
 */
/**
 * class Solution {
 *     private int rows;
 *     private int cols;
 *     public int numIslands(char[][] grid) {
 *         int[] dx = {-1,0,1,0};
 *         int[] dy = {0,-1,0,1};
 *         rows = grid.length;
 *         if (rows == 0) return 0;
 *         cols = grid[0].length;
 *         boolean[][] marked = new boolean[rows][cols];
 *         int count = 0;
 *         for (int i = 0; i < rows; i++) {
 *             for (int j = 0; j < cols; j++) {
 *                 if (!marked[i][j] && grid[i][j] == '1') {
 *                     count++;
 *                     LinkedList<Integer> queue = new LinkedList<>();
 *                     queue.addLast(i * cols + j);
 *                     marked[i][j] = true;
 *                     while (!queue.isEmpty()) {
 *                         int cur = queue.removeLast();
 *                         int curX = cur / cols;
 *                         int curY = cur % cols;
 *                         for (int k = 0; k < 4; k++) {
 *                             int newX = curX + dx[k];
 *                             int newY = curY + dy[k];
 *                             if (inArea(newX,newY) && grid[newX][newY] == '1' && !marked[newX][newY]) {
 *                                 queue.addLast(newX * cols + newY);
 *                                 marked[newX][newY] = true;
 *                             }
 *                         }
 *                     }
 *                 }
 *             }
 *         }
 *         return count;
 *     }
 *     boolean inArea(int x, int y) {
 *         return x >= 0 && x < rows && y >= 0 && y < cols;
 *     }
 * }
 */
