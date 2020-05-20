/*
 * @lc app=leetcode.cn id=5 lang=cpp
 *
 * [5] 最长回文子串
 */

// @lc code=start
/**回文中心的两侧互为镜像。
 * 因此，回文可以从他的中心展开，并且只有 2n-1 个这样的中心
 * （一个元素为中心的情况有 n 个，两个元素为中心的情况有 n-1 个）
 * */
class Solution {
public:
    string longestPalindrome(string s) {
        int len = s.size();
        if (len == 0 || len == 1)
            return s;
        int start = 0; //记录回文子串起始位置
        int end = 0;   //记录回文子串终止位置
        int mlen = 0;  //记录最大回文子串的长度
        for (int i = 0; i < len; i++) {
            int len1 = expendaroundcenter(s, i, i);     //一个元素为中心
            int len2 = expendaroundcenter(s, i, i + 1); //两个元素为中心
            mlen = max(max(len1, len2), mlen);
            if (mlen > end - start + 1) {
                start = i - (mlen - 1) / 2;
                end = i + mlen / 2;
            }
        }
        return s.substr(start, mlen);
        //该函数的意思是获取从start开始长度为mlen长度的字符串
    }

private:
    int expendaroundcenter(string s, int left, int right)
    //计算以left和right为中心的回文串长度
    {
        int L = left;
        int R = right;
        while (L >= 0 && R < s.length() && s[R] == s[L]) {
            L--;
            R++;
        }
        return R - L - 1;
    }
};
// @lc code=end
