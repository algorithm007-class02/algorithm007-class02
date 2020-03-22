class Solution {
    public int[] plusOne(int[] digits) {
        int carry = 1;
        int right = digits.length-1;
        while(carry > 0 && right >= 0){
            int sum  = digits[right]+carry;
            carry = sum/10;
            digits[right] = sum%10;
            right--;
        }
        if(carry>0){
            int[] result = new int[digits.length+1];
            result[0] = carry;
            return result;
        }else{
            return digits;
        }
    }
}