class LeetCode_7_0068 {
    //从后往前遍历
    public int[] plusOne(int[] digits) {
        boolean flag = true;
        for (int i = digits.length - 1; i >= 0; i--) {
            if (!flag) {
                return digits;
            }
            if (digits[i] < 9) {
                digits[i]++;
                flag = false;
            } else {
                digits[i] = 0;
                flag = true;
            }
        }
        if (flag) {
            int[] result = new int[digits.length+1];
            result[0] = 1;
            return result;
        }
        return digits;
    }
}