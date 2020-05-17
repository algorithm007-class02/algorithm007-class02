package week08.g20200343040172;

public class LeetCode_52_0172 {
  class Solution1 {
    private int size;
    private int count;

    private void solve(int row, int na, int pie) {
      if (row == size) {
        count++;
        return;
      }
      int pos = size & (~(row | na | pie));
      while (pos != 0) {
        int p = pos & (-pos);
        pos -= p; // 表示在当前位置放上皇后
        solve(row | p, (na | p) << 1, (pie | p) >> 1);
      }
    }

    public int totalNQueens(int n) {
      count = 0;
      size = (1 << n) - 1;
      solve(0, 0, 0);
      return count;
    }
  }
}
