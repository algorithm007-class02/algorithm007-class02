/**
 * 加一：
 * 给定一个由整数组成的非空数组所表示的非负整数，在该数的基础上加一。
 * 最高位数字存放在数组的首位， 数组中每个元素只存储单个数字
 * 你可以假设除了整数 0 之外，这个整数不会以零开头。
 */
class Solution {

    /**
     * 时间复杂度：O(n)
     * 空间复杂度：0(1)
     */
    public int[] plusOne(int[] digits) {
        for (int i = digits.length - 1; i >= 0; i--) {
            digits[i] += 1;
            digits[i] = digits[i] % 10;
            //加一进位后该数一定为0，如果不等于0说明没有进位，则运算结束返回结果
            if(digits[i] != 0){
                return digits;
            }
        }
        //处理[9]、[9,9]、[9,9,9]类似数组
        digits = new int[digits.length + 1];
        digits[0] = 1;
        return digits;
    }
}