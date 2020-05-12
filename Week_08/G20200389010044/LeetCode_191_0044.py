# 1. 手动遍历

# 2. fotmat()

# 3. bin().count('1')

# 4. 位运算

# 5. 位运算优化 - Brain Kernighan Algorithm
class Solution:
    def hammingWeight(self, n: int) -> int:
        # 1. 暴力遍历
        # res, s = 0, bin(n)
        # for char in s:
        #     if char == '1':
        #         res += 1
        # return res

        # 3. bin().count()
        # return bin(n).count('1')

        # 4. 位运算
        # res = 0
        # while n:
        #     if n & 1 == 1:
        #         res += 1
        #     n >>= 1
        # return res

        # # 5. 位运算优化
        # res = 0
        # while n:
        #     n &= (n-1)
        #     res += 1
        # return res

        # 6. pythonic
        # return sum(1 for i in bin(n)[2:] if i>'0')
        return bin(n).count('1')