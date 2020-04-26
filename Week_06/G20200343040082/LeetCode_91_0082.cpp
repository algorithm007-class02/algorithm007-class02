/*

91. 解码方法

一条包含字母 A-Z 的消息通过以下方式进行了编码:

'A' -> 1
'B' -> 2
...
'Z' -> 26

给定一个只包含数字的非空字符串，请计算解码方法的总数。


输入: "12"
输出: 2
解释: 它可以解码为 "AB"（1 2）或者 "L"（12）。


*/

class Solution {
public:
    int numDecodings(string s) {

        if (s[0] == '0') 
            return 0;

        int pre = 1, curr = 1;

        for (int i = 1; i < s.size(); i++) {
            int tmp = curr;
            if (s[i] == '0') {
                if (s[i - 1] == '1' || s[i - 1] == '2') 
                    curr = pre;
                else 
                    return 0;
            } else if (s[i - 1] == '1' || (s[i - 1] == '2' && s[i] >= '1' && s[i] <= '6'))
                curr = curr + pre;

            pre = tmp;
        }

        return curr;
    }
};
