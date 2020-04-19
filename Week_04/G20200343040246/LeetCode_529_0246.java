package Week_04.G20200343040246;

class LeetCode_529_0246 {

    public static void main(String[] args) {
        char[][] board = new char[][]{
            {'E', 'E', 'E', 'E', 'E'},
            {'E', 'E', 'M', 'E', 'E'},
            {'E', 'E', 'E', 'E', 'E'},
            {'E', 'E', 'E', 'E', 'E'},
        };
        int[] click = new int[]{3,0};
        char[][] res = new LeetCode_529_0246().updateBoard(board, click);
        for(char[] row : res) {
            for (char col : row) {
                System.out.print(col + " ");
            }
            System.out.println();
        }
    }

    int[] dx = {-1, -1, 0, 1, 1, 1, 0, -1}; // 相邻位置坐标变换
    int[] dy = {0, 1, 1, 1, 0, -1, -1, -1};

    public char[][] updateBoard(char[][] board, int[] click) {
        dfs(board, click[0], click[1]);
        return board;
    }

    public void dfs(char[][] board, int x, int y) {
        int row = board.length;
        int col = board[0].length;

        // terminator
        if (x < 0 || y < 0 || x >= row || y >= col) {
            return;
        }

        if (board[x][y] == 'E') {
            board[x][y] = 'B';
            int count = judge(board, x, y);
            if (count == 0) { // 如果为0，则进行递归
                for (int i = 0; i < 8; i++) {
                    dfs(board, x + dx[i], y + dy[i]);
                }
            } else { // 如果不为0，则更新当前结点的值为地雷数量
                board[x][y] = (char) (count + '0');
            }
        } else if (board[x][y] == 'M') {
            board[x][y] = 'X';
        }
    }

    public int judge(char[][] board, int x, int y) {
        int row = board.length;
        int col = board[0].length;
        int count = 0;
        for (int i = 0; i < 8; i++) {
            int newX = x + dx[i];
            int newY = y + dy[i];
            if (newX < 0 || newX >= row || newY < 0 || newY >= col) {
                continue;
            }
            if (board[newX][newY] == 'M') {
                count++;
            }
        }
        return count;
    }
}