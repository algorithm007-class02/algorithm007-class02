# -*- coding:utf-8 -*-


class Solution:
    def climbStairs(self, n: int) -> int:
        if n < 3:
            return n
        climb_f, i = [1, 2], 3
        while i <= n:
            climb_f[0], climb_f[1] = climb_f[1], climb_f[0] + climb_f[1]
            i += 1
        return climb_f[1]
