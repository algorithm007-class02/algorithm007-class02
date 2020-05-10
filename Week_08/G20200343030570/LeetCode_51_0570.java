class Solution {
    private List<List<String>> result = new ArrayList();
    
    public List<List<String>> solveNQueens(int n) {
        if (n < 1) return result;
        recursion(n, 0, 0, 0, 0, new ArrayList<Integer>());
        return result;
    }
    
    private void recursion(int n, int row, int cols, int pie, int na, List<Integer> currCol) {
        // terminator
        if (row == n) {
            result.add(generateBoard(n, currCol));
            return;
        }
        
        // process current logic
        int bits = (~(cols | pie | na)) & ((1 << n) - 1);
        while (bits != 0) {
            int p = bits & -bits;
            bits = bits & (bits - 1);
            currCol.add((int)(Math.log(p) / Math.log(2)));
            // drill down
            recursion(n, row + 1, cols | p, (pie | p) << 1, (na | p) >> 1, currCol);
            // revert state
            currCol.remove(currCol.size() - 1);
        }
    }
    
    private List<String> generateBoard(int n, List<Integer> cols) {
        List<String> board = new ArrayList();    
        for (Integer num : cols) {
            StringBuilder s = new StringBuilder();
            for (int i = 0; i < n; i++) {
                s.append(".");
            }
            s.replace(num, num + 1, "Q");
            board.add(s.toString());
        }
        return board;
    }
}
