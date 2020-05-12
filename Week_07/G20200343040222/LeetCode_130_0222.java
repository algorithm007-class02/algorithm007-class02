public class Leet_code_130_0222 {

    /**
     * 并查集 时间复杂度 O(M * N *(M + N)) 空间复杂度 O(N * M)
     * @param board
     */
    public void solve(char[][] board) {
        int row = board.length;
        if (row == 0) return;
        int col = board[0].length;
        UnionFind unionFind = new UnionFind(row * col + 1);
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (board[i][j] == 'O') {
                    if (i == 0|| i == row - 1 || j == 0 || j == col - 1) {
                        unionFind.union(node(i, j, col), row * col);
                    } else {
                        if (i > 0 && board[i - 1][j] == 'O') {
                            unionFind.union(node(i, j, col), node(i - 1, j, col));
                        }
                        if (i < row - 1 && board[i + 1][j] == 'O') {
                            unionFind.union(node(i, j, col), node(i + 1, j, col));
                        }
                        if (j > 0 && board[i][j - 1] == 'O') {
                            unionFind.union(node(i, j, col), node(i, j - 1, col));
                        }
                        if (j < col - 1 && board[i][j + 1] == 'O') {
                            unionFind.union(node(i, j, col), node(i, j + 1, col));
                        }
                    }
                }
            }

        }

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (unionFind.isContected(node(i, j, col), row * col)) {
                    board[i][j] = 'O';
                } else {
                    board[i][j] = 'X';
                }
            }
        }

    }
    int node(int i , int j, int col) {
        return i * col + j;

    }

    class UnionFind {
        int[] parent;

        public UnionFind(int n) {
            parent = new int[n];
            for (int i = 0; i < n; i++) {
                parent[i] = i;
            }
        }

        void union(int node1, int node2) {
            int root1 = find(node1);
            int root2 = find(node2);
            if (root1 != root2) {
                parent[root1] = root2;
            }
        }

        int find(int node) {
            while (parent[node] != node) {
                parent[node] = parent[parent[node]];
                node = parent[node];
            }
            return node;
        }
        boolean isContected(int node1, int node2) {
            return find(node1) == find(node2);
        }

        void unionRe(int node1 , int node2) {
            int root1 = findParent(node1);
            int root2 = findParent(node2);
            parent[root1] = root2;
        }

        int findParent(int node) {
            return parent[node] == node ? node : parent[node];
        }

        int findRe(int node) {
            while (parent[node] != node) {
                node = parent[node];
            }
            return node;
        }

    }
}