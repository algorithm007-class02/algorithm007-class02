class Solution:
    def generateParenthesis(self, n: int) -> list:
        self.res = []
        self.generate(0, 0, n, "")
        return self.res

    def generate(self, left, right, n, s):
        if left == n and right == n:
            self.res.append(s)
            return

        if left < n:
            self.generate(left + 1, right, n, s + "(")
        if left > right:
            self.generate(left, right + 1, n, s + ")")