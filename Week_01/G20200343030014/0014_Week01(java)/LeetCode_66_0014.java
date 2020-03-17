/**
 * @Auther: yys
 * @Date: 2020/3/14 11:28
 * @Description:
 */

//一遍遍历+判断
public class Solution2 {

    public int[] plusOne(int[] digits) {

        for (int i = digits.length-1; i >= 0 ; i--) {

            if (digits[i] != 9){
                digits[i]++;
                return digits;
            }
            else {
                digits[i] = 0;
            }
        }

        digits = new int[digits.length+1];
        digits[0] = 1;

        return digits;
    }
}
