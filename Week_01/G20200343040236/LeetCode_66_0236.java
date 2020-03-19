class LeetCode_66_0236 {
    public int[] plusOne(int[] digits) {
        int index = digits.length - 1;
        digits[index] = digits[index] + 1;
        while (index > 0) {
            if (digits[index] >= 10) {
                int divide = digits[index] / 10;
                int mod = digits[index] % 10;
                digits[index] = mod;
                digits[index - 1] = digits[index - 1] + divide;
            }
            index--;
        }

        if (digits[0] >= 10) {
            int[] newDigits = new int[digits.length + 1];
            int divide = digits[0] / 10;
            int mod = digits[0] % 10;
            digits[0] = mod;
            newDigits[0] = divide;
            for (int i = 1; i < newDigits.length; i++) {
                newDigits[i] = digits[i - 1];
            }
            return newDigits;
        }
        return digits;
    }
}