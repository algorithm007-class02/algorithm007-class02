/*
 * @lc app=leetcode.cn id=52 lang=cpp
 *
 * [52] N皇后 II
 */

// @lc code=start
class Solution {
public:
    int count = 0;
    int totalNQueens(int n) {
        backtrack(n, 0, 0, 0, 0);
        return count;
    }
    void backtrack(int n, int r, int row, int ld, int rd) {
        if (r == n) {
            count++;
            return;
        }
        // 当前层能放皇后的所有位置
        int pos = ~(row | ld | rd) & ((1 << n) - 1);
        while (pos) {// 如果pos=0,表示没有位置可放了
            int pick = (pos & -pos);
            backtrack(n, r + 1, (row | pick), (ld | pick) << 1, (rd | pick) >> 1);
            pos &= (pos - 1);
        }
        return;
    }
};
// @lc code=end

