# 1. map函数来回倒

# 2. 遍历手动累加

# 3. 直接加一，然后遍历处理进位问题


class Solution:
    def plusOne(self, digits: List[int]) -> List[int]:
        # map函数来回倒
        # str_lst = list(map(str, digits))
        # str_num = "".join(str_lst)
        # num = int(str_num)
        # num += 1
        # str_lst = list(str(num))
        # res = list(map(int, str_lst))
        # return res

        # 手动累加
        # size = len(digits)
        # num = 0
        # i = 0
        # for digit in digits:
        #     num += digit * 10 ** (size-1-i)
        #     i += 1
        # num += 1
        # lst = list(map(int, list(str(num))))
        # return lst

        # 直接加一再处理进位
        size = len(digits)
        # 加一
        digits[size-1] += 1
        # 遍历处理进位
        for i in range(size-1, -1, -1):
            if digits[i] > 9:
                digits[i] = 0
                if i != 0:
                    digits[i-1] += 1
                else:
                    digits[:] = [1] + digits
        return digits