/*
 * @lc app=leetcode.cn id=36 lang=cpp
 *
 * [36] 有效的数独
 */

// @lc code=start
class Solution {
public:
    bool isValidSudoku(vector<vector<char>> &board) {
        //开三个数组，标记行 列 斜边，某数是否已经被摆放
        bool row[9][9] = {false};
        bool col[9][9] = {false};
        bool block[9][9] = {false};
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] != '.') {
                    int blockIndex = i / 3 * 3 + j / 3;
                    int num = board[i][j] - '1';
                    if (row[i][num] || col[j][num] || block[blockIndex][num]) {
                        return false;
                    } else {
                        row[i][num] = true;
                        col[j][num] = true;
                        block[blockIndex][num] = true;
                    }
                }
            }
        }
        return true;
    }
};
// @lc code=end
