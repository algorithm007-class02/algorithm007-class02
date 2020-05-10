class Solution {
    private int count;
    private int n;
    
    public int totalNQueens(int n) {
        count = 0;
        this.n = n;
        recursion(0, 0, 0, 0);
        return count;
    }
    
    private void recursion(int row, int col, int pie, int na) {
        if (row >= n) {
            count++;
            return;
        }
        int bits = (~(col | pie | na)) & ((1 << n) - 1);
        while (bits != 0) {
            int p = bits & (-bits);
            bits = bits & (bits - 1);
            recursion(row + 1, col | p, (pie | p) << 1, (na | p) >> 1);
        }
    }
}
