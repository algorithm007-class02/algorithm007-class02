class Solution:
    def plusOne(self, digits: List[int]) -> List[int]:
        num = self.to_num(digits)
        return self.to_digits(num + 1)

    def to_num(self, digits):
        num = 0

        for digit in digits:
            num *= 10
            num += digit

        return num

    def to_digits(self, num):
        return [int(digit) for digit in str(num)]
