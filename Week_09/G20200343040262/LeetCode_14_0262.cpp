/*
 * @lc app=leetcode.cn id=14 lang=cpp
 *
 * [14] 最长公共前缀
 */

// @lc code=start
class Solution {
public:
    string longestCommonPrefix(vector<string> &strs) {
        int n = strs.size();
        if (n == 0)
            return "";
        if (n == 1)
            return strs[0];
        sort(strs.begin(), strs.end());
        for (int i = 0; i < min(strs[0].length(), strs[n - 1].length()); ++i) {
            if (strs[0][i] != strs[n - 1][i])
                return strs[0].substr(0, i);
        }
        return strs[0].length() > strs[n - 1].length() ? strs[n - 1] : strs[0];
    }
};
// @lc code=end
