/*
 * @lc app=leetcode.cn id=8 lang=cpp
 *
 * [8] 字符串转换整数 (atoi)
 */

// @lc code=start
class Solution {
public:
    int myAtoi(string str) {
        int res = 0;
        int flag = 1;
        int i = 0; // index
        while (str[i] == ' ')
            i++;
        if (str[i] == '-')
            flag = -1;
        if (str[i] == '-' || str[i] == '+')
            i++;
        while (i < str.size() && isdigit(str[i])) {
            int r = str[i] - '0';
            if (res > INT_MAX / 10 || (res == INT_MAX / 10 && r > 7)) {
                return flag > 0 ? INT_MAX : INT_MIN;
            }
            res = res * 10 + r;
            i++;
        }
        return flag > 0 ? res : -res;
    }
};
// @lc code=end
