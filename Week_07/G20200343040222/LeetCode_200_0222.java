public class LeetCOde_200_0222 {

    private static int[][] direct = new int[][]{{0, 1}, {0, -1}, {-1, 0}, {1, 0}};

    /**
     * dfs 时间复杂度为O(N) N为结点总数 空间复杂度为O(N)
     * @param grid
     * @return
     */
    public int numIslands(char[][] grid) {
        int row = grid.length;
        if (row == 0) return 0;
        int col = grid[0].length;
        if (col == 0) return 0;
        boolean[][] visited = new boolean[row][col];
        int count = 0;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (!visited[i][j] && grid[i][j] == '1') {
                    dfs(visited, grid, i , j);
                    count++;
                }
            }
        }
        return count;
    }

    private void dfs(boolean[][] visited, char[][] grid, int x, int y) {
        if (x < 0 || x >= grid.length || y < 0 || y >= grid[0].length || visited[x][y] || grid[x][y] == '0') {
            return;
        }
        visited[x][y] = true;
        for (int i = 0 ; i < 4; i++) {
            dfs(visited, grid, x + direct[i][0], y + direct[i][1]);
        }
    }

    /**
     * bfs 时间复杂度为 O(N) 空间复杂度为O(N)
     * @param grid
     * @return
     */
    public int numIslandsRe(char[][] grid) {
        int row = grid.length;
        if (row == 0) return 0;
        int col = grid[0].length;
        if (col == 0) return 0;
        boolean[][] visited = new boolean[row][col];
        int count = 0;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (!visited[i][j] && grid[i][j] == '1') {
                    visited[i][j] = true;
                    count++;
                    LinkedList<Integer> queue = new LinkedList<Integer>();
                    queue.add(i * col + j);
                    while (!queue.isEmpty()) {
                        int current = queue.removeFirst();
                        int curX = current / col;
                        int curY = current % col;
                        for (int k = 0; k < 4; k++) {
                            int newX = curX + direct[k][0];
                            int newY = curY + direct[k][1];
                            if (newX >= 0 && newX < row && newY >= 0 && newY < col && !visited[newX][newY] && grid[newX][newY] == '1') {
                                queue.addLast(newX * col + newY);
                                visited[newX][newY] = true;
                            }
                        }
                    }

                }
            }
        }

        return count;
    }


    /**
     * 并查集 时间复杂度为O(N* M * (N + M)) 空间复杂度为(N * M) N为行 M为列
     * @param grid
     * @return
     */
    public int numIslands(char[][] grid) {
        int row = grid.length;
        if (row == 0) return 0;
        int col = grid[0].length;
        if (col == 0) return 0;
        boolean[][] visited = new boolean[row][col];
        int[] parent = new int[row * col];
        Arrays.fill(parent, -1);
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (grid[i][j] == '1') {
                    if (i < (row - 1) && grid[i + 1][j] == '1') {
                        union(parent, i * col + j, (i + 1) * col + j);
                    }

                    if (j < (col - 1) && grid[i][j + 1] == '1') {
                        union(parent, i * col + j, i * col + j + 1);
                    }
                } else {
                    parent[i * col + j] = -2;
                }
            }
        }
        int count = 0;
        for (int i = 0; i < parent.length; i++) {
            if (parent[i] == -1) count++;
        }
        return count;
    }

    private void union(int[] parent, int p, int q) {
        int rootP = find(parent, p);
        int rootQ = find(parent, q);
        if (rootP != rootQ) {
            parent[rootP] = rootQ;
        }

    }

    private int find(int[] parent, int index) {
        if (parent[index] == -1) return index;
        return find(parent, parent[index]);
    }

}