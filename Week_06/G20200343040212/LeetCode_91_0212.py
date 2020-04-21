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
class Solution:
    def numDecodings(self, s: str) -> int:
        if s == '0':
            return 0
        # 构造一个n+1 长度的数组
        dp = [0] * (len(s) + 1)
        # 为了第二个元素方便计算
        dp[0] = 1
        # 第一个元素
        dp[1] = int(s[0] != '0')

        for i in range(2, len(s) + 1):
            # dp = df[i-1] + dp[i-2]
            dp[i] = dp[i - 2] * int(9 < int(s[i - 2:i]) < 27) + dp[i - 1] * int(int(s[i - 1]) > 0)
        return dp[-1]

# leetcode submit region end(Prohibit modification and deletion)
