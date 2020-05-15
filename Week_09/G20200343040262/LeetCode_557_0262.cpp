/*
 * @lc app=leetcode.cn id=557 lang=cpp
 *
 * [557] 反转字符串中的单词 III
 */

// @lc code=start
class Solution {
public:
    string reverseWords(string s) {
        int n = s.size();
        int begin = 0, end;
        for (int i = 0; i < n + 1; ++i) {
            if (s[i] == ' ' || s[i] == '\0') {
                for (end = i - 1; begin < end; ++begin, --end) {
                    swap(s[begin], s[end]);
                }
                begin = i + 1;
            }
        }
        return s;
    }
};
// @lc code=end
