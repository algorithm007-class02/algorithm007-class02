/**
 * Created by haoyubian on 2020/3/15.
 */
public class LeetCode_7_0018 {

    public int[] plusOne(int[] digits) {
        return plusOne(digits, digits.length - 1);
    }

    private int[] plusOne(int[] digits, int k) {
        if (k < 0) {
            int[] newDigits = new int[digits.length + 1];
            newDigits[0] = 1;
            for(int i = 1; i < digits.length +1 ; i++){
                newDigits[i] = digits[i-1];
            }
            return newDigits;
        }else{
            if (digits[k] + 1 >= 10){
                digits[k] = (digits[k]+1) %10;
                return plusOne(digits, k-1);
            }else {
                digits[k] += 1;
                return digits;
            }

        }
    }



}
