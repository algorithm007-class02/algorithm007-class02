class Solution {
    public char[][] updateBoard(char[][] board, int[] click) {
        int m = board.length, n = board[0].length;
        int[][] dir = new int[][] {{-1,0},{1,0},{0,-1},{0,1},{-1,-1},{1,1},{-1,1},{1,-1}};
        Queue<int[]> q = new LinkedList<>();
        q.add(click);
        if (board[click[0]][click[1]] == 'M') {
            board[click[0]][click[1]] = 'X';
            return board;
        }
        while (!q.isEmpty()) {
            int[] curr = q.poll();
            int row = curr[0], col = curr[1], count = 0;
            for (int[] d : dir) {
                int r = row + d[0], c = col + d[1];
                if (r >= m || c >= n || r < 0 || c < 0) {
                    continue;
                }
                if (board[r][c] == 'M') {
                    count++;
                }
            }
            if (count > 0) {
                board[row][col] = (char)(count + '0');
            } else {
                board[row][col] = 'B';
                for (int[] d : dir) {
                    int r = row + d[0], c = col + d[1];
                    if (r >= m || c >= n || r < 0 || c < 0) {
                        continue;
                    }
                    if (board[r][c] == 'E') {
                        q.add(new int[] {r, c});
                        board[r][c] = 'B';
                    }
                }
            }
        }
        return board;
    }
}