/*
 * @lc app=leetcode.cn id=771 lang=cpp
 *
 * [771] 宝石与石头
 */

// @lc code=start
class Solution {
public:
    int numJewelsInStones(string J, string S) {
        int amount[52] = {0};
        int res = 0;
        for (int i = 0; i < S.size(); ++i) {
            if (S[i] >= 'a')
                amount[S[i] - 'a']++;
            else
                amount[S[i] - 'A' + 26]++;
        }
        for (int j = 0; j < J.size(); ++j) {
            if (J[j] >= 'a')
                res += amount[J[j] - 'a'];
            else
                res += amount[J[j] - 'A' + 26];
        }
        return res;
    }
};
// @lc code=end
