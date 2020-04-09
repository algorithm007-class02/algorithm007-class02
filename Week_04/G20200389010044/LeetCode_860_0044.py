# 1. 模拟
#   顾客付款只可能是[5, 10, 20]
#   对应找零为[0, 5, 10+5/ 5+5+5]
#   如果是5元，直接收下，无需找零
#   如果是10元，检查是否有5元零钱
#   如果是20元，检查是否有1张10元和1张5元，或者是否有3张5元

class Solution:
    def lemonadeChange(self, bills: List[int]) -> bool:
        # change = {5:0, 10:0, 20:0}
        # for bill in bills:
        #     if bill == 5:
        #         change[5] +=1
        #     elif bill == 10:
        #         if change[5] >= 1:
        #             change[10] += 1
        #             change[5] -= 1
        #         else:
        #             return False
        #     else:
        #         if change[5] >= 1 and change[10] >= 1:
        #             change[20] += 1
        #             change[5] -= 1
        #             change[10] -= 1
        #         elif change[5] >= 3:
        #             change[20] -= 1
        #             change[5] -= 3
        #         else:
        #             return False
        # return True

        q = collections.deque()
        for bill in bills:
            if bill == 5:
                q.appendleft(bill)
            if bill == 10:
                if not q: return False
                if q[0] == 5:
                    q.popleft()
                    q.append(bill)
                else:
                    return False
            if bill == 20:
                if not q: return False
                while bill > 10:
                    if not q: return False
                    bill -= q.pop()
                if not q: return False
                if bill > 5:
                    bill -= q.popleft()
                if bill != 5: return False
        return True