/**  加一   66
 * 给定一个由整数组成的非空数组所表示的非负整数，在该数的基础上加一。
 *
 * 最高位数字存放在数组的首位， 数组中每个元素只存储单个数字。
 *
 * 你可以假设除了整数 0 之外，这个整数不会以零开头。
 *
 * 示例 1:
 *
 * 输入: [1,2,3]
 * 输出: [1,2,4]
 * 解释: 输入数组表示数字 123。
 * 示例 2:
 *
 * 输入: [4,3,2,1]
 * 输出: [4,3,2,2]
 * 解释: 输入数组表示数字 4321。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/plus-one
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

/**
 *  时间复杂度：O(n)    最少执行一次，最差执行数组长度n
 *  空间复杂度：O(n)    使用了额外的 n+1长度的数组
 */
class Solution {
    public int[] plusOne(int[] digits) {
        for (int i = digits.length - 1; i >= 0; --i) {
            ++digits[i];
            digits[i] %= 10;
            if (digits[i] != 0) return digits;
        }
        digits = new int[digits.length + 1];
        digits[0] = 1;
        return digits;
    }
}

/**
 * 尝试递归方法
 * class Solution {
 *     public int[] plusOne(int[] digits) {
 *         digits = plus(digits,digits.length-1);
 *         return digits;
 *     }
 *     public int[] plus(int[] digits, int i) {
 *         if(digits[i] != 9){
 *             digits[i]++;
 *             return digits;
 *         }else{
 *             digits[i] = 0;
 *             if (i == 0) {
 *                 int[] newArr= new int[digits.length + 1];
 *                 newd[0] = 1;
 *                 return newd;
 *             }
 *             return plus(digits,i-1);
 *         }
 *     }
 * }
 */
