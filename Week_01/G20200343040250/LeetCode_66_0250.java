class Solution {
    public int[] plusOne(int[] digits) {
        // 考虑进位的情况，循环判断，如果是999这种情况，直接生成新数组10000
        int length = digits.length;

        for (int i = length - 1; i >= 0; i--) {
            digits[i]++;
            digits[i] = digits[i] % 10;
            if (digits[i] != 0) {
                return digits;
            }
        }

        digits = new int[length + 1];
        digits[0] = 1;
        return digits;
    }
}