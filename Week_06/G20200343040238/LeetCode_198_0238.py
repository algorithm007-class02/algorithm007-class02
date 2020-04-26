class Solution:
    def rob(self, nums: list) -> int:
        prev = 0
        curr = 0
        for n in nums:
            prev, curr = curr, max(curr, prev + n)
        return curr
