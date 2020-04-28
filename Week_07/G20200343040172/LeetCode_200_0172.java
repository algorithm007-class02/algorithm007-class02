package week07.g20200343040172;
/**
 * LeetCode_200_岛屿数量
 * https://leetcode-cn.com/problems/number-of-islands/
 */
public class LeetCode_200_0172 {

    /**
     * 使用并查集
     */
    class Solution1 {

        class UnionFind {
            int count;
            int[] parent;
            int[] rank;

            public UnionFind(char[][] grid) {
                count = 0;
                int m = grid.length;
                int n = grid[0].length;
                parent = new int[m * n];
                rank = new int[m * n];
                for (int i = 0; i < m; ++i) {
                    for (int j = 0; j < n; ++j) {
                        if (grid[i][j] == '1') {
                            // 构建一维的parent
                            parent[i * n + j] = i * n + j;
                            ++count;
                        }
                        rank[i * n + j] = 0;
                    }
                }
            }

            public int find(int i) {
                if (parent[i] != i) {
                    parent[i] = find(parent[i]);
                }
                return parent[i];
            }

            public void union(int x, int y) {
                int rootx = find(x);
                int rooty = find(y);
                if (rootx != rooty) {
                    // rank的数组是做什么的？
                    // 当x的树的深度大于y的树的深度，就把x接在y上，不让数的深度过于深
                    if (rank[rootx] > rank[rooty]) {
                        parent[rooty] = rootx;
                    } else if (rank[rootx] < rank[rooty]) {
                        parent[rootx] = rooty;
                    } else {
                        parent[rooty] = rootx;
                        rank[rootx] += 1;
                    }
                    --count;
                }
            }

            public int getCount() {
                return count;
            }
        }

        public int numIslands(char[][] grid) {
            if (grid == null || grid.length == 0) {
                return 0;
            }

            int nr = grid.length;
            int nc = grid[0].length;
            UnionFind uf = new UnionFind(grid);
            for (int r = 0; r < nr; ++r) {
                for (int c = 0; c < nc; ++c) {
                    if (grid[r][c] == '1') {
                        grid[r][c] = '0';
                        // 往上下左右四个方向进行合并
                        if (r - 1 >= 0 && grid[r - 1][c] == '1') {
                            uf.union(r * nc + c, (r - 1) * nc + c);
                        }
                        if (r + 1 < nr && grid[r + 1][c] == '1') {
                            uf.union(r * nc + c, (r + 1) * nc + c);
                        }
                        if (c - 1 >= 0 && grid[r][c - 1] == '1') {
                            uf.union(r * nc + c, r * nc + c - 1);
                        }
                        if (c + 1 < nc && grid[r][c + 1] == '1') {
                            uf.union(r * nc + c, r * nc + c + 1);
                        }
                    }
                }
            }

            return uf.getCount();
        }
    }

    /*****************************************************/

    /**
     * 使用DFS的解法
     */
    class Solution2 {
        public int numIslands(char[][] grid) {
            if (grid == null || grid.length == 0 || grid[0].length == 0) {
                return 0;
            }
            int m = grid.length;
            int n = grid[0].length;
            int[][] visited = new int[m][n];
            int count = 0;
            for (int i = 0; i < m; ++i) {
                for (int j = 0; j < n; ++j) {
                    if (visited[i][j] == 0 && grid[i][j] == '1') {
                        count++;
                        dfs(grid, visited, i, j);
                    }
                }
            }
            return count;
        }

        public void dfs(char[][] grid, int[][] visited, int i, int j) {
            if (i < 0 || j < 0 || i >= grid.length || j >= grid[0].length) {
                return;
            }
            visited[i][j] = 1;
            if (grid[i][j] == '0') {
                return;
            }
            if (i + 1 < grid.length && visited[i + 1][j] == 0) {
                dfs(grid, visited, i + 1, j);
            }
            if (i - 1 >= 0 && visited[i - 1][j] == 0) {
                dfs(grid, visited, i - 1, j);
            }
            if (j + 1 < grid[0].length && visited[i][j + 1] == 0) {
                dfs(grid, visited, i, j + 1);
            }
            if (j - 1 >= 0 && visited[i][j - 1] == 0) {
                dfs(grid, visited, i, j - 1);
            }
        }
    }
}
