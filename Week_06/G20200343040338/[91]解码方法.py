# 一条包含字母 A-Z 的消息通过以下方式进行了编码： 
# 
#  'A' -> 1
# 'B' -> 2
# ...
# 'Z' -> 26
#  
# 
#  给定一个只包含数字的非空字符串，请计算解码方法的总数。 
# 
#  示例 1: 
# 
#  输入: "12"
# 输出: 2
# 解释: 它可以解码为 "AB"（1 2）或者 "L"（12）。
#  
# 
#  示例 2: 
# 
#  输入: "226"
# 输出: 3
# 解释: 它可以解码为 "BZ" (2 26), "VF" (22 6), 或者 "BBF" (2 2 6) 。
#  
#  Related Topics 字符串 动态规划


# leetcode submit region begin(Prohibit modification and deletion)
"""
>>> Solution().numDecodings('12')
2
>>> Solution().numDecodings('226')
3
>>> Solution().numDecodings('0')
0
>>> Solution().numDecodings('10')
1
>>> Solution().numDecodings('24726')
4
>>> Solution2().numDecodings('12')
2
>>> Solution2().numDecodings('226')
3
>>> Solution2().numDecodings('0')
0
>>> Solution2().numDecodings('10')
1
>>> Solution2().numDecodings('24726')
4
"""
from functools import lru_cache


class Solution:
    def numDecodings(self, s: str) -> int:
        codes = {str(x + 1) for x in range(26)}
        a, b = 1, 1
        p = '0'

        for c in s:
            pc = p + c
            p = c

            if c in codes and pc in codes:
                a, b = b, a + b
            elif c in codes:
                a, b = b, b
            elif pc in codes:
                a, b = b, a
            else:
                a, b = b, 0

        return b


class Solution2:
    def numDecodings(self, s: str) -> int:
        codes = {str(x + 1) for x in range(26)}

        @lru_cache(maxsize=None)
        def _numDecoding(i: int) -> int:
            if i >= len(s):
                return 1

            if s[i] in codes and i < len(s) - 1 and s[i:i + 2] in codes:
                return _numDecoding(i + 1) + _numDecoding(i + 2)
            elif s[i] in codes:
                return _numDecoding(i + 1)
            elif i < len(s) - 1 and s[i:i + 2] in codes:
                return _numDecoding(i + 2)
            else:
                return 0

        return _numDecoding(0)

# leetcode submit region end(Prohibit modification and deletion)
