class Solution:
    def minimumTotal(self, triangle: list) -> int:
        n = len(triangle)
        if not n or len(triangle[0]) == 0:
            return 0
        for i in range(n - 2, -1, -1):
            for j in range(len(triangle[i])):
                triangle[i][j] += min(triangle[i + 1][j], triangle[i + 1][j + 1])
        return triangle[0][0]
