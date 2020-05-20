class Solution:
    def reverseStr(self, s: str, k: int) -> str:
        res, len_s = list(s), len(s)
        for i in range(0, len_s, 2*k):
            left = i
            right = min(left + k - 1, len_s - 1)
            while left < right:
                res[left], res[right] = res[right], res[left]
                left += 1
                right -= 1
        return "".join(res)