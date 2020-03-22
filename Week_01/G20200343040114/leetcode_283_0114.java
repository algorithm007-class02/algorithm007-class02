/*
283. 移动零
给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。

示例:

输入: [0,1,0,3,12]
输出: [1,3,12,0,0]
说明:

必须在原数组上操作，不能拷贝额外的数组。
尽量减少操作次数
https://leetcode-cn.com/problems/move-zeroes/
*/
class Solution {
    public void moveZeroes(int[] nums) {
        int lastZeroIndex = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                nums[lastZeroIndex++] = nums[i];
            }
        }
        for (int j = lastZeroIndex; j < nums.length; j++) {
            nums[j] = 0;
        }

    }

    /*
    *    最优解，就是保证闭区间 [lastNonZeroFoundAt, cur] 元素都为 0； 有点像“三路快排”；
    *    void moveZeroes(vector<int>& nums) {
    *        for (int lastNonZeroFoundAt = 0, cur = 0; cur < nums.size(); cur++) {
    *            if (nums[cur] != 0) {
    *                swap(nums[lastNonZeroFoundAt++], nums[cur]);
    *            }
    *        }
    *    }

    *    作者：LeetCode
    *    链接：https://leetcode-cn.com/problems/move-zeroes/solution/yi-dong-ling-by-leetcode/
    *    来源：力扣（LeetCode）
    *    著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
    */
}