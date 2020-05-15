/*
 * @lc app=leetcode.cn id=58 lang=cpp
 *
 * [58] 最后一个单词的长度
 */

// @lc code=start
class Solution {
public:
    int lengthOfLastWord(string s) {
        int end = s.length() - 1;
        while (end >= 0 && s[end] == ' ')
            end--;
        if (end < 0)
            return 0;
        int start = end;
        while (start >= 0 && s[start] != ' ')
            start--;
        return end - start;
    }
};
// @lc code=end
