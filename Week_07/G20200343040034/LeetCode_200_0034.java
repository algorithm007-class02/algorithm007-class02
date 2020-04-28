package com.alang.learn.week7;

/***
 给定一个由 '1'（陆地）和 '0'（水）组成的的二维网格，计算岛屿的数量。一个岛被水包围，并且它是通过水平方向或垂直方向上相邻的陆地连接而成的。你可以假设网格的四个边均被水包围。

 示例 1:

 输入:
 11110
 11010
 11000
 00000

 输出: 1
 示例 2:

 输入:
 11000
 11000
 00100
 00011

 输出: 3

 来源：力扣（LeetCode）
 链接：https://leetcode-cn.com/problems/number-of-islands
 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LeetCode_200_0034 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        char[][] grid = {{'1', '1', '1', '1', '0'},
                {'1', '1', '0', '1', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '0', '0', '0'}};
        System.out.println(solution.numIslands(grid));
        System.out.println(solution.numIslands1(grid));

        grid = new char[][]{{'1', '1', '0', '0', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '1', '0', '0'},
                {'0', '0', '0', '1', '1'}};
        System.out.println(solution.numIslands(grid));
        System.out.println(solution.numIslands1(grid));
    }

    static class Solution {

        public int numIslands(char[][] grid) {
            if (grid == null || grid.length == 0) return 0;
            int row = grid.length;
            if (grid[0] == null || grid[0].length == 0) return 0;
            int col = grid[0].length;
            int[][] directions = {{1, 0}, {0, 1}};
            UnionFound unionFound = new UnionFound(row * col + 1);
            for (int i = 0; i < row; i++) {
                for (int j = 0; j < col; j++) {
                    if (grid[i][j] == '1') {
                        for (int[] dir : directions) {
                            int newX = i + dir[0];
                            int newY = j + dir[1];
                            if (newX < row && newY < col && grid[newX][newY] == '1')
                                unionFound.unionSet(col * i + j, col * newX + newY);
                        }
                    } else {
                        unionFound.unionSet(col * i + j, row * col);
                    }
                }
            }
            return unionFound.count - 1;
        }

        public int numIslands1(char[][] grid) {
            if (grid == null || grid.length == 0) return 0;
            int row = grid.length;
            if (grid[0] == null || grid[0].length == 0) return 0;
            int col = grid[0].length;
            int numIslands = 0;
            for (int i = 0; i < row; i++) {
                for (int j = 0; j < col; j++) {
                    if (grid[i][j] == '1') {
                        numIslands++;
                        dfs(grid, i, j);
                    }
                }
            }
            return numIslands;
        }

        private void dfs(char[][] grid, int r, int c) {
            int row = grid.length;
            int col = grid[0].length;
            if (r >= row || c >= col || r < 0 || c < 0 || grid[r][c] == '0') return;
            grid[r][c] = '0';
            dfs(grid, r, c + 1);
            dfs(grid, r, c - 1);
            dfs(grid, r - 1, c);
            dfs(grid, r + 1, c);
        }


        class UnionFound {
            int count;
            int[] parent;

            UnionFound(int count) {
                this.count = count;
                this.parent = new int[count];
                for (int i = 0; i < count; i++) parent[i] = i;
            }

            public int parent(int i) {
                int root = i;
                while (parent[root] != root)
                    root = parent[root];

                while (parent[i] != i) {
                    int temp = i;
                    parent[i] = root;
                    i = parent[temp];
                }
                return root;
            }

            public void unionSet(int x, int y) {
                int xP = parent(x);
                int yP = parent(y);
                if (xP == yP) return;
                parent[xP] = yP;
                count--;
            }
        }

    }
}
