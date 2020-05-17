class Solution {

    /**
     * DFS
     * @param board
     */
    public void solve(char[][] board) {
        if (board.length == 0 || board[0].length == 0) return;
        if (board.length < 3 || board[0].length < 3) return;
        int m = board.length;
        int n = board[0].length;
        for (int i = 0; i < m; i++) {
            if (board[i][0] == 'O') helper(board, i, 0);
            if (board[i][n - 1] == 'O') helper(board, i, n - 1);
        }
        for (int j = 1; j < n - 1; j++) {
            if (board[0][j] == 'O') helper(board, 0, j);
            if (board[m - 1][j] == 'O') helper(board, m - 1, j);
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 'O') board[i][j] = 'X';
                if (board[i][j] == '*') board[i][j] = 'O';
            }
        }
    }

    private void helper(char[][] board, int r, int c) {
        if (r < 0 || c < 0 || r > board.length - 1 || c > board[0].length - 1 || board[r][c] != 'O') return;
        board[r][c] = '*';
        helper(board, r + 1, c);
        helper(board, r - 1, c);
        helper(board, r, c + 1);
        helper(board, r, c - 1);
    }

    /**
     * BFS
     * @param board
     */
    public void solve_1(char[][] board) {
        if (board.length == 0) return;

        int rowN = board.length;
        int colN = board[0].length;
        Queue<Point> queue = new LinkedList<Point>();

        //get all 'O's on the edge first
        for (int r = 0; r< rowN; r++){
            if (board[r][0] == 'O') {
                board[r][0] = '+';
                queue.add(new Point(r, 0));
            }
            if (board[r][colN-1] == 'O') {
                board[r][colN-1] = '+';
                queue.add(new Point(r, colN-1));
            }
        }

        for (int c = 0; c< colN; c++){
            if (board[0][c] == 'O') {
                board[0][c] = '+';
                queue.add(new Point(0, c));
            }
            if (board[rowN-1][c] == 'O') {
                board[rowN-1][c] = '+';
                queue.add(new Point(rowN-1, c));
            }
        }


        //BFS for the 'O's, and mark it as '+'
        while (!queue.isEmpty()){
            Point p = queue.poll();
            int row = p.x;
            int col = p.y;
            if (row - 1 >= 0 && board[row-1][col] == 'O') {board[row-1][col] = '+'; queue.add(new Point(row-1, col));}
            if (row + 1 < rowN && board[row+1][col] == 'O') {board[row+1][col] = '+'; queue.add(new Point(row+1, col));}
            if (col - 1 >= 0 && board[row][col - 1] == 'O') {board[row][col-1] = '+'; queue.add(new Point(row, col-1));}
            if (col + 1 < colN && board[row][col + 1] == 'O') {board[row][col+1] = '+'; queue.add(new Point(row, col+1));}
        }


        //turn all '+' to 'O', and 'O' to 'X'
        for (int i = 0; i<rowN; i++){
            for (int j=0; j<colN; j++){
                if (board[i][j] == 'O') board[i][j] = 'X';
                if (board[i][j] == '+') board[i][j] = 'O';
            }
        }


    }

    public class Point {
        /**
         * The X coordinate of this <code>Point</code>.
         * If no X coordinate is set it will default to 0.
         *
         * @serial
         * @see #move(int, int)
         * @since 1.0
         */
        public int x;

        /**
         * The Y coordinate of this <code>Point</code>.
         * If no Y coordinate is set it will default to 0.
         *
         * @serial
         * @see #move(int, int)
         * @since 1.0
         */
        public int y;

        /*
         * JDK 1.1 serialVersionUID
         */
        private static final long serialVersionUID = -5276940640259749850L;

        /**
         * Constructs and initializes a point at the origin
         * (0,&nbsp;0) of the coordinate space.
         * @since       1.1
         */
        public Point() {
            this(0, 0);
        }

        /**
         * Constructs and initializes a point with the same location as
         * the specified <code>Point</code> object.
         * @param       p a point
         * @since       1.1
         */
        public Point(java.awt.Point p) {
            this(p.x, p.y);
        }

        /**
         * Constructs and initializes a point at the specified
         * {@code (x,y)} location in the coordinate space.
         * @param x the X coordinate of the newly constructed <code>Point</code>
         * @param y the Y coordinate of the newly constructed <code>Point</code>
         * @since 1.0
         */
        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        /**
         * {@inheritDoc}
         * @since 1.2
         */
        public double getX() {
            return x;
        }

        /**
         * {@inheritDoc}
         * @since 1.2
         */
        public double getY() {
            return y;
        }

        /**
         * Moves this point to the specified location in the
         * {@code (x,y)} coordinate plane. This method
         * is identical with <code>setLocation(int,&nbsp;int)</code>.
         * @param       x the X coordinate of the new location
         * @param       y the Y coordinate of the new location
         * @see         java.awt.Component#setLocation(int, int)
         */
        public void move(int x, int y) {
            this.x = x;
            this.y = y;
        }

        /**
         * Translates this point, at location {@code (x,y)},
         * by {@code dx} along the {@code x} axis and {@code dy}
         * along the {@code y} axis so that it now represents the point
         * {@code (x+dx,y+dy)}.
         *
         * @param       dx   the distance to move this point
         *                            along the X axis
         * @param       dy    the distance to move this point
         *                            along the Y axis
         */
        public void translate(int dx, int dy) {
            this.x += dx;
            this.y += dy;
        }
    }


}