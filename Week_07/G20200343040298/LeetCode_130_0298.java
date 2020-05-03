/*
*并查集解法
*/

class Solution {
    int[][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    private static class Point {
        int x, y;

        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public void solve(char[][] board) {
        if (board == null || board.length == 0 || board[0] == null || board[0].length == 0) return;
        int row = board.length;
        int col = board[0].length;
        for (int j = 0; j < col; j++) {
            // 第一行
            if (board[0][j] == 'O') bfs(0, j, board, row, col);
            // 最后一行
            if (board[row - 1][j] == 'O') bfs(row - 1, j, board, row, col);
        }

        for (int i = 0; i < row; i++) {
            // 第一列
            if (board[i][0] == 'O') bfs(i, 0, board, row, col);
            // 最后一列
            if (board[i][col - 1] == 'O') bfs(i, col - 1, board, row, col);
        }

        // 转变
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (board[i][j] == 'O') board[i][j] = 'X';
                if (board[i][j] == 'B') board[i][j] = 'O';
            }
        }

    }

    private void bfs(int i, int j, char[][] board, int row, int col) {
        Deque<Point> queue = new LinkedList<>();
        queue.offer(new Point(i, j));
        while (!queue.isEmpty()) {
            Point tmp = queue.poll();
            if (tmp.x >= 0 && tmp.x < row && tmp.y >= 0 && tmp.y < col && board[tmp.x][tmp.y] == 'O') {
                board[tmp.x][tmp.y] = 'B';
                for (int[] dir : dirs) queue.offer(new Point(tmp.x + dir[0], tmp.y + dir[1]));
            }
        }
    }
}