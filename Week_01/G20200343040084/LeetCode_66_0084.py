class Solution:
    def plusOne(self, digits):
        array_int = int("".join([str(v) for v in digits]))
        array_int += 1
        array_int_list = [int(i) for i in str(array_int)]
        return array_int_list