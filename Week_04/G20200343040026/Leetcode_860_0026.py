# 贪心解法
class Solution:
    def lemonadeChange(self, bills: List[int]) -> bool:
        if bills == []:
            return False
        cash = {5: 0, 10: 0}
        for num in bills:
            if num == 5:
                cash[5] += 1
            elif num == 10:
                cash[5] -= 1
                cash[10] += 1
            else:
                if cash[10] > 0:
                    cash[10] -= 1
                    cash[5] -= 1
                else:
                    cash[5] -= 3
            if cash[5] < 0:
                return False

        return True