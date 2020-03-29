class Solution {
    public int[] plusOne(int[] digits) {
        for (int i = digits.length - 1; i >= 0; i--) {
            int number = digits[i] + 1;

            if (number == 10) {
                digits[i] = 0;
                if (i == 0) {
                    int[] newArr = new int[digits.length + 1];
                    newArr[0] = 1;
                    return newArr;
                }
            } else {
                digits[i] = number;
                break;
            }
        }
        return digits;
    }
}