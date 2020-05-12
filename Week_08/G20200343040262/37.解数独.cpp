/*
 * @lc app=leetcode.cn id=37 lang=cpp
 *
 * [37] 解数独
 */

// @lc code=start
// 回溯+状态压缩(使用bitset)
class Solution {
private:
    vector<bitset<9>> rows;
    vector<bitset<9>> cols;
    vector<vector<bitset<9>>> cells;

public:
    void solveSudoku(vector<vector<char>> &board) {
        //三个bitset数组用来存储，行 列 块是否出现1-9
        rows = vector<bitset<9>>(9, bitset<9>());
        cols = vector<bitset<9>>(9, bitset<9>());
        cells = vector<vector<bitset<9>>>(3, vector<bitset<9>>(3, bitset<9>()));
        //记录未填的空格数
        int empty_cnt = 0;
        //初始状态的数独
        for (int i = 0; i < board.size(); i++) {
            for (int j = 0; j < board[i].size(); j++) {
                empty_cnt += (board[i][j] == '.');
                if (board[i][j] == '.')
                    continue;
                int n = board[i][j] - '1';
                rows[i] |= (1 << n);
                cols[j] |= (1 << n);
                cells[i / 3][j / 3] |= (1 << n);
            }
        }
        //
        dfs(board, empty_cnt);
    }

    //获取 行列块 约束下,(x, y)点可选用的数字的状态，0 - 不可选， 1 - 可选
    bitset<9> getPossibleStatus(int x, int y) { return ~(rows[x] | cols[y] | cells[x / 3][y / 3]); }

    //获取 可选用数字最少的(x, y)点
    vector<int> getNext(vector<vector<char>> &board) {
        vector<int> res;
        int minCnt = 10;
        for (int i = 0; i < board.size(); i++) {
            for (int j = 0; j < board[i].size(); j++) {
                if (board[i][j] != '.') {
                    continue;
                }
                auto cur = getPossibleStatus(i, j);
                // count 函数返回bitset中1的个数
                if (cur.count() >= minCnt) {
                    continue;
                }
                res = {i, j};
                minCnt = cur.count();
            }
        }
        return res;
    }

    //填数时，更新 可选用数字的状态
    //优化：选择能填的数字最少的格子开始填，这样填错的概率最小，回溯次数也会变少
    void fillNum(int x, int y, int n, bool fillFlag) {
        rows[x][n] = (fillFlag) ? 1 : 0;
        cols[y][n] = (fillFlag) ? 1 : 0;
        cells[x / 3][y / 3][n] = (fillFlag) ? 1 : 0;
    }

    bool dfs(vector<vector<char>> &board, int empty_cnt) {
        // terminator
        if (empty_cnt == 0) {
            return true;
        }
        // process the current level
        auto next = getNext(board);
        auto bits = getPossibleStatus(next[0], next[1]);
        for (int n = 0; n < bits.size(); n++) {
            // 跳过 不可选的数字
            // test 函数检查下标处元素为0还是1,0 - false, 1 - true
            if (!bits.test(n)) {
                continue;
            }
            fillNum(next[0], next[1], n, true);
            //填充数独
            board[next[0]][next[1]] = n + '1';
            if (dfs(board, empty_cnt - 1)) {
                return true;
            } else {
                //回溯，清理当前所做的修改
                board[next[0]][next[1]] = '.';
                fillNum(next[0], next[1], n, false);
            }
        }
        return false;
    }
};
// @lc code=end
