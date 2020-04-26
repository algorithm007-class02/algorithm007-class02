class Solution:
    def numDecodings(self, s: str) -> int:
        '''
        长度为1时，只在s[0] == '1'时res = 0, 其余res = 1
        从第二个字符开始：
        s[i-1]+s[i]如果是两位数，则这个串有3种分配的方案，然后与prev'prev的解码数排列组合
            case 1: 与前者合并
            case 2: 单独解码
            case 3: 如果有后面的字符, 且s[i] in "12", 可与后者合并
        其中有一种情况特殊，就是10,只有一种解码方案
        '''
        '''
        爬楼梯问题变体
        dp[n] = dp[n-1] * 1 + dp[n-2] * (1 or 2)
        '''
        # pp, prev = 1, int(s[0] != '0')
        # for i in range(1, len(s)):
        #     pp, prev = prev, pp * (9 < int(s[i-1:i+1]) <= 26) + prev * (int(s[i]) > 0)
        # return prev

        # # 显式逻辑版
        # pp, prev = 1, int(s[0] != '0')
        # for i in range(1, len(s)):
        #     tmp = prev
        #     if 9 < int(s[i-1:i+1]) <= 26:
        #         # 前后可作为解码
        #         if s[i] != '0':
        #             prev += pp
        #         else:
        #             prev = pp
        #     else:
        #         if s[i] == '0':
        #         # 前后不可解码，而s[i]却为必须前后解码的'0'
        #             prev = 0
        #         # 其余情况保持不变，只能单独解码
        #         # 后后解码放在下一个字符的前后解码考虑
        #     pp = tmp
        # return prev