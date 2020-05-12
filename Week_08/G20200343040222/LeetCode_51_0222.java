public class LeetCode_51_0222 {

    private boolean[] col;
    private boolean[] master;
    private boolean[] slave;
    private int n;
    private List<List<String>> res;
    /**
     *     经典回溯
     */

    public List<List<String>> solveNQueens(int n) {
        this.n = n;
        res = new ArrayList<>();
        if (n == 0) return res;
        col = new boolean[n];
        master = new boolean[2 * n - 1];
        slave = new boolean[2 * n - 1];
        Stack<Integer> stack = new Stack<>();
        backtrack(0, stack);
        return res;
    }

    private void backtrack(int row, Stack<Integer> stack) {
        if (row == n) {
            List<String> board = convertToBoard(stack, n);
            res.add(board);
            return;
        }
        for (int i = 0; i < n; i++) {
            if (!col[i] && !master[row + i] && !slave[row - i + n - 1]) {
                stack.add(i);
                col[i] = true;
                master[row + i] = true;
                slave[row - i + n - 1] = true;
                backtrack(row + 1, stack);
                col[i] = false;
                master[row + i] = false;
                slave[row - i + n - 1] = false;
                stack.pop();
            }
        }

    }


    private List<String> convertToBoard(Stack<Integer> stack, int n) {
        List<String> board = new ArrayList<>();
        for (Integer num : stack) {
            StringBuilder stringBuilder = new StringBuilder();
            for (int i = 0; i < n; i++) {
                stringBuilder.append(".");
            }
            stringBuilder.replace(num, num + 1, "Q");
            board.add(stringBuilder.toString());
        }
        return board;
    }

    /**
     * 位运算
     * @param stack
     * @param n
     * @return
     */
    public List<List<String>> solveNQueensRe(int n) {
        this.n = n;
        res = new ArrayList<>();
        if (n == 0) return res;
        int colRe = 0;
        int masterRe = 0;
        int slaveRe = 0;
        Stack<Integer> stack = new Stack<>();
        backtrackRe(0, colRe, masterRe, slaveRe, stack);

    }
    private void backtrackRe(int row, int colRe, int masterRe, int slaveRe, Stack<Integer> stack) {
        if (row == n) {
            List<String> board = convertToBoard(stack, n);
            res.add(board);
            return;
        }
        for (int i = 0; i < n; i++) {
            if (((colRe >> i) & 1) == 0 && (masterRe >> (row + i) & 1) == 0 && (slaveRe >> (row - i + n - 1) & 1) == 0) {
                stack.add(i);
                colRe ^= (1 << i);
                masterRe ^= (1 << (row + i));
                slaveRe ^= (1 << (row - i + n - 1));
                backtrackRe(row + 1, colRe, masterRe, slaveRe, stack);
                colRe ^= (1 << i);
                masterRe ^= (1 << (row + i));
                slaveRe ^= (1 << (row - i + n - 1));
                stack.pop();
            }
        }
    }



}