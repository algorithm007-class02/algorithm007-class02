/**
 * 66. 加一
给定一个由整数组成的非空数组所表示的非负整数，在该数的基础上加一。

最高位数字存放在数组的首位， 数组中每个元素只存储单个数字。

你可以假设除了整数 0 之外，这个整数不会以零开头。

示例 1:

输入: [1,2,3]
输出: [1,2,4]
解释: 输入数组表示数字 123。
示例 2:

输入: [4,3,2,1]
输出: [4,3,2,2]
解释: 输入数组表示数字 4321。
https://leetcode-cn.com/problems/plus-one/
 */
class Solution {
    public int[] plusOne(int[] digits) {
        int n = digits.length;
        digits[n - 1] = digits[n - 1] + 1;
        int carry = (digits[n - 1]) / 10;
        if (carry == 1) {
            digits[n - 1] = 0;
            for (int i = n - 2; i >= 0; i--) {
                digits[i] = carry + digits[i];
                carry = (digits[i]) / 10;
                if (carry == 1) {
                    digits[i] = 0;
                } else {
                    break;
                }
            }
            if (carry == 1) {
                int[] res = new int[n + 1];
                res[0] = carry;
                for (int i = 0; i < n; i++) {
                    res[i + 1] = digits[i];
                }
                return res;
            }
            return digits;
        } else {
            return digits;
        }
    }

    /**
     * 大佬的思路
     * class Solution {
     *       public int[] plusOne(int[] digits) {
     *           for (int i = digits.length - 1; i >= 0; i--) {
     *               digits[i]++;
     *               digits[i] = digits[i] % 10;
     *               if (digits[i] != 0) return digits;
     *           }
     *           digits = new int[digits.length + 1];
     *           digits[0] = 1;
     *           return digits;
     *       }
     *   }
     *
     *   作者：yhhzw
     *   链接：https://leetcode-cn.com/problems/plus-one/solution/java-shu-xue-jie-ti-by-yhhzw/
     *   来源：力扣（LeetCode）
     *   著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */
}