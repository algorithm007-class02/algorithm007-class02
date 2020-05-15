/*
 * @lc app=leetcode.cn id=10 lang=cpp
 *
 * [10] 正则表达式匹配
 */

// @lc code=start
// 调库了哈哈哈
class Solution {
public:
    bool isMatch(string s, string p) { return regex_match(s, regex(p)); }
};
// @lc code=end
