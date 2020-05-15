/*
 * @lc app=leetcode.cn id=541 lang=cpp
 *
 * [541] 反转字符串 II
 */

// @lc code=start
class Solution {
public:
    string reverseStr(string s, int k) {
        int n = s.size();
        if (k == 0 || n < 2)
            return s;
        for (int start = 0; start < n; start += 2 * k) {
            int i = start, j = min(start + k - 1, n - 1);
            while (i < j) {
                char tmp = s[i];
                s[i++] = s[j];
                s[j--] = tmp;
            }
        }
        return s;
    }
};
// @lc code=end
