#
# @lc app=leetcode.cn id=66 lang=python3
#
# [66] 加一
#

# @lc code=start
class Solution:
    def plusOne(self, digits) :
        for i in range(len(digits)-1,-1,-1):
            if digits[i]!=9:
                digits[i]+=1
                return digits
            digits[i]=0
            if i==0: digits=[1]+digits[:]
        return digits
# @lc code=end


if __name__ == "__main__":
    so=Solution()
    digits=[1,2,3]
    print(so.plusOne(digits))


# def plusOne(self, digits) :
#         str_dig=''
#         for i in digits:
#             str_dig+=str(i)
#         str_dig=int(str_dig)
#         str_dig+=1
#         str_dig=str(str_dig)
#         str_dig=[int(i) for i in str_dig]
#         str_dig=list(str_dig)
#         return str_dig


# def plusOne(self, digits) :
#         for i in range(len(digits)-1,-1,-1):
#             if digits[i]!=9:
#                 digits[i]+=1
#                 return digits
#             digits[i]=0
#             if i==0: digits=[1]+digits[:]
#         return digits