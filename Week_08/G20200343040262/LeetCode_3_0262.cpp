/*
 * @lc app=leetcode.cn id=3 lang=cpp
 *
 * [3] 无重复字符的最长子串
 */

// @lc code=start
class Solution {
public:
    int lengthOfLongestSubstring(string s) {
        int n = s.size();
        unordered_set<char> hashset;
        // 右指针，初始值 -1
        int right = -1, res = 0;
        // 左指针
        for (int left = 0; left < n; ++left) {
            // 左指针右移一格，即删除一个字符
            if (left != 0) {
                hashset.erase(s[left - 1]);
            }
            // 不断移动右指针
            while (right < n - 1 && !hashset.count(s[right + 1])) {
                hashset.insert(s[right + 1]);
                ++right;
            }
            res = max(res, right - left + 1);
        }
        return res;
    }
};
// @lc code=end

