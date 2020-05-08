class Solution:
    def climbStairs(self, n: int) -> int:
        if n<=2:
            return n
        states = [0]*n
        states[0] = 1
        states[1] = 2
        for i in range(2,n):
            states[i] = states[i-1]+states[i-2]
        return states[-1]