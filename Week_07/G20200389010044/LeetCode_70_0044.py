class Solution:
    res = ['#'] * 1000000
    def climbStairs(self, n: int) -> int:
        '''
        1. 动态优化，自底向上计算
        2. 递归+备忘录缓存，自顶向下递归
        '''
        # dp = [1, 2, 3]
        # if n <= 3: return dp[n-1]
        # for i in range(3, n):
        #     dp.append(dp[-1] + dp[-2])
        # return dp[-1]

        if n <= 3: return n
        
        self.res[0], self.res[1], self.res[2] = 1, 2, 3
        if self.res[n-1] != '#':
            return self.res[n-1]
        else:
            self.res[n-1] = self.climbStairs(n-1) + self.climbStairs(n-2)
            return self.res[n-1]








