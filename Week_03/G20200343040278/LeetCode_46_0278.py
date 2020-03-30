#
# @lc app=leetcode.cn id=46 lang=python3
#
# [46] 全排列
#

# @lc code=start
class Solution:
    def permute(self, nums: List[int]) -> List[List[int]]:
        res = []
        def generate(num, tmp):
            if not num:
                res.append(tmp)
                return           
            for i in range(len(num)):
                generate(num[:i] + num[i + 1:], tmp + [num[i]])
        generate(nums, [])
        return res


# @lc code=end

