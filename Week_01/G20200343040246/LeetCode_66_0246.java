package Week_01.G20200343040246;

public class LeetCode_66_0246 {
    public static void main(String[] args) {
        
    }

    public class Solution {
        public int[] plusOne(int[] digits) {
            // O(n)
            for (int i = digits.length - 1; i > 0; i--) {
                if (digits[i] == 9) {
                    digits[i] = 0;
                } else {
                    digits[i]++;
                    return digits;
                }
            }

            int[] newDigits = new int[digits.length+1];
            newDigits[0] = 1;
            return newDigits;
        }
    }

}