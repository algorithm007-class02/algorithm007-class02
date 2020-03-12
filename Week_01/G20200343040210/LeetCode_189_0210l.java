/**  189. 旋转数组
 *给定一个数组，将数组中的元素向右移动 k 个位置，其中 k 是非负数。
 *
 * 示例 1:
 *
 * 输入: [1,2,3,4,5,6,7] 和 k = 3
 * 输出: [5,6,7,1,2,3,4]
 * 解释:
 * 向右旋转 1 步: [7,1,2,3,4,5,6]
 * 向右旋转 2 步: [6,7,1,2,3,4,5]
 * 向右旋转 3 步: [5,6,7,1,2,3,4]
 * 示例 2:
 *
 * 输入: [-1,-100,3,99] 和 k = 2
 * 输出: [3,99,-1,-100]
 * 解释:
 * 向右旋转 1 步: [99,-1,-100,3]
 * 向右旋转 2 步: [3,99,-1,-100]
 * 说明:
 *
 * 尽可能想出更多的解决方案，至少有三种不同的方法可以解决这个问题。
 * 要求使用空间复杂度为 O(1) 的 原地 算法。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/rotate-array
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

/**
 * 暴力解法，通过循环，每次向右移动一个位置
 * 时间复杂度：O(n*k)，数组长度n,移动一个位置遍历n次，移动k个位置，遍历 n*k次
 * 空间复杂度 O(1)
 */
class Solution {
    public void rotate(int[] nums, int k) {
        int temp,prenum;
        for ( int i = 0; i < k; ++i) {
            prenum = nums[nums.length -1];
            for ( int j = 0; j < nums.length; ++j){
                temp = nums[j];
                nums[j] = prenum;
                prenum = temp;
            }
        }
    }
}

/**
 * 添加新数组求解
 * 时间复杂度：O(n)    虽然用了两个for循环，但是没有嵌套一起
 * 空间复杂度：O(n)     额外使用了长度n的数组newArr
 */
class Solution {
    public void rotate(int[] nums, int k) {
        int[] newArr = new int[nums.length];
        for ( int i = 0; i < nums.length; ++i) {
            newArr[ (i + k) % nums.length] = nums[i];
        }
        for ( int j = 0; j < nums.length; ++j) {
            nums[j] = newArr[j];
        }
    }
}

/**
 *  反转
 *  时间复杂度：O(n)   n个元素完全反转1次，部分反转2次
 *  空间复杂度：O(1)   没有额外的空间
 */
class Solution {
    public void rotate(int[] nums, int k) {
        k %= nums.length;
        reverse(nums, 0, nums.length-1);
        reverse(nums, 0, k-1);
        reverse(nums, k,nums.length-1);
    }

    public void reverse(int[] nums, int begin, int end) {
        while (begin < end) {
            int temp = nums[begin];
            nums[begin] = nums[end];
            nums[end] = temp;
            begin++;
            end--;
        }
    }
}

class Solution {
    public void rotate(int[] nums, int k) {
        k %= nums.length;
        reverse(nums, 0, nums.length-1);
        reverse(nums, 0, k-1);
        reverse(nums, k,nums.length-1);
    }

    public void reverse(int[] nums, int begin, int end) {
        int i = begin;
        for (int j = end; j >= 0; --j) {
            if (i < j) {
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
                ++i;
            }
        }
    }
}