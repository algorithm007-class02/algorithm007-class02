/**
 * 加一，给定一个由整数组成的非空数组所表示的非负整数，在该数的基础上加一，最高位数字存放在数组的首位， 数组中每个元素只存储单个数字
 * 思路：
 * 从末尾开始遍历 + 1操作，如果+ 1 后不能整除10 说明当前位置的值不为9，不需要向前+1 ，立即返回数组。
 * 当遍历完整个数组还没有返回值，说明原先整数的第一位为9 ，则需要把数组长度+1第0位设置为1，拼接处理后的数组
 */
public class LeetCode_66_0222 {

    public int[] plusOne(int[] digits) {
        for (int i = digits.length - 1; i >= 0; i--) {
            digits[i]++;
            if (digits[i] % 10 == 0) {
                digits[i] = digits[i] % 10;
            } else {
                return digits;
            }
        }
        int[] result = new int[digits.length + 1];
        result[0] = 1;
        for (int i = 0; i < digits.length; i++) {
            result[i + 1] = digits[i];
        }
        return result;
    }


    public int[] plusOneRe (int[] digits) {
        int[] otherNums = new int[]{1};
        int[] tempNums = new int[digits.length > otherNums.length ? digits.length + 1: otherNums.length + 1];
        if (digits.length > otherNums.length) {
            addZero(otherNums, tempNums);
            andTwoNums(tempNums, digits);
            return tempNums[0] != 0 ? tempNums : digits;
        } else {
            addZero(digits, tempNums);
            andTwoNums(tempNums, otherNums);
            return tempNums[0] != 0 ? tempNums : otherNums;
        }
    }

    /**
     * 将数组nums放入tempNums 中
     * @param nums
     * @param tempNums
     */
    public void addZero(int[] nums,int[] tempNums) {
        if (nums.length > tempNums.length) return;
        for (int i = tempNums.length - 1; i > tempNums.length - nums.length - 1; i--) {
            tempNums[i] = nums[i - tempNums.length + nums.length];
        }
    }

    /**
     * 两个数组相加
     * @param nums
     * @param lessLengthNums
     */
    private void andTwoNums(int[] nums, int[] lessLengthNums) {
        for (int i = lessLengthNums.length - 1; i >= 0; i--) {
            int temp = nums[i + 1] + lessLengthNums[i];
            nums[i + 1] = temp % 10;
            lessLengthNums[i] = temp % 10;
            nums[i] += temp / 10;
        }
    }

}