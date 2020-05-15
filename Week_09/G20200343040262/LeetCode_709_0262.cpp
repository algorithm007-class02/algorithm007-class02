/*
 * @lc app=leetcode.cn id=709 lang=cpp
 *
 * [709] 转换成小写字母
 */

// @lc code=start
class Solution {
public:
    string toLowerCase(string str) {
        for (auto &i : str)
            i |= 32;
        return str;
    }
};
// @lc code=end
