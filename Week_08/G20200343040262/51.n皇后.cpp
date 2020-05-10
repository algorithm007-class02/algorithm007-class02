/*
 * @lc app=leetcode.cn id=51 lang=cpp
 *
 * [51] N皇后
 */

// @lc code=start
class Solution {
public:
    //根据qPos(皇后的位置)的值，构造输出的字符串
    void make_ret(int n, const vector<int> &qPos, vector<vector<string>> &ret) {
        vector<string> temp(n, string(n, '.'));
        for (int c = 0; c < n; c++)
            temp[qPos[c]][c] = 'Q';
        ret.push_back(temp);
    }

    void backtrack(int r, int n, int col, int hill, int dale, vector<int> &qPos, vector<vector<string>> &ret) {
        if (r >= n)
            make_ret(n, qPos, ret);
        else
            for (int c = 0; c < n; c++)
                //检查col,hill,dale特定位上的值
                //如(1&col>>c)==0，就是检查col第c个比特位是否==0
                // r表示行下标，c表示列下标，r+c与r-c值均为常数，注意：r-c有可能小于0，所以要+n
                if ((1 & col >> c) == 0 && (1 & hill >> r + c) == 0 && (1 & dale >> r - c + n) == 0) {
                    qPos[c] = r;
                    //将col,hill,dale特定位的0置为1
                    //如col|1<<c，就是将col第c个比特位的0变为1
                    backtrack(r + 1, n, col | 1 << c, hill | 1 << r + c, dale | 1 << r - c + n, qPos, ret);
                    qPos[c] = 0;
                }
    }

    vector<vector<string>> solveNQueens(int n) {
        vector<vector<string>> ret;
        vector<int> qPos(n);
        backtrack(0, n, 0, 0, 0, qPos, ret);
        return ret;
    }
};
// @lc code=end
