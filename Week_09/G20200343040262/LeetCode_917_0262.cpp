/*
 * @lc app=leetcode.cn id=917 lang=cpp
 *
 * [917] 仅仅反转字母
 */

// @lc code=start
class Solution {
public:
    string reverseOnlyLetters(string S) {
        int i = 0, j = S.size() - 1;
        while (i < j) {
            while (i < j && !isalpha(S[i])) {
                ++i;
            }
            while (i < j && !isalpha(S[j])) {
                --j;
            }
            if (i < j) {
                S[i] ^= S[j];
                S[j] ^= S[i];
                S[i] ^= S[j];
                ++i;
                --j;
            }
        }
        return S;
    }
};
// @lc code=end
