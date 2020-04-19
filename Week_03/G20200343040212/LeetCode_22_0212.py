# 给出 n 代表生成括号的对数，请你写出一个函数，使其能够生成所有可能的并且有效的括号组合。
#
#  例如，给出 n = 3，生成结果为：
#
#  [
#   "((()))",
#   "(()())",
#   "(())()",
#   "()(())",
#   "()()()"
# ]
#
#  Related Topics 字符串 回溯算法

from typing import List


# leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    def __init__(self):
        self.result = []

    def generateParenthesis(self, n: int) -> List[str]:
        self._generate(0, 0, n, "")
        return self.result

    def _generate(self, left, right, n, s):
        # terminator
        if left == n and right == n:
            # print(s)
            self.result.append(s)
        # process
        s1 = s + "("
        s2 = s + ")"
        # drill down
        if left < n:
            self._generate(left + 1, right, n, s1)
        if left > right and right < n:
            self._generate(left, right + 1, n, s2)
        # reverse states


# leetcode submit region end(Prohibit modification and deletion)

if __name__ == '__main__':
    s = Solution()
    s.generateParenthesis(3)
