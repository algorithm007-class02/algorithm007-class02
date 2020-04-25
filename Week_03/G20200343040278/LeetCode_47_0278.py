#
# @lc app=leetcode.cn id=47 lang=python3
#
# [47] 全排列 II
#

# @lc code=start
class Solution:
    def permuteUnique(self, nums: List[int]) -> List[List[int]]:
        res = []
        nums.sort()
        def generate(num, tmp):
            if not num:
                res.append(tmp)
                return           
            for i in range(len(num)):
                if i > 0 and num[i] == num[i - 1]:
                    continue
                generate(num[:i] + num[i + 1:], tmp + [num[i]])
        generate(nums, [])
        return res

# 初见思路1：
# 全排列1的代码返回一个set的列表
# 然而列表不可hash。。
# 思路2：添加重复判断
# 出现重复元素即跳过 


# @lc code=end

