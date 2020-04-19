#
# @lc app=leetcode.cn id=77 lang=python3
#
# [77] 组合
#

# @lc code=start
class Solution:
    def combine(self, n: int, k: int) -> List[List[int]]:
        res = []
        def generate(i, k, tmp):
            if k == 0:
                res.append(tmp)
                return
            for j in range(i, n + 1):
                generate(j + 1, k - 1, tmp + [j])
        generate(1, k, [])
        return res


# 初见思路1：回溯算法
# 之前考虑用删除掉之前元素的列表进行传递，但是报错
# 看过题解之后直接用参数生成range来进行传递  

# @lc code=end

